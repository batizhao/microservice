package me.batizhao.cloud.controller;

import me.batizhao.cloud.domain.User;
import me.batizhao.cloud.service.OaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author batizhao
 * @since 2017/2/24
 */
@RestController
@RefreshScope
public class OaClientController {

    @Value("${profile}")
    private String profile;

    @Autowired
    private OaClientService oaClientService;

    @GetMapping("/start")
    public User start() {
        return oaClientService.startProcess("batizhao", "zhaobati@gmail.com", "18917778888");
    }

    @GetMapping("/hello")
    public String hello() {
        return this.profile;
    }

}
