package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repositary.MenuItemRepository;

@Service
public class MenuItemService {
	//@Autowired
	//private MenuItemDao menuItemDao;
	@Autowired
	private MenuItemRepository menuItemRepository;
	//public void setMenuItemDao(MenuItemDao menuItemDao) {
	//	this.menuItemDao = menuItemDao;
	//}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}

	public List<MenuItem> getMenuItemListCustomer() {
		//return menuItemDao.getMenuItemListCustomer();
		return menuItemRepository.findByActiveTrueAndDateOfLaunchBefore(new Date());
	}

	public MenuItem getMenuItem(long menuItemId) {
		Optional<MenuItem> menuItem = menuItemRepository.findById(menuItemId);
		if(menuItem.isPresent())
			return menuItem.get();
		return null;
	}

	public void editMenuItem(MenuItem menuItem) {
		modifyMenuItem(menuItem);
	}
	public void modifyMenuItem(MenuItem menuItem) {
		//menuItemDao.modifyMenuItem(menuItem);
		menuItemRepository.save(menuItem);
	}
}
