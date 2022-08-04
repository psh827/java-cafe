package com.varxyz.javacafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.javacafe.dao.KioskDao;
import com.varxyz.javacafe.domain.LargeCategory;
import com.varxyz.javacafe.domain.MenuItem;

public class KioskServiceImpl implements KioskService{
	
	@Autowired
	KioskDao kioskDao;
	
	@Override
	public List<LargeCategory> getCategoryToKiosk() {
		return kioskDao.getCategoryToKiosk();
	}

	@Override
	public List<MenuItem> getAllMenuToKiosk(long lcFk) {
		return kioskDao.getAllMenuToKiosk(lcFk);
	}

	@Override
	public MenuItem SelectMenu() {
		return null;
	}

	@Override
	public MenuItem getMenuItemByImgName(String imgName) {
		return kioskDao.getMenuItemByImgName(imgName);
	}


}
