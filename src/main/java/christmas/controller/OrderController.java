package christmas.controller;

import java.util.Map;

import christmas.model.Badge;
import christmas.model.Discount;
import christmas.model.Gift;
import christmas.model.Order;
import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.util.Constants.IntegerConstants;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {
	InputView inputView;
	OutputView outputView;
	DiscountController discountController;

	public OrderController() {
		discountController = new DiscountController();
	}

	public void calculateDiscount(Order order) {
		Discount discount = order.getDiscount();
		discountController.getDiscount(order, discount);
	}

	public void calculateBill(Order order) {
		Discount discount = order.getDiscount();
		order.setTotalBill(discount.getTotalDiscount());
	}

	public void calculateGift(Order order) {
		Gift gift = order.getGift();
		if (order.getTotalPrice() >= IntegerConstants.CHAMPAGNE_THRESHOLD) {
			gift.setEnableGetGift();
		}
	}

	public void takeOrderDay(Order order) {
		int orderDay = inputView.takeOrderDay();
		order.setDay(orderDay);
	}

	public void takeOrderMenu(Order order) {
		//need orderMenu validation check
		String orderMenu = inputView.takeOrderMenu();
		order.setMenu(orderMenu);
	}

	public void calculatePrice(Order order) {
		calculateAppetizerPrice(order);
		calculateMainPrice(order);
		calculateBeveragePrice(order);
		calculateDessertPrice(order);
	}

	public void calculateMainPrice(Order order) {
		Map<MainMenus, Integer> mainMenusOrders = order.getMainMenus();
		for (MainMenus menu : mainMenusOrders.keySet()) {
			int count = mainMenusOrders.get(menu);
			if (count != IntegerConstants.ZERO) {
				order.addPrice(menu.getPrice() * count);
			}
		}
	}

	public void calculateDessertPrice(Order order) {
		Map<Desserts, Integer> dessertOrders = order.getDessertMenus();
		for (Desserts menu : dessertOrders.keySet()) {
			int count = dessertOrders.get(menu);
			if (count != IntegerConstants.ZERO) {
				order.addPrice(menu.getPrice() * count);
			}
		}
	}

	public void calculateAppetizerPrice(Order order) {
		Map<Appetizers, Integer> appetizerOrders = order.getAppetizerMenus();
		for (Appetizers appetizer : appetizerOrders.keySet()) {
			if (appetizerOrders.get(appetizer) != IntegerConstants.ZERO) {
				order.addPrice(appetizerOrders.get(appetizer) * appetizer.getPrice());
			}
		}
	}

	public void calculateBeveragePrice(Order order) {
		Map<Beverages, Integer> beverageOrders = order.getBeveragesMenus();
		for (Beverages beverage : beverageOrders.keySet()) {
			int count = beverageOrders.get(beverage);
			if (count != IntegerConstants.ZERO) {
				order.addPrice(count * beverage.getPrice());
			}
		}
	}

	public void calculateBadge(Order order) {
		Badge badge = order.getBadge();
		if (order.getTotalBill() >= IntegerConstants.STAR_BADGE_PRICE) {
			order.setBadge(Badge.STAR);
		}
		if (order.getTotalBill() >= IntegerConstants.TREE_BADGE_PRICE) {
			order.setBadge(Badge.TREE);
		}
		if (order.getTotalBill() >= IntegerConstants.SANTA_BADGE_PRICE) {
			order.setBadge(Badge.SANTA);
		}
	}
}
