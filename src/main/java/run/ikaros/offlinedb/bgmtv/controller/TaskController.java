package run.ikaros.offlinedb.bgmtv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.ikaros.offlinedb.bgmtv.config.ScheduledConfig;
import run.ikaros.offlinedb.bgmtv.service.TaskService;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PutMapping
    public Boolean downloadGithubDumpFileAndSaveToDatabaseTask() {
        taskService.downloadGithubDumpFileAndSaveToDatabaseTask(ScheduledConfig.URL);
        return true;
    }
}
