package com.varxyz.javacafe.controller.kioskController;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.command.MenuItemCommand;
import com.varxyz.javacafe.domain.Cart;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.CartServiceImpl;
import com.varxyz.javacafe.service.KioskServiceImpl;

@Controller
public class AddCartController {

	@Autowired
	KioskServiceImpl kioskService;
	
	@Autowired
	CartServiceImpl cartService;
	
	@GetMapping("/kiosk/add_cart")
	public String add_cart(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

		String imgName = request.getParameter("imgName");
		MenuItem menuItem = kioskService.getMenuItemByImgName(imgName);
		
		model.addAttribute("menuItem", menuItem);
		

		return "kiosk/add_cart";
	}
	
	
}
