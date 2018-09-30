package myspring.user.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class UserClient {
	@Autowired
	ApplicationContext context;
	@Autowired
	UserService service;

	@Test
	public void updateUserTest() {
		service.updateUser(new UserVO("dooly4", "둘리6", "남6", "서울6"));

		UserVO user = service.getUser("dooly4");
		System.out.println(user);
	}

	@Test
	public void insertUserTest() {
		service.insertUser(new UserVO("dooly6", "둘리", "남", "경기"));

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}
	
	@Test
	public void configTest(){
		SqlSession sqlSession = context.getBean("sqlSession", SqlSession.class);
		System.out.println("sqlSession:"+sqlSession.getClass().getName());
		
		UserVO vo = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(vo);
	}

	@Test
	public void getUserTest() {
		UserVO user = service.getUser("dooly");
		System.out.println(user);
		assertEquals("김둘리", user.getName());
	}

	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteUserTest() {
		service.deleteUser("dooly6");

		for (UserVO user : service.getUserList()) {
			System.out.println(user);
		}
	}

}
