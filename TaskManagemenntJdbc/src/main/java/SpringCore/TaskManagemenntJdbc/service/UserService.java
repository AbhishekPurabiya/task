package SpringCore.TaskManagemenntJdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringCore.TaskManagemenntJdbc.Repository.UserDao;
import SpringCore.TaskManagemenntJdbc.bean.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao ;
	
	public int saveUser(User user) {
		int count = userDao.saveUser(user);
		return count ;
	}
	
	public boolean checkUser(String username, String password) {
		boolean isValid  = userDao.checkUser(username, password);
		return isValid ;
	}
}
