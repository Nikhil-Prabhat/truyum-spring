package com.cognizant.truyum.dao;

import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		do {
			System.out.println("Menu");
			System.out.println("****************************************");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.println("****************************************");

			choice = sc.nextLine();
			System.out.println("****************************************");

			switch (choice) {
			case "1": {
				String adminChoice;
				do {
					System.out.println("Admin Menu");
					System.out.println("****************************************");
					System.out.println("1. Get Menu Item List");
					System.out.println("2. Modify Menu Item");
					System.out.println("3. Get Menu Item");
					System.out.println("4. Main Menu");
					System.out.println("****************************************");

					adminChoice = sc.nextLine();
					System.out.println("****************************************");

					switch (adminChoice) {
					case "1": {
						System.out.println("Admin Menu Item List");
						System.out.println("****************************************");
						testGetMenuItemListAdmin();
						break;
					}
					case "2": {
						System.out.println("Item 2 is modified. Enter 3 to display the changes.");
						System.out.println("****************************************");
						testModifyMenuItem();
						break;
					}
					case "3": {
						System.out.println("2nd Menu Item is displayed");
						System.out.println("****************************************");
						testGetMenuItem();
						break;
					}
					case "4": {
						break;
					}
					default: {
						System.out.println("Enter valid choice");
					}
					}
				} while (adminChoice.equals("4"));
				break;
			}
			case "2": {
				System.out.println("Customer Menu Item List");
				System.out.println("****************************************");
				testGetMenuItemListCustomer();
				break;
			}
			case "3": {
				break;
			}
			default: {
				System.out.println("Enter valid choice");
			}
			}
		} while (choice.equals("3"));

		sc.close();
	}

	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		Set<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		menuItemList.forEach((menuItem)->System.out.println(menuItem));
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		Set<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		menuItemList.forEach((menuItem)->System.out.println(menuItem));
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(2, "Hotdog", 129f, true, 
				DateUtil.convertToDate("23/12/2017"), "Main Course", false);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuItem);
	}

	public static void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println(menuItemDao.getMenuItem(2));
	}
}
