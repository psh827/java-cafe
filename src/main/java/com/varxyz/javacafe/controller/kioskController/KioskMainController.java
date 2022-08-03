package com.varxyz.javacafe.controller.kioskController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		List<MenuItem> menuList = kioskService.getAllMenuToKiosk();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("menuList", menuList);
		
		return "kiosk/main";
	}
	
}
