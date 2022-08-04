package com.varxyz.javacafe.service;

import com.varxyz.javacafe.domain.Cart;

public interface CartService {
	int addCart(Cart cart);
	Cart checkCart(Cart cart);

}
