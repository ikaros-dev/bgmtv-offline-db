package run.ikaros.offline.db.bgmtv.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HttpProxyResponse {
    @JsonProperty("enable_http_proxy")
    private String enableHttpProxy;
    @JsonProperty("http_proxy_host")
    private String httpProxyHost;
    @JsonProperty("http_proxy_port")
    private String httpProxyPort;
}
