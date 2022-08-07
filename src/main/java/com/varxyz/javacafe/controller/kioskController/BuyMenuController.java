package com.varxyz.javacafe.controller.kioskController;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.KioskServiceImpl;

@Controller
public class BuyMenuController {
	
	@Autowired
	KioskServiceImpl kioskService;
	
	@Autowired
	CartServiceImpl cartService;
	
	@GetMapping("/kiosk/buyPage")
	public String buyPageForm(Model model) {
		
		List<Cart> cartList = cartService.getAllCart();
		if(cartList.size() == 0) {
			model.addAttribute("msg", "제품을 선택해주세요.");
			model.addAttribute("url", "main");
			return "alert";
		}
		model.addAttribute("cartList", cartList);
		
		
		return "kiosk/buyPage";
	}
	
	@PostMapping("/kiosk/buyPage")
	public String buyPage(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		cartService.deleteAll();
		return "kiosk/buy_success";
	}
	
	@RequestMapping(value = "/kiosk/requestDelete", method = { RequestMethod.POST })
	@ResponseBody
	public boolean getMenuItemForModal(@RequestBody Cart cart,
			HttpServletRequest request) throws UnsupportedEncodingException{
		boolean result = cartService.deleteThis(cart.getImgName()); 
		return result;
	}
	
}
