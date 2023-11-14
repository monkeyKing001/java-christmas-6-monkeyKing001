package christmas.controller;

import java.util.Map;

import christmas.model.Badge;
import christmas.model.Client;
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
	Order order;
	Client client;
	Gift gift;
	Discount discount;
	DiscountController discountController;
	Badge badge;

	public OrderController() {
		order = new Order();
		client = new Client();
		discount = new Discount();
		gift = new Gift();
		badge = Badge.NONE;
		discountController = new DiscountController();
	}

	public void calculateDiscount() {
		discountController.getDiscount(order, discount);
		calculateBill(order, discount);
	}

	public void calculateBill(Order order, Discount discount) {
		order.setTotalBill(discount.getTotalDiscount());
	}

	public void calculateGift() {
		if (order.getTotalPrice() >= IntegerConstants.CHAMPAGNE_THRESHOLD) {
			gift.setEnableGetGift();
		}
	}

	public void takeOrderDay() {
		int orderDay = inputView.takeOrderDay();
		order.setDay(orderDay);
	}

	public void takeOrderMenu() {
		//need orderMenu validation check
		String orderMenu = inputView.takeOrderMenu();
		order.setMenu(orderMenu);
	}

	public void calculatePrice() {
		//	discountController.getDiscount(order, discount);
		calculateAppetizerPrice(this.order);
		calculateMainPrice(this.order);
		calculateBeveragePrice(this.order);
		calculateDessertPrice(this.order);
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
		if (order.getTotalBill() >= IntegerConstants.STAR_BADGE_PRICE) {
			this.badge = Badge.STAR;
		}
		if (order.getTotalBill() >= IntegerConstants.TREE_BADGE_PRICE) {
			this.badge = Badge.TREE;
		}
		if (order.getTotalBill() >= IntegerConstants.SANTA_BADGE_PRICE) {
			this.badge = Badge.SANTA;
		}
	}

	public void report() {
		outputView.printReportTitle(order);
		outputView.printOrderedMenu(order);
		outputView.printTotalPrice(order);
		outputView.printGift(gift);
		outputView.printDiscountList(order, discount, gift);
		outputView.printTotalDiscount(discount, gift);
		outputView.printBill(order);
		//need split
		calculateBadge(order);
		outputView.printBadge(order, badge);
	}
}
