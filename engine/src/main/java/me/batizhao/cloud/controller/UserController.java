package me.batizhao.cloud.controller;

import me.batizhao.cloud.domain.User;
import me.batizhao.cloud.repository.UserRepository;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author batizhao
 * @since 2017/2/21
 */
@RestController
public class UserController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @PostMapping(value="/start-process", produces= MediaType.APPLICATION_JSON_VALUE)
    public User startHireProcess(@RequestBody User data) {

        User user = new User(data.getName(), data.getEmail(), data.getPhoneNumber());
        userRepository.save(user);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("user", user);
        runtimeService.startProcessInstanceByKey("hireProcessWithJpa", variables);

        return user;
    }

    /**
     * 本地服务实例的信息
     * @return
     */
//    @GetMapping("/instance-info")
//    public ServiceInstance showInfo() {
//        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
//        return localServiceInstance;
//    }
}
