package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;

public interface KioskService {
	List<LargeCategory> getCategoryToKiosk();
	List<MenuItem> getAllMenuToKiosk();
	MenuItem SelectMenu();
}
