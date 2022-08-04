package com.varxyz.javacafe.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.CartDao;
import com.varxyz.javacafe.domain.Cart;

public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;
	
	@Override
	public int addCart(Cart cart) {
		
		if(checkCart(cart) != null) {
			return 2;
		}
		
		return cartDao.addCart(cart);
	}

	@Override
	public Cart checkCart(Cart cart) {
		return cartDao.checkCart(cart);
	}

}
