package run.ikaros.offlinedb.bgmtv.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RestTemplateUtils {

    private static Map<String, RestTemplate> restTemplateProxyMap = new HashMap<>();
    private static RestTemplate restTemplate;
    public static final Integer READ_TIMEOUT = 5000;
    public static final Integer CONNECT_TIMEOUT = 2000;


    public static synchronized RestTemplate buildRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setReadTimeout(READ_TIMEOUT);
            requestFactory.setConnectTimeout(CONNECT_TIMEOUT);
            restTemplate.setRequestFactory(requestFactory);
        }
        return restTemplate;
    }

    public static synchronized RestTemplate buildHttpProxyRestTemplate(
        @NonNull String httpProxyHost,
        @NonNull String httpProxyPort) {
        Assert.hasText(httpProxyHost, "httpProxyHost");
        Assert.hasText(httpProxyPort, "httpProxyPort");

        String key = httpProxyHost + ":" + httpProxyPort;
        if (restTemplateProxyMap.containsKey(key)) {
            return restTemplateProxyMap.get(key);
        }

        InetSocketAddress inetSocketAddress =
            new InetSocketAddress(httpProxyHost, Integer.parseInt(httpProxyPort));
        Proxy proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(READ_TIMEOUT);
        requestFactory.setConnectTimeout(CONNECT_TIMEOUT);
        requestFactory.setProxy(proxy);
        RestTemplate rt = new RestTemplate(requestFactory);

        restTemplateProxyMap.put(key, rt);
        return rt;
    }

    public static boolean testProxyConnect(@NonNull String httpProxyHost,
                                           @NonNull String httpProxyPort) {
        Assert.hasText(httpProxyHost, "httpProxyHost");
        Assert.hasText(httpProxyPort, "httpProxyPort");

        RestTemplate restTemplate = buildHttpProxyRestTemplate(httpProxyHost, httpProxyPort);

        try {
            ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("https://www.youtube.com/", String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return true;
            }
        } catch (NestedRuntimeException exception) {
            log.warn("http proxy verify fail", exception);
        }

        return false;
    }
}
