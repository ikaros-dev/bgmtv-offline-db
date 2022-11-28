package run.ikaros.offlinedb.bgmtv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import run.ikaros.offlinedb.bgmtv.entity.CharacterEntity;
import run.ikaros.offlinedb.bgmtv.entity.EpisodeEntity;
import run.ikaros.offlinedb.bgmtv.entity.FileEntity;
import run.ikaros.offlinedb.bgmtv.entity.SubjectEntity;
import run.ikaros.offlinedb.bgmtv.utils.FileUtils;
import run.ikaros.offlinedb.bgmtv.utils.JsonUtils;
import run.ikaros.offlinedb.bgmtv.utils.SystemVarUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@Service
public class TaskService {

    private final HttpService httpService;
    private final SubjectService subjectService;
    private final EpisodeService episodeService;
    private final CharacterService characterService;

    public TaskService(HttpService httpService, SubjectService subjectService, EpisodeService episodeService, CharacterService characterService) {
        this.httpService = httpService;
        this.subjectService = subjectService;
        this.episodeService = episodeService;
        this.characterService = characterService;
    }

    public void downloadGithubDumpFileAndSaveToDatabaseTask(String zipUrl) {
        log.debug("start exec scheduled task: downloadGithubDumpFileAndSaveToDatabaseTask");

        FileEntity fileEntity = httpService.pull(zipUrl);
        String zipFilePath = SystemVarUtils.getCurrentAppDirPath() + File.separator + fileEntity.getUrl();
        File zipFile = new File(zipFilePath);
        String bgmtvArchiveDumpDirPath = SystemVarUtils.getCurrentAppCacheDirPath()
                + File.separator + "bgmtv-archive-dump";

        File bgmtvArchiveDumpDir = new File(bgmtvArchiveDumpDirPath);
        if (!bgmtvArchiveDumpDir.exists()) {
            bgmtvArchiveDumpDir.mkdirs();
        }

        try {
            if (!zipFile.exists()) {
                throw new FileNotFoundException("zip file not exist for path=" + zipFilePath);
            }
            FileUtils.unZipFile(zipFile, bgmtvArchiveDumpDirPath);
            parseFilesAndSave2Db(bgmtvArchiveDumpDir);

        } catch (IOException ioException) {
            log.error("unzip file fail", ioException);
        } finally {
            for (File file : bgmtvArchiveDumpDir.listFiles()) {
                if (file.exists()) {
                    file.delete();
                }
            }
            log.debug("end exec scheduled task: downloadGithubDumpFileAndSaveToDatabaseTask");
        }
    }

    public void parseFilesAndSave2Db(File bgmtvArchiveDumpDir) throws IOException {
        File[] files = bgmtvArchiveDumpDir.listFiles();
        for (File file : files) {
            String name = file.getName();
            switch (name) {
                case "subject.jsonlines": {
                    parseSubject(file);
                }
                case "episode.jsonlines": {
                    parseEpisode(file);
                }
                case "character.jsonlines": {
                    parseCharacter(file);
                }
                default:
                    ;
            }
            log.debug("parse current file success, name={}", name);
        }
    }

    private void parseCharacter(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int total = lines.size();
        int current = 1;
        for (String json : lines) {
            CharacterEntity characterEntity = JsonUtils.json2obj(json, CharacterEntity.class);
            characterService.save(characterEntity);
            log.debug("save character progress: {}/{}", current++, total);
        }
    }

    private void parseEpisode(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int total = lines.size();
        int current = 1;
        for (String json : lines) {
            EpisodeEntity episodeEntity = JsonUtils.json2obj(json, EpisodeEntity.class);
            episodeService.save(episodeEntity);
            log.debug("save episode progress: {}/{}", current++, total);
        }
    }


    private void parseSubject(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int total = lines.size();
        int current = 1;
        for (String json : lines) {
            SubjectEntity subjectEntity = JsonUtils.json2obj(json, SubjectEntity.class);
            subjectService.save(subjectEntity);
            log.debug("save subject progress: {}/{}", current++, total);
        }
    }
}
