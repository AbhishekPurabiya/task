package com.axis.fds.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.axis.fds.app.entity.Cart;
import com.axis.fds.app.entity.Food;
import com.axis.fds.app.service.ICartService;
import com.axis.fds.app.service.IFoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/food/user/cart")
public class CartController {

	@Autowired
	ICartService service;

	@Autowired
	IFoodService foodService;

	@RequestMapping(value = "/add")
	public ModelAndView addToCart(@RequestParam("foodid") int fid , HttpSession session,
			HttpServletRequest request) {
		String role = (String) session.getAttribute("role");

		if (role.equalsIgnoreCase("user")) {
			int uid = (int) session.getAttribute("userid");
//			double price = Double.parseDouble(request.getParameter("price"));
//			int quantity = Integer.parseInt(request.getParameter("quantity"));
			Food food = foodService.getFoodById(fid);
			Cart cart = new Cart();
			cart.setUserid(uid);
			cart.setFoodid(fid);
			cart.setFname(food.getFname());
			cart.setFimage(food.getFimage());
			cart.setCategory(food.getCategory());
			cart.setStatus(food.getStatus());
			cart.setPrice(food.getPrice());
			cart.setQuantity(food.getQuantity());

			service.addToCart(cart);
			return new ModelAndView("redirect:/food/user/get");
		}
		return new ModelAndView("redirect:/food/user/unauthentication");
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getAllCart(HttpSession session) {

		String role = (String) session.getAttribute("role");

		if (role.equalsIgnoreCase("user")) {
			int userid = (int) session.getAttribute("userid");
			List<Cart> cartList = service.getByUserId(userid);
			ModelAndView mv = new ModelAndView();
			mv.addObject("CartList", cartList);
			mv.setViewName("UserCartList");
			return mv;
		}
		return new ModelAndView("redirect:/food/user/unauthentication");
	}

	@RequestMapping(value = "/delete")
	public ModelAndView removeFromCart(@RequestParam("cid") int cid , HttpSession session) {
		String role = (String) session.getAttribute("role");

		if (role.equalsIgnoreCase("user")) {

			service.removeFromCart(cid);
			return new ModelAndView("redirect:/food/user/cart/get");
		}
		return new ModelAndView("redirect:/food/user/unauthentication");
	}
	
	@RequestMapping(value = "/order")
	public ModelAndView placeOrder(@RequestParam("cid") int cid  , HttpSession session) {
		String role = (String) session.getAttribute("role");

		if (role.equalsIgnoreCase("user")) {
			ModelAndView mv = new ModelAndView();
			Cart cart = service.GetByCartId(cid);
			mv.addObject("cart", cart);
			mv.setViewName("UserOrder");
			return mv;
		}
		return new ModelAndView("redirect:/food/user/unauthentication");
	}

	@RequestMapping("/order/payment")
	public ModelAndView payment(HttpServletRequest request , HttpSession session) {
		String role = (String) session.getAttribute("role");

		if (role.equalsIgnoreCase("user")) {
			ModelAndView mv = new ModelAndView();
			double total = Double.parseDouble( request.getParameter("totalprice"));
			mv.addObject("total", total);
			mv.setViewName("UserPayment");
			return mv;
		}
		return new ModelAndView("redirect:/food/user/unauthentication");
	}
	
	@RequestMapping("/order/success")
	public ModelAndView success() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("UserOrderSuccess");
		return mv;
	}
}
