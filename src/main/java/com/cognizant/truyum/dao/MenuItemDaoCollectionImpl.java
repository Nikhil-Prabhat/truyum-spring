package com.cognizant.truyum.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
@Qualifier("menuItemDao")
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	@Autowired
	private Set<MenuItem> menuItemList;

	@Override
	public Set<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public Set<MenuItem> getMenuItemListCustomer() {
		Set<MenuItem> customerMenuItemList = new HashSet<MenuItem>();

		for (MenuItem menuItem : menuItemList) {

			if ((menuItem.getDateOfLaunch().equals(new Date()) || menuItem.getDateOfLaunch().before(new Date()))
					&& menuItem.getActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		return customerMenuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem itr : menuItemList) {
			if (itr.equals(menuItem)) {
				itr.setActive(menuItem.getActive());
				itr.setCategory(menuItem.getCategory());
				itr.setDateOfLaunch(menuItem.getDateOfLaunch());
				itr.setFreeDelivery(menuItem.getFreeDelivery());
				itr.setName(menuItem.getName());
				itr.setPrice(menuItem.getPrice());
				break;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (MenuItem itr : menuItemList) {
			if (itr.getId() == menuItemId) {
				menuItem = itr;
				break;
			}
		}
		return menuItem;
	}

}
