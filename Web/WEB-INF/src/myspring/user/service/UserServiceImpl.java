package myspring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myspring.user.dao.UserDao;
import myspring.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public void insertUser(UserVO user) {
		userdao.insert(user);
	}

	public List<UserVO> getUserList() {
		return userdao.readAll();
	}

	public void deleteUser(String id) {
		userdao.delete(id);
		
	}

	public UserVO getUser(String id) {
		return userdao.read(id);
	}

	public void updateUser(UserVO user) {
		userdao.update(user);
		
	}
}
