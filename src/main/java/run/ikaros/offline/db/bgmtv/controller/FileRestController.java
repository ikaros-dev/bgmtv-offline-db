package run.ikaros.offline.db.bgmtv.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import run.ikaros.offline.db.bgmtv.entity.FileEntity;
import run.ikaros.offline.db.bgmtv.service.FileService;

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
