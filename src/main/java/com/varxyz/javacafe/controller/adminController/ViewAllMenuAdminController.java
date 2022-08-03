package com.varxyz.javacafe.controller.adminController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.service.AdminServiceImpl;

@Controller
public class ViewAllMenuAdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping("/admin/admin_main")
	public String goMain() {
		return "admin/admin_main";
	}
	
	@GetMapping("/admin/view_menu")
	public String viewMenu(HttpServletRequest request) {
		List<MenuItem> list = adminService.viewAllMenu();
		for(MenuItem m : list) {
			String path = m.getImage().getImgUrl() + m.getImage().getImgName();
			m.getImage().setImgUrl(path);
		}
		request.setAttribute("menuList", list);
		return "admin/view_menu";
	}
	
	
	
}
