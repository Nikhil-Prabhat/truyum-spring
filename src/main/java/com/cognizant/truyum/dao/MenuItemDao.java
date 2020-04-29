package com.cognizant.truyum.dao;

import java.util.Set;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public Set<MenuItem> getMenuItemListAdmin();

	public Set<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);
}
