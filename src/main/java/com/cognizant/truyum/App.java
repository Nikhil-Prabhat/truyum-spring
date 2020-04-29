package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@ComponentScan
public class App {
	private static Logger LOGGER;
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
		LOGGER = LoggerFactory.getLogger(App.class);
		LOGGER.info("Start Main");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService = BeanUtil.getBean(MenuItemService.class);
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
		
		LOGGER.info("End Main");
	}
	public static void testGetMenuItemListAdmin() {
		LOGGER.info("Start");
		List<MenuItem> menuItemListAdmin = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("MenuItemListAdmin:{}", menuItemListAdmin);
		LOGGER.info("End");
	}

	public static void testGetMenuItemListCustomer() {
		LOGGER.info("Start");
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("MenuItemListCustomer:{}", menuItemListCustomer);
		LOGGER.info("End");
	}

	public static void testModifyMenuItem() {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(2);
		menuItem.setName("Sandwich");
		menuItemService.modifyMenuItem(menuItem);
		menuItem = menuItemService.getMenuItem(1);
		LOGGER.debug("MenuItem:{}", menuItem);
		LOGGER.info("End");
	}

	public static void testGetMenuItem() {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(1);
		LOGGER.debug("MenuItem:{}", menuItem);
		LOGGER.info("End");
	}
}

