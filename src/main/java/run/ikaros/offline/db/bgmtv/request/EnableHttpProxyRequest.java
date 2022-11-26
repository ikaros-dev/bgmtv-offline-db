package run.ikaros.offline.db.bgmtv.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnableHttpProxyRequest {
    @JsonProperty("http_proxy_host")
    private String httpProxyHost;
    @JsonProperty("http_proxy_port")
    private String httpProxyPort;
}
