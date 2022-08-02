package com.varxyz.javacafe.domain;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 메뉴아이템은 소분류카테고리 밑에 있으면서
 * 대분류카테고리로도 검색할 수 있어야된다고 생각한다.
 * 메뉴아이템은 하나의 소분류카테고리를 가지고있고.
 * 메뉴아이템 ->1 소분류아이템 ->1 대분류아이템 이런 구조를 가지고 있어야된다고 생각한다.
 * 
 * @author Administrator
 *
 */
@Getter
@Setter
public class MenuItem {
	private long mId;
	private long scFk;
	private LargeCategory largeCategory;
	private String menuItemName;
	private int menuPrice;
	private Image image;
	//ice or hot or bakery 
	private char ihb;
	private char outOfStock;
	private Date regDate;
	
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}

	public MenuItem(String menuItemName, int menuPrice, char ihb, char outOfStock,
			LargeCategory largeCategory, Image image, Date regDate) {
		this.largeCategory = largeCategory;
		this.menuItemName = menuItemName;
		this.menuPrice = menuPrice;
		this.image = image;
		this.outOfStock = outOfStock;
		this.ihb = ihb;
		this.regDate = regDate;
	}
	
	
	
}
