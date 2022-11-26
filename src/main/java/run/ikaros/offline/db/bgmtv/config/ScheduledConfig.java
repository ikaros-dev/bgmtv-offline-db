package run.ikaros.offline.db.bgmtv.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
public class ScheduledConfig {

    @Scheduled(cron = "0 30 5 ? * WED")
    public void downloadGithubDumpFileAndSaveToDatabaseTask() {
        log.debug("start exec scheduled task: downloadGithubDumpFileAndSaveToDatabaseTask");

        log.debug("end exec scheduled task: downloadGithubDumpFileAndSaveToDatabaseTask");
    }

}
