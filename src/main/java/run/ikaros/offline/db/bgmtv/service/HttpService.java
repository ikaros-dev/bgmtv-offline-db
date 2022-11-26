package run.ikaros.offline.db.bgmtv.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import run.ikaros.offline.db.bgmtv.entity.FileEntity;
import run.ikaros.offline.db.bgmtv.utils.FileUtils;

@Service
public class HttpService {

    private RestTemplate restTemplate = new RestTemplate();
    private final FileService fileService;

    public HttpService(FileService fileService) {
        this.fileService = fileService;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        Assert.notNull(restTemplate, "'restTemplate' must not be null");
        this.restTemplate = restTemplate;
    }

    @Retryable
    public FileEntity pull(@NonNull String url) {
        Assert.hasText(url, "url");
        ResponseEntity<byte[]> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);
        byte[] bytes = responseEntity.getBody();
        if(bytes == null) {
            return null;
        }
        String fileName = FileUtils.parseFileName(url);
        return fileService.upload(fileName, bytes);
    }




}
