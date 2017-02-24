package me.batizhao.cloud.service;

import me.batizhao.cloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author batizhao
 * @since 2017/2/24
 */
@Service
public class OaClientService {

    @Autowired
    private RestTemplate restTemplate;

    public User startProcess(String name, String email, String phoneNumber) {
        User user = new User(name, email, phoneNumber);
        return this.restTemplate.postForObject("http://flow-engine-server/start-process", user, User.class);
    }
}
