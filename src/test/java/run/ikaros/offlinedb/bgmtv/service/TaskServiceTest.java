package run.ikaros.offlinedb.bgmtv.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    TaskService taskService;

    @Test
    void parseFilesAndSave2Db() throws IOException {
        String dirPath = "C:\\Users\\li-guohao\\Documents\\bgmtv\\target";
        taskService.parseFilesAndSave2Db(new File(dirPath));
    }
}