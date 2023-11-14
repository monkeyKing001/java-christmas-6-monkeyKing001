package christmas.controller;

import christmas.model.Discount;
import christmas.model.Order;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.util.Constants;
import christmas.util.Constants.DayConstants;

public class DiscountController {
	public void getDiscount(Order order, Discount discount) {
		//get mainDiscount
		if (order.getTotalPrice() < Constants.IntegerConstants.EVENT_QUALIFICATION_PRICE) {
			return;
		}
		setDDayDiscount(order, discount);
		setSpecialDiscount(order, discount);
		setMainMenuDiscount(order, discount);
		setDessertDiscount(order, discount);
	}

	public void setDDayDiscount(Order order, Discount discount) {
		//get D-dayDiscount
		if (order.getDay() <= DayConstants.CHRISTMAS_DAY) {
			discount.setDDayDiscount(order.getDay() - DayConstants.DEC_DAY_MIN);
		}
	}

	public void setSpecialDiscount(Order order, Discount discount) {
		//get specialDiscount
		int dayMod = order.getDay() % DayConstants.DAYS_IN_A_WEEK;
		if (order.getDay() == DayConstants.CHRISTMAS_DAY || dayMod == DayConstants.SUNDAY_MOD) {
			discount.setSpecialDiscount();
		}
	}

	public void setDessertDiscount(Order order, Discount discount) {
		//get dessertDiscount
		int dayMod = order.getDay() % DayConstants.DAYS_IN_A_WEEK;
		if (dayMod != DayConstants.FRIDAY_MOD && dayMod != DayConstants.SATURDAY_MOD) {
			for (Desserts menus : order.getDessertMenus().keySet()) {
				int count = order.getDessertMenus().get(menus);
				discount.setDessertMenuDiscount(count);
			}
		}
	}

	public void setMainMenuDiscount(Order order, Discount discount) {
		int dayMod = order.getDay() % DayConstants.DAYS_IN_A_WEEK;
		if (dayMod == DayConstants.FRIDAY_MOD || dayMod == DayConstants.SATURDAY_MOD) {
			for (MainMenus menus : order.getMainMenus().keySet()) {
				int count = order.getMainMenus().get(menus);
				discount.setMainMenuDiscount(count);
			}
		}
	}
}
