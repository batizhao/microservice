package me.batizhao.cloud.controller;

import me.batizhao.cloud.domain.User;
import me.batizhao.cloud.repository.UserRepository;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value="/start-process", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public void startHireProcess(@RequestBody Map<String, String> data) {

        User user = new User(data.get("name"), data.get("email"), data.get("phoneNumber"));
        userRepository.save(user);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("user", user);
        runtimeService.startProcessInstanceByKey("hireProcessWithJpa", variables);
    }
}
