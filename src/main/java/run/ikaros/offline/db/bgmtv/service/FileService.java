package run.ikaros.offline.db.bgmtv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import run.ikaros.offline.db.bgmtv.entity.FileEntity;
import run.ikaros.offline.db.bgmtv.repository.FileRepository;
import run.ikaros.offline.db.bgmtv.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Slf4j
@Service
public class FileService {
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileEntity upload(@NonNull String originalFilename, @NonNull byte[] bytes) {
        Assert.hasText(originalFilename, "'originalFilename' must has text");
        Assert.notNull(bytes, "'bytes' must not null");

        final String md5 = FileUtils.checksum2Str(bytes, FileUtils.Hash.MD5);
        Optional<FileEntity> existFileEntityOptional = fileRepository.findByMd5(md5);
        if(existFileEntityOptional.isPresent()) {
            return existFileEntityOptional.get();
        }

        String postfix = FileUtils.parseFilePostfix(originalFilename);
        String uploadFilePath = FileUtils.buildAppUploadFilePath(postfix);
        try {
            Files.write(new File(uploadFilePath).toPath(), bytes);
            log.info("upload file to path: {}", uploadFilePath);
        } catch (IOException e) {
            final String msg = "upload file fail to path: " + uploadFilePath;
            throw new RuntimeException(msg, e);
        }

        String url = uploadFilePath
                .replace(System.getProperty("user.dir"), "")
                .replace("\\", "/");
        FileEntity fileEntity = new FileEntity();
        fileEntity.setName(originalFilename);
        fileEntity.setUrl(url);
        fileEntity.setMd5(md5);
        fileEntity.setSize(bytes.length);
        return fileRepository.saveAndFlush(fileEntity);
    }
}
