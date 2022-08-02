package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;

/**
 * 관리자가 해야 하는 메소드.
 * 상품 등록(이미지, 상품이름, 가격, 종류, 재고).
 * 카테고리 등록(?).
 * 
 * @author Administrator
 *
 */
public interface AdminService {
	long addProduct(MenuItem menuItem, Image img);
	boolean addCategory(LargeCategory largeCategory);
	List<MenuItem> viewAllMenu();
	boolean changeDetail(int changePrice, char outOfStock);
}
