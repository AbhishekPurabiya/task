package com.axis.medicare.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.axis.medicare.entity.Medicine;
import com.axis.medicare.entity.User;
import com.axis.medicare.service.IUserService;
import com.axis.medicare.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicare/v1/user")
public class UserController {

	@Autowired
	IUserService service ;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user , HttpServletRequest request) {
		String username = user.getUsername();
		String password = user.getPassword();
		HttpSession session = request.getSession();
		if(username.isBlank()==false && password.isBlank()== false ) {
			boolean isValid = service.isValid(username, password);
			if(isValid == true) {
				User user1 = service.findUser(username, password);
				String role = user1.getRole();
				System.out.println(role);
				String name = user1.getUsername();
				int id = user1.getCid();
				session.setAttribute("role", role);
				session.setAttribute("username", name );
				session.setAttribute("cid", id);
				return  new ResponseEntity<User>(user1 , HttpStatus.OK) ;
				//return new ResponseEntity<String>("Login Successfull "+ role , HttpStatus.OK) ;
			}
		}
		return new ResponseEntity<User>( HttpStatus.OK) ;
		//return new ResponseEntity<String>("Invalid Login...", HttpStatus.BAD_REQUEST) ;
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>("Logout Successfull ", HttpStatus.OK) ;
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/get")
	public List<Medicine> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/get/name/{name}")
	public List<Medicine> getByName(@PathVariable("name") String name){
		return service.getByName(name);
	}
	
	@GetMapping("/get/brand/{brand}")
	public List<Medicine> getByBrand(@PathVariable("") String brand){
		return service.getByBrand(brand);
	}
}
