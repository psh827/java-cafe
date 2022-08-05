package com.varxyz.javacafe.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.javacafe.command.MenuItemCommand;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.provider.CategoryProvider;
import com.varxyz.javacafe.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin/add_menu_item")
public class AddMenuItemController {
	@Autowired
	AdminServiceImpl adminService;
	
	@GetMapping
	public String addMenuItemForm(@ModelAttribute MenuItemCommand menuItemCommand) {
		return "admin/add_menu_item";
	}
	
	@ModelAttribute("categoryProvider")
	public List<CategoryProvider> categoryPro(){
		List<CategoryProvider> list = adminService.getCategory();
		return list;
	}
	
	
	@PostMapping
	public String addMenuItem(MenuItemCommand menuItemCommand, @RequestParam("files") MultipartFile file, Model model) throws IOException {    //command객체가 아닌 request로 submit한 값 받아오기     //studentNumber - submissionForm의 속성 name 
		//커맨드로 만들기
		System.out.println(menuItemCommand.getCategoryId());
		MenuItem menuitem = new MenuItem();
		menuitem.setMenuItemName(menuItemCommand.getMenuItemName());
		menuitem.setMenuPrice(menuItemCommand.getMenuPrice());
		menuitem.setIhb(menuItemCommand.getIhb());
		menuitem.setLargeCategory(new LargeCategory(menuItemCommand.getCategoryId()));
		menuitem.setDescription(menuItemCommand.getDescription());
		
		System.out.println(menuItemCommand.getMenuItemName());
//		String filePath = "C:\\myworkspace\\java-cafe\\src\\main\\webapp\\resources\\menuImg\\";
		String filePath = "C:\\Park\\work\\java-cafe\\src\\main\\webapp\\resources\\menuImg\\";
        //파일명
        String originalFile = file.getOriginalFilename();
        System.out.println(originalFile);
        //파일명 중 확장자만 추출                                                //lastIndexOf(".") - 뒤에 있는 . 의 index번호
        String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
        //fileuploadtest.doc
        //lastIndexOf(".") = 14(index는 0번부터)
        //substring(14) = .doc
        
        //업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제 
        //파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
        //UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성                    "-"라면 생략으로 대체
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
        
        Image img = new Image();
        img.setImgName(storedFileName);
        img.setImgOriName(originalFile);
        img.setImgUrl(filePath);
        
        menuitem.setImage(img);
        
        adminService.addProduct(menuitem, img);
        
        //파일을 저장하기 위한 파일 객체 생성
        File files = new File(filePath + storedFileName);
        //파일 저장
        file.transferTo(files);
        
        System.out.println(menuitem + "가 업로드한 파일은");
        System.out.println(originalFile + "은 업로드한 파일이다.");
        System.out.println(storedFileName + "라는 이름으로 업로드 됐다.");
        System.out.println("파일사이즈는 " + file.getSize());
		
		return "admin/add_menu_item_success";
		
	}
	
}
