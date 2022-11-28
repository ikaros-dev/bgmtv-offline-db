package run.ikaros.offlinedb.bgmtv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import run.ikaros.offlinedb.bgmtv.entity.FileEntity;
import run.ikaros.offlinedb.bgmtv.service.FileService;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileRestController {
    private final FileService fileService;

    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @PutMapping("/upload")
    public FileEntity update(@RequestParam("file") MultipartFile multipartFile)
            throws IOException {
        Assert.notNull(multipartFile, "'file' must not be null");
        Assert.notNull(multipartFile.getBytes(), "file bytes must not be null");
        Assert.isTrue(multipartFile.getBytes().length > 0, "file bytes must >0");
        return fileService.upload(Objects.requireNonNull(multipartFile.getOriginalFilename()), multipartFile.getBytes());
    }

}
