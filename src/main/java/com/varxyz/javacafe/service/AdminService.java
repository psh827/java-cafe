package com.varxyz.javacafe.service;

/**
 * 관리자가 해야 하는 메소드.
 * 상품 등록(이미지, 상품이름, 가격, 종류, 재고).
 * 카테고리 등록(?).
 * 
 * @author Administrator
 *
 */
public interface AdminService {
	boolean addProduct(String menuName, int price, char ihb, int stock);
}
