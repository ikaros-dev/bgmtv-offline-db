package run.ikaros.offline.db.bgmtv.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import run.ikaros.offline.db.bgmtv.entity.FileEntity;
import run.ikaros.offline.db.bgmtv.service.HttpService;

@Slf4j
@Configuration
@EnableScheduling
public class ScheduledConfig {

    private final HttpService httpService;
    private final String url = "https://github.com/bangumi/Archive/releases/download/archive/dump.zip";

    public ScheduledConfig(HttpService httpService) {
        this.httpService = httpService;
    }

    @Scheduled(cron = "0 30 5 ? * WED")
    public void downloadGithubDumpFileAndSaveToDatabaseTask() {
        log.debug("start exec scheduled task: downloadGithubDumpFileAndSaveToDatabaseTask");
        FileEntity fileEntity = httpService.pull(url);



        log.debug("end exec scheduled task: downloadGithubDumpFileAndSaveToDatabaseTask");
    }

}
