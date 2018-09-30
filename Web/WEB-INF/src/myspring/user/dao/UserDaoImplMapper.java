package myspring.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao {
	@Autowired
	private UserMapper userMapper;	
	
	public UserVO read(String id) {
		UserVO user  = userMapper.selectUserById(id);
		return user;
	}
	
	public List<UserVO> readAll() {
		List<UserVO> userList = userMapper.selectUserList();
		return userList;
	}

	public void insert(UserVO user) {
		userMapper.insertUser(user);
		System.out.println("��ϵ� Record UserId=" + user.getUserId() + 
				" Name=" + user.getName());
	}

	public void update(UserVO user) {
		userMapper.updateUser(user);
	}
	
	public void delete(String id) {
		userMapper.deleteUser(id);
		System.out.println("������ Record with ID = " + id ); 
	}
}










