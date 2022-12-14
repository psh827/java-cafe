package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.javacafe.dao.AdminDao;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.provider.CategoryProvider;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	@Transactional
	public long addProduct(MenuItem menuItem, Image img) {
		long menuId = adminDao.addProduct(menuItem);
		adminDao.addProductImg(menuId, img);
		return 0;
	}

	@Override
	public boolean addCategory(LargeCategory largeCategory) {
		return adminDao.addCategory(largeCategory);
	}

	@Override
	public List<MenuItem> viewAllMenu() {
		return adminDao.viewAllMenu();
	}

	@Override
	public List<CategoryProvider> getCategory() {
		return adminDao.getCategory();
	}

	@Override
	public LargeCategory isCate(LargeCategory largecategory) {
		return adminDao.isCate(largecategory);
	}

	@Override
	public MenuItem isMenuItem(MenuItem menuitem) {
		return adminDao.isMenuItem(menuitem);
	}

	@Override
	public int deleteMenuByMenuItemName(long menuid) {
		return adminDao.deleteMenuByMenuItemName(menuid);
	}


}
