package me.batizhao.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.batizhao.cloud.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author batizhao
 * @since 2017/2/24
 */
@Service
public class OaClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OaClientService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public User startProcess(String name, String email, String phoneNumber) {
        User user = new User(name, email, phoneNumber);
        return this.restTemplate.postForObject("http://flow-engine-server/start-process", user, User.class);
    }

    /**
     * hystrix fallback方法
     * @return 默认的用户
     */
    public User fallback(String name, String email, String phoneNumber) {
        OaClientService.LOGGER.info("异常发生，进入fallback方法，接收的参数：name = {}", name);
        User user = new User();
        user.setId(-1L);
        user.setName("john");
        user.setEmail("john@qq.com");
        user.setPhoneNumber("13917891868");
        return user;
    }
}
