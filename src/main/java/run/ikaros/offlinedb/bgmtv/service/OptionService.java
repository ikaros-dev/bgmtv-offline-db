package run.ikaros.offlinedb.bgmtv.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import run.ikaros.offlinedb.bgmtv.response.HttpProxyResponse;
import run.ikaros.offlinedb.bgmtv.entity.OptionEntity;
import run.ikaros.offlinedb.bgmtv.enums.OptionKey;
import run.ikaros.offlinedb.bgmtv.repository.OptionRepository;
import run.ikaros.offlinedb.bgmtv.request.EnableHttpProxyRequest;

import java.util.Optional;

@Service
public class OptionService {
    private final OptionRepository optionRepository;

    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void enableHttpProxy(@NonNull EnableHttpProxyRequest request) {
        Assert.notNull(request, "request");
        String httpProxyHost = request.getHttpProxyHost();
        String httpProxyPort = request.getHttpProxyPort();

        OptionEntity enableHttpProxyOption = new OptionEntity();
        enableHttpProxyOption.setKey(OptionKey.ENABLE_HTTP_PROXY);
        enableHttpProxyOption.setValue(Boolean.TRUE.toString());
        optionRepository.save(enableHttpProxyOption);

        OptionEntity httpProxyHostOption = new OptionEntity();
        httpProxyHostOption.setKey(OptionKey.HTTP_PROXY_HOST);
        httpProxyHostOption.setValue(httpProxyHost);
        optionRepository.save(httpProxyHostOption);

        OptionEntity httpProxyPortOption = new OptionEntity();
        httpProxyPortOption.setKey(OptionKey.HTTP_PROXY_PORT);
        httpProxyPortOption.setValue(httpProxyPort);
        optionRepository.save(httpProxyPortOption);

    }

    public HttpProxyResponse getHttpProxyInfo() {
        HttpProxyResponse httpProxyResponse = new HttpProxyResponse();

        Optional<OptionEntity> enableHttpProxyOptionEntityOptional
                = optionRepository.findByKey(OptionKey.ENABLE_HTTP_PROXY);
        enableHttpProxyOptionEntityOptional
                .ifPresent(optionEntity -> httpProxyResponse.setEnableHttpProxy(optionEntity.getValue()));

        Optional<OptionEntity> httpProxyHostOptionEntityOptional
                = optionRepository.findByKey(OptionKey.HTTP_PROXY_HOST);
        httpProxyHostOptionEntityOptional
                .ifPresent(optionEntity -> httpProxyResponse.setHttpProxyHost(optionEntity.getValue()));

        Optional<OptionEntity> httpProxyPortOptionEntityOptional
                = optionRepository.findByKey(OptionKey.HTTP_PROXY_PORT);
        httpProxyPortOptionEntityOptional
                .ifPresent(optionEntity -> httpProxyResponse.setHttpProxyPort(optionEntity.getValue()));

        return httpProxyResponse;
    }
}
