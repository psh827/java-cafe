package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.CartDao;
import com.varxyz.javacafe.domain.Cart;

public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;
	/**
	 * 1 : 성공 (새로운 아이템)
	 * 2 : 실패 (새로운 아이템 실패)
	 * 3 : 실패 (기존아이템 실패)
	 * 4 : 성공 (기존아이템에 수량 증가)
	 */
	@Override
	public int addCart(Cart cart) {
		
		if(checkCart(cart) != null) {
			return updateCart(cart);
		}
		
		return cartDao.addCart(cart);
	}

	@Override
	public Cart checkCart(Cart cart) {
		return cartDao.checkCart(cart);
	}

	@Override
	public List<Cart> getAllCart() {
		return cartDao.getAllCart();
	}

	@Override
	public int updateCart(Cart cart) {
		return cartDao.updateCart(cart);
	}

	public boolean deleteThis(String imgName) {
		return cartDao.deleteThis(imgName);
	}

}
