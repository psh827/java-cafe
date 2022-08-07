package com.varxyz.javacafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.provider.CategoryProvider;
import com.varxyz.javacafe.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin/add_category")
public class AddCategoryController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping
	public String addCategoryForm(Model model) {
		model.addAttribute("largeCategory", new LargeCategory());
		List<CategoryProvider> categoryList = adminService.getCategory();
		model.addAttribute("largeCategoryList", categoryList);
		return "admin/add_category";
	}
	
	@PostMapping
	public String addCategory(@ModelAttribute("largeCategory") LargeCategory largeCategory, Model model) {
		if(adminService.isCate(largeCategory) != null) {
			model.addAttribute("msg", "이미 존재하는 카테고리입니다.");
			model.addAttribute("url", "add_category");
			return "alert";
		}
		
		adminService.addCategory(largeCategory);
		
		model.addAttribute("largeCategory", largeCategory);
		model.addAttribute("msg", "등록성공!");
		model.addAttribute("url", "add_category");
		return "alert";
		
	}
	
}
