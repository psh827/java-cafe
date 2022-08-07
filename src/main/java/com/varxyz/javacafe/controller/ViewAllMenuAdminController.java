package com.varxyz.javacafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/admin/login")
	public String adminLoginForm() {
		return "admin/login";
	}
	
	@PostMapping("/admin/login")
	public String adminLogin(HttpServletRequest request, HttpSession session) {
		String adminId = request.getParameter("adminId");
		String adminPasswd = request.getParameter("adminPasswd");
		if(adminId.equals("admin") && adminPasswd.equals("qwer123!")) {
			session.setAttribute("admin", "관리자");
			return "admin/admin_main";
		}		
		request.setAttribute("msg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
		request.setAttribute("url", "login");
		return "alert";
	}
	
	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "admin/login";
	}
	
	
	@GetMapping("/admin/admin_main")
	public String goMain(HttpSession session, HttpServletRequest request) {
		String who = (String)session.getAttribute("admin");
		if(who == null) {
			request.setAttribute("msg", "로드인이 필요합니다.");
			request.setAttribute("url", "login");
			return "alert";
		}
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
	
	@PostMapping("/admin/delete_menu")
	public String deleteMenu(HttpServletRequest request) {
		long menuid = Long.parseLong(request.getParameter("menuid"));
		System.out.println(menuid);
		int result = adminService.deleteMenuByMenuItemName(menuid);
		if(result == 0) {
			request.setAttribute("msg", "삭제 오류");
			request.setAttribute("url", "view_menu");
			return "alert";
		}
		
		return "redirect:/admin/view_menu";
	}
	
	
	
}
