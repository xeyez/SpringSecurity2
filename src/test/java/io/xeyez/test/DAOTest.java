package io.xeyez.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.github.xeyez.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DAOTest {
	
	UserDAO dao;
	
	@Value("${mybatis.user.namespace}")
	String test1;
	
	@Value("${required}")
	String test2;
	
	private static final Logger logger = LoggerFactory.getLogger(DAOTest.class);

	public void create() throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		dao.createUser("admin", encoder.encode("admin123"), "admin", "ADMIN");
		dao.createUser("manager", encoder.encode("manager123"), "manager", "MANAGER");
	}
	
	public void select() throws Exception {
		logger.info(dao.getUser("admin").toString());
		logger.info(dao.getUser("manager").toString());
	}

	public void delete() throws Exception {
		dao.deleteUser("admin");
		dao.deleteUser("manager");
	}
	
	@Test
	public void test() {
		System.out.println(test1 + " / " + test2);
	}
}
