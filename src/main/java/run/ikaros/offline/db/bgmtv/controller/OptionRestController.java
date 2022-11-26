package run.ikaros.offline.db.bgmtv.controller;

import org.springframework.web.bind.annotation.*;
import run.ikaros.offline.db.bgmtv.request.EnableHttpProxyRequest;
import run.ikaros.offline.db.bgmtv.response.HttpProxyResponse;
import run.ikaros.offline.db.bgmtv.service.OptionService;

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
