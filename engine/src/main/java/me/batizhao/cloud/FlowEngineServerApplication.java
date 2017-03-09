package me.batizhao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlowEngineServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowEngineServerApplication.class, args);
	}

//	@Bean
//	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
//
//		return new InitializingBean() {
//			public void afterPropertiesSet() throws Exception {
//
//				Group group = identityService.newGroup("user");
//				group.setName("users");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//
//				User admin = identityService.newUser("admin");
//				admin.setPassword("admin");
//				identityService.saveUser(admin);
//
//			}
//		};
//	}
}
