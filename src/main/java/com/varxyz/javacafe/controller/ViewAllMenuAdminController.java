package com.varxyz.javacafe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin/view_menu")
public class ViewAllMenuAdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping
	public String viewMenu(HttpServletRequest request) {
		List<MenuItem> list = adminService.viewAllMenu();
		for(MenuItem m : list) {
			String path = m.getImage().getImgUrl() + m.getImage().getImgName();
			m.getImage().setImgUrl(path);
		}
		request.setAttribute("menuList", list);
		return "admin/view_menu";
	}
	
	
	
	@PostMapping("/admin/changeDetail")
	public String changeDetail(HttpServletRequest request) {
		int changePrice = Integer.parseInt(request.getParameter("menuPrice"));
		char outOfStock = request.getParameter("outOfStock").charAt(0);
		String passwd = request.getParameter("passwd");
		if(passwd != "qwer123") {
			return "admin/view_menu";
		}
		adminService.changeDetail(changePrice, outOfStock);
		
		return "admin/view_menu";
	}
	


}
