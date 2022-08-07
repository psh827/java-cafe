package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Cart;

public interface CartService {
	int addCart(Cart cart);
	Cart checkCart(Cart cart);
	List<Cart> getAllCart();
	int updateCart(Cart cart);
	int deleteAll();
}
