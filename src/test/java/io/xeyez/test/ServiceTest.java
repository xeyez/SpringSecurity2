package io.xeyez.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.github.xeyez.domain.UserVO;
import io.github.xeyez.service.security.CustomUserDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	
	@Inject
	CustomUserDetailsService service;
	
	@Test
	public void test() throws Exception {
		
		UserVO vo = new UserVO("test", "123", "test");
		service.signUp(vo);
	}
}