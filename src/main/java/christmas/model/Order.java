package christmas.model;

import java.util.EnumMap;
import java.util.Map;

import christmas.model.menu.Beverages;
import christmas.util.PrintPhrase;

public class Order {
	int day;

	final Map<Beverages, Integer> beverages;

	public Order() {
		beverages = new EnumMap<>(Beverages.class);
	}

	public void setDay(int orderDay) {
		day = orderDay;
	}

	public void setOrderBeverage(Beverages bev, int count) {
		beverages.put(bev, count);
		//System.out.println("now " + bev.getName() + " : " + count);
	}

	public void setMenu(String orderMenu) {
		String[] menu = orderMenu.split(PrintPhrase.COMMA);
		for (int i = 0; i < menu.length; i++) {
			String[] info = menu[i].split("-");
			String menuName = info[0];
			int count = Integer.parseInt(info[1]);
			Beverages findBeverages = Beverages.find(menuName);
			if (findBeverages != Beverages.UNKNOWN)
				setOrderBeverage(findBeverages, count);
		}
	}
}
