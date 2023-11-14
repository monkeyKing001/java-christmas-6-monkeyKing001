package christmas.model;

import java.util.EnumMap;
import java.util.Map;

import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.util.PrintPhrase;

public class Order {
	private int day;
	private int totalPrice = 0;
	private int totalBill = 0;
	private Gift gift;
	private Badge badge;
	private Discount discount;
	final Map<Appetizers, Integer> appetizers;
	final Map<MainMenus, Integer> mainMenus;
	final Map<Beverages, Integer> beverages;
	final Map<Desserts, Integer> dessertMenus;

	public Order() {
		appetizers = new EnumMap<>(Appetizers.class);
		mainMenus = new EnumMap<>(MainMenus.class);
		beverages = new EnumMap<>(Beverages.class);
		dessertMenus = new EnumMap<>(Desserts.class);
		discount = new Discount();
		gift = new Gift();
		badge = Badge.NONE;
	}

	public void setDay(int orderDay) {
		day = orderDay;
	}

	public void setBeverageMenu(Beverages orderMenu, int count) {
		beverages.put(orderMenu, count);
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
	}

	public void setMainMenu(MainMenus orderMenu, int count) {
		mainMenus.put(orderMenu, count);
	}

	public void setDessertMenu(Desserts orderMenu, int count) {
		dessertMenus.put(orderMenu, count);
	}

	public int getDay() {
		return day;
	}

	public Map<Desserts, Integer> getDessertMenus() {
		return dessertMenus;
	}

	public Map<MainMenus, Integer> getMainMenus() {
		return mainMenus;
	}

	public Map<Appetizers, Integer> getAppetizerMenus() {
		return appetizers;
	}

	public Map<Beverages, Integer> getBeveragesMenus() {
		return beverages;
	}

	public void addPrice(int price) {
		this.totalPrice += price;

	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public int getTotalBill() {
		return this.totalBill;
	}

	public void setTotalBill(int discount) {
		this.totalBill = this.totalPrice - discount;
	}

	public Gift getGift() {
		return gift;
	}

	public Badge getBadge() {
		return badge;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setBadge(Badge badgeType) {
		this.badge = badgeType;
	}

}
