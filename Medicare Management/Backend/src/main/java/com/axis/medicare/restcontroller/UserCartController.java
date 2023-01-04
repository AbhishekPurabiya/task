package com.axis.medicare.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.axis.medicare.entity.Medicine;
import com.axis.medicare.entity.User;
import com.axis.medicare.entity.UserCart;
import com.axis.medicare.service.ICartService;
import com.axis.medicare.service.IMedicineService;
import com.axis.medicare.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicare/v1/user/cart")
public class UserCartController {

	@Autowired
	ICartService service;

	@Autowired
	IMedicineService medicineService;
	
	@Autowired
	IUserService userService;

	@PostMapping("/add/{mid}/{cid}")
	public ResponseEntity<String> addCart(@PathVariable("mid") int mid,@PathVariable("cid") int cid,  HttpSession session) {
		//String role = (String) session.getAttribute("role");

		User user = userService.getById(cid);
		String role = user.getRole();
		if (role.equals("user")) {
			UserCart cart = new UserCart();
			//int cid = (int) session.getAttribute("cid");
			Medicine medicine = medicineService.getById(mid);
			cart.setMid(medicine.getId());
			cart.setCid(cid);
			cart.setName(medicine.getName());
			cart.setBrand(medicine.getBrand());
			cart.setPrice(medicine.getPrice());
			cart.setDescription(medicine.getDescription());
			cart.setMfgDate(medicine.getMfgDate());
			cart.setExpDate(medicine.getExpDate());

			service.addCart(cart);

			return new ResponseEntity<String>("Medicine Added into Cart Sucessfully....", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("You can not add into cart.....Un-Authorised user",
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteCart(@PathVariable("id") int id, HttpSession session) {
		//String role = (String) session.getAttribute("role");
		UserCart cart = service.findById(id);
		int cid = cart.getCid();
		User user = userService.getById(cid);
		String role = user.getRole();
		if (role.equals("user")) {

			service.removeCart(id);
			return new ResponseEntity<String>("Record Deleted Successfully from Cart...", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Un-Authorised user", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<List<UserCart>> getByCid( HttpSession session , @PathVariable("id") int id) {
		//String role = (String) session.getAttribute("role");
		
		User user = userService.getById(id);
		String role = user.getRole();
		if (role.equals("user")) {
		//	int cid = (int) session.getAttribute("cid");
			List<UserCart> cartList = service.findByCid(id);
			return new ResponseEntity<List<UserCart>>(cartList , HttpStatus.OK);
		} else {
			return new ResponseEntity<List<UserCart>>( HttpStatus.BAD_REQUEST);
		}
	}
}
