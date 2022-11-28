package run.ikaros.offlinedb.bgmtv.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import run.ikaros.offlinedb.bgmtv.service.TaskService;

@Slf4j
@Configuration
@EnableScheduling
public class ScheduledConfig {

    private final TaskService taskService;
    public static final String URL = "https://github.com/bangumi/Archive/releases/download/archive/dump.zip";

    public ScheduledConfig(TaskService taskService) {
        this.taskService = taskService;
    }


    /**
     * 每周三5点半执行一次(GTM+8)
     *
     * @see <a href="https://github.com/bangumi/Archive">bgmtv archive</a>
     */
    @Scheduled(cron = "0 30 5 ? * WED")
    public void downloadGithubDumpFileAndSaveToDatabaseTask() {
        taskService.downloadGithubDumpFileAndSaveToDatabaseTask(URL);
    }



}
