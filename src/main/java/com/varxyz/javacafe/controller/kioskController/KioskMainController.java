package com.varxyz.javacafe.controller.kioskController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.command.MenuItemCommand;
import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.KioskServiceImpl;

@Controller
public class KioskMainController {
	
	@Autowired
	KioskServiceImpl kioskService;
	
	@Autowired
	CartServiceImpl cartService;
	
	@GetMapping("/kiosk/main")
	public String getMain(HttpServletRequest request) {
		List<LargeCategory> categoryList = kioskService.getCategoryToKiosk();
		request.setAttribute("categoryList", categoryList);
		
		List<MenuItem> menuList = kioskService.getAllMenuToKiosk(1001);
		request.setAttribute("menuList", menuList);
		
		List<Cart> cartList = cartService.getAllCart();
		if(cartList.size() >= 1) {
			request.setAttribute("cartList", cartList);
		}
		
		return "kiosk/main";
	}
	
	@RequestMapping(value = "/kiosk/requestObject", method = { RequestMethod.POST })
	@ResponseBody
	public List<MenuItem> getMenuItem(@RequestBody MenuItemCommand menuItemCommand,
			HttpServletRequest request) throws UnsupportedEncodingException{
		List<MenuItem> menuList = kioskService.getAllMenuToKiosk(menuItemCommand.getCategoryId());
		return menuList;
	}
	
	@RequestMapping(value = "/kiosk/requestForModal", method = { RequestMethod.POST })
	@ResponseBody
	public MenuItem getMenuItemForModal(@RequestBody MenuItemCommand menuItemCommand,
			HttpServletRequest request) throws UnsupportedEncodingException{
		MenuItem menuItem = kioskService.getMenuItemBymenuName(menuItemCommand.getImgName());
		return menuItem;
	}
	
	@PostMapping("/kiosk/main")
	public String inCart(Cart cart, HttpServletRequest request) {
		int result = cartService.addCart(cart);
		System.out.println(result);
		if(result == 1 || result == 4) {
			return "redirect:/kiosk/main";
		}else {
			request.setAttribute("msg", "오류!");
			request.setAttribute("url", "main");
			return "alert";	
		}		
		
	}
	
}
