package com.varxyz.javacafe.command;


import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemCommand {
	private long mId;
	private long categoryId;
	private String menuItemName;
	private String description;
	private int menuPrice;
	private MultipartFile files; 
	//ice or hot or bakery 
	private String ihb;
}
