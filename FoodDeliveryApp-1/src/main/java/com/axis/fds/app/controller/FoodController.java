package com.axis.fds.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.axis.fds.app.entity.Food;
import com.axis.fds.app.service.IFoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	IFoodService service ;
	
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/food/get");
	}
	
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ModelAndView addFood( Food food) {
		 service.addFood(food);
		 return new ModelAndView("redirect:/food/get");
	}
	
	//for getting the update details
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request) {
		int fid = Integer.parseInt(request.getParameter("foodid"));
		Food oldData = service.getFoodById(fid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("food", oldData);
		mv.setViewName("UpdateFood");
		return mv ;
	}
	
	@RequestMapping(value = "/updateDetails" , method = RequestMethod.POST)
	public ModelAndView saveUpdate( Food food) {
		int fid = food.getFoodid();
		service.deleteFoodById(fid);
		service.addFood(food);
		return new ModelAndView("redirect:/food/get");
	}
	
	
	@RequestMapping(value = "/get" , method = RequestMethod.GET)
	public ModelAndView getAll(){
		List<Food> list =  service.getAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("foodList", list);
		mv.setViewName("AdminFoodList");
		return mv;
	}
	
	@RequestMapping(value ="/delete")
	public ModelAndView deleteById(HttpServletRequest request) {
		int fid = Integer.parseInt(request.getParameter("foodid"));
		service.deleteFoodById(fid);
		return new ModelAndView("redirect:/food/get");
	}
	
}
