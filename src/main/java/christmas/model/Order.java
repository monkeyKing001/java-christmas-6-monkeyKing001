package christmas.model;

import java.util.EnumMap;
import java.util.Map;

import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.util.PrintPhrase;

public class Order {
	int day;
	final Map<Beverages, Integer> beverages;
	final Map<Appetizers, Integer> appetizers;
	final Map<MainMenus, Integer> mainMenus;
	final Map<Desserts, Integer> dessertMenus;

	public Order() {
		beverages = new EnumMap<>(Beverages.class);
		appetizers = new EnumMap<>(Appetizers.class);
		mainMenus = new EnumMap<>(MainMenus.class);
		dessertMenus = new EnumMap<>(Desserts.class);
	}

	public void setDay(int orderDay) {
		day = orderDay;
	}

	public void setBeverageMenu(Beverages orderMenu, int count) {
		beverages.put(orderMenu, count);
		System.out.println("now " + orderMenu.getName() + " : " + count);
	}

	public void setMenu(String orderMenu) {
		String[] menu = orderMenu.split(PrintPhrase.COMMA);
		for (int i = 0; i < menu.length; i++) {
			String[] info = menu[i].split("-");
			String menuName = info[0];
			int count = Integer.parseInt(info[1]);
			Beverages findBeverages = Beverages.find(menuName);
			Appetizers findAppetizers = Appetizers.find(menuName);
			MainMenus findMainMenus = MainMenus.find(menuName);
			Desserts findDesserts = Desserts.find(menuName);
			if (findBeverages != Beverages.UNKNOWN) {
				setBeverageMenu(findBeverages, count);
			}
			if (findAppetizers != Appetizers.UNKNOWN) {
				setAppetizerMenu(findAppetizers, count);
			}
			if (findMainMenus != MainMenus.UNKNOWN) {
				setMainMenu(findMainMenus, count);
			}
			if (findDesserts != Desserts.UNKNOWN) {
				setDessertMenu(findDesserts, count);
			}
		}
	}

	public void setAppetizerMenu(Appetizers orderMenu, int count) {
		appetizers.put(orderMenu, count);
		System.out.println("now " + orderMenu.getName() + " : " + count);
	}

	public void setMainMenu(MainMenus orderMenu, int count) {
		mainMenus.put(orderMenu, count);
		System.out.println("now " + orderMenu.getName() + " : " + count);
	}

	public void setDessertMenu(Desserts orderMenu, int count) {
		dessertMenus.put(orderMenu, count);
		System.out.println("now " + orderMenu.getName() + " : " + count);
	}
}
