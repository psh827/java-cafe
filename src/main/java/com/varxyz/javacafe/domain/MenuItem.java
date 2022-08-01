package com.varxyz.javacafe.domain;

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
	private SmallCategory smallCategory;
	private String menuItemName;
	private int menuPrice;
	//ice or hot or bakery 
	private char ihb;
	private int stock;
	
}
