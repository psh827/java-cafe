package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.MenuItem;

/**
 * 카페에서 있어야 할 메소드.
 * 상품조회
 * 상품담기(상품의 종류, ice or hot, 수량)
 * 상품구입(금액) 
 * @author Administrator
 *
 */
public interface JavaCafeService {
	List<MenuItem> getAllMenuInCategory();
	boolean addToCart(String menuName, char ihb, int volume);
	boolean buyMenu(int money);
}
