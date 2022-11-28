package run.ikaros.offlinedb.bgmtv.controller;

import org.springframework.web.bind.annotation.*;
import run.ikaros.offlinedb.bgmtv.request.EnableHttpProxyRequest;
import run.ikaros.offlinedb.bgmtv.response.HttpProxyResponse;
import run.ikaros.offlinedb.bgmtv.service.OptionService;

@RestController
@RequestMapping("/option")
public class OptionRestController {
    private final OptionService optionService;

    public OptionRestController(OptionService optionService) {
        this.optionService = optionService;
    }

    @PostMapping("/proxy/enable")
    public void enableHttpProxy(@RequestBody EnableHttpProxyRequest enableHttpProxyRequest) {
        optionService.enableHttpProxy(enableHttpProxyRequest);
    }

    @GetMapping("/proxy/info")
    public HttpProxyResponse getProxyInfo() {
        return optionService.getHttpProxyInfo();
    }
}
