package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.CartDao;
import com.varxyz.javacafe.domain.Cart;

public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;
	
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

}
