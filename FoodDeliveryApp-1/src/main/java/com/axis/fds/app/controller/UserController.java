package com.axis.fds.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axis.fds.app.entity.Food;
import com.axis.fds.app.entity.User;
import com.axis.fds.app.service.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/food/user")
public class UserController {

	@Autowired
	UserServiceImp service;
	
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv ;
	}
	

	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, HttpServletResponse response) {
		if (username.isBlank() == false && password.isBlank() == false) {
			boolean isValid = service.isValid(username, password);
			if (isValid == true) {
				User user1 = service.findUser(username, password);
				String role = user1.getRole();
				
				String name = user1.getUsername();
				int id = user1.getUserid();
				ModelAndView mv = new ModelAndView();
				session.setAttribute("role", role);
				session.setAttribute("username", name);
				session.setAttribute("userid", id);
				
				if (role.equalsIgnoreCase("user")) {
					return new ModelAndView("redirect:/food/user/user-auth");
				} else if (role.equalsIgnoreCase("admin")) {
					return new ModelAndView("redirect:/food/user/admin-auth");
				}
			}
		}
		return new ModelAndView("redirect:/food/user/error");

	}

	@RequestMapping("/user-auth")
	public ModelAndView hrLogin() {
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/food/user/get");
	}

	@RequestMapping("/admin-auth")
	public ModelAndView empLogin() {
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/food/get");
	}

	@RequestMapping("/error")
	public ModelAndView mnLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}

	@RequestMapping(value = "/signup" , method = RequestMethod.POST)
	public ModelAndView addUser( User user) {
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		service.addUser(user);
		return new ModelAndView("redirect:/food/user/");
	}
	
	@RequestMapping(value = "/dashboard" , method = RequestMethod.GET)
	public ModelAndView getDashboard() {
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/food/user/get");
	}
	
	
	@RequestMapping(value = "/get" , method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<Food> foodList = service.getAllFood();
		ModelAndView mv = new ModelAndView();
		mv.addObject("foodlist", foodList);
		mv.setViewName("UserFoodList");
		return mv ;
	}
	
	@RequestMapping(value = "/get/name" , method = RequestMethod.GET)
	public ModelAndView getByFName(@RequestParam("fname") String fname) {
		List<Food> list = service.getByFname(fname);
		ModelAndView mv = new ModelAndView();
		mv.addObject("foodlist", list);
		mv.setViewName("UserFoodList");
		return mv ;
	}
	
	@RequestMapping(value = "/get/category" , method = RequestMethod.GET)
	public ModelAndView getByCategory(@RequestParam("category") String category) {
		List<Food> list = service.getByCategory(category);
		ModelAndView mv = new ModelAndView();
		mv.addObject("foodlist", list);
		mv.setViewName("UserFoodList");
		return mv ;
	}
	
	@RequestMapping(value = "/get/price" , method = RequestMethod.GET)
	public ModelAndView getByPrice(@RequestParam("price") double price) {
		List<Food> list = service.getByPrice(price);
		ModelAndView mv = new ModelAndView();
		mv.addObject("foodlist", list);
		mv.setViewName("UserFoodList");
		return mv ;
	}
	
	@RequestMapping(value = "/unauthentication" , method = RequestMethod.GET)
	public ModelAndView unauth() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UnAuthentication");
		return mv;
	}
	
	@RequestMapping(value = "/filter" , method = RequestMethod.POST)
	public ModelAndView filter(HttpServletRequest request) {
		String filter = (String) request.getParameter("filter");
		String search = (String) request.getParameter("search");
		
		if(filter.isBlank()==false && search.isBlank()==false) {
			if(filter.equalsIgnoreCase("foodName")) {
				return new ModelAndView("redirect:/food/user/get/name?fname="+search);
			}else if(filter.equalsIgnoreCase("foodCategory")) {
				return new ModelAndView("redirect:/food/user/get/category?category="+search);
			}else if(filter.equalsIgnoreCase("foodPrice")) {
				double price = Double.parseDouble(search);
				return new ModelAndView("redirect:/food/user/get/price?price="+price);
			}
			return new ModelAndView("redirect:/food/user/get/Null");
		}
		return new ModelAndView("redirect:/food/user/get/Null");
	}
	
	@RequestMapping(value = "/get/Null")
	public ModelAndView wrongSearch() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WrongSearch");
		return mv;
	}
	
	@RequestMapping("/logout")
	public void logout(HttpSession session , HttpServletResponse response) throws IOException {
		session.invalidate();
		response.sendRedirect("/food/user/");
	}
}
