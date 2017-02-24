package me.batizhao.cloud.controller;

import me.batizhao.cloud.service.OaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author batizhao
 * @since 2017/2/24
 */
@RestController
public class OaClientController {

    @Autowired
    private OaClientService oaClientService;

    @GetMapping("/start")
    public void findById() {
        oaClientService.startProcess("batizhao", "zhaobati@gmail.com", "18917778888");
    }

}
