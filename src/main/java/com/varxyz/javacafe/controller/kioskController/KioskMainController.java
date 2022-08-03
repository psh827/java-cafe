package com.varxyz.javacafe.controller.kioskController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.varxyz.javacafe.command.MenuItemCommand;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.KioskServiceImpl;

@Controller
public class KioskMainController {
	
	@Autowired
	KioskServiceImpl kioskService;
	
	@GetMapping("/kiosk/main")
	public String getMain(HttpServletRequest request) {
		List<LargeCategory> categoryList = kioskService.getCategoryToKiosk();
		
		request.setAttribute("categoryList", categoryList);
//		request.setAttribute("menuList", menuList);
		
		return "kiosk/main";
	}
	
	@RequestMapping(value = "/kiosk/requestObject", method = { RequestMethod.POST })
	@ResponseBody
	public List<MenuItem> getMenuItem(@RequestBody MenuItemCommand menuItemCommand){
		System.out.println(menuItemCommand.getCategoryId());
		List<MenuItem> menuList = kioskService.getAllMenuToKiosk(menuItemCommand.getCategoryId());
		return menuList;
	}
	
}
