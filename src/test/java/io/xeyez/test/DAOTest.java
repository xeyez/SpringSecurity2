package io.xeyez.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.github.xeyez.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DAOTest {
	
	@Inject
	UserDAO dao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(DAOTest.class);
	
	public void test1() throws Exception {
		logger.info("삽입합니다!");
		
		dao.createUser("user00", "123", "user00", "USER");
	}

	@Test
	public void test2() throws Exception {
		boolean b = dao.userExists("user00");
		
		logger.info("존재하냐? " + b);
	}
}
