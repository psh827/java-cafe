package com.varxyz.javacafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin/add_category")
public class AddCategoryController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping
	public String addCategoryForm(Model model) {
		model.addAttribute("largeCategory", new LargeCategory());
		return "admin/add_category";
	}
	
	@PostMapping
	public String addCategory(@ModelAttribute("largeCategory") LargeCategory largeCategory, Model model) {
		
		
		adminService.addCategory(largeCategory);
		
		model.addAttribute("largeCategory", largeCategory);
		
		return "admin/add_category_success";
		
	}
	
}
