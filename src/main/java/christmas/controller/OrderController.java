package christmas.controller;

import static christmas.util.Constants.IntegerConstants.*;

import java.util.Map;

import christmas.model.Client;
import christmas.model.Discount;
import christmas.model.Order;
import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {
	InputView inputView;
	OutputView outputView;
	Order order;
	Client client;
	Discount discount;
	DiscountController discountController;

	public OrderController() {
		order = new Order();
		client = new Client();
		discount = new Discount();
		discountController = new DiscountController();
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

	public void calculate() {
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
			if (count != ZERO) {
				order.addPrice(menu.getPrice() * count);
			}
		}
	}

	public void calculateDessertPrice(Order order) {
		Map<Desserts, Integer> dessertOrders = order.getDessertMenus();
		for (Desserts menu : dessertOrders.keySet()) {
			int count = dessertOrders.get(menu);
			if (count != ZERO) {
				order.addPrice(menu.getPrice() * count);
			}
		}
	}

	public void calculateAppetizerPrice(Order order) {
		Map<Appetizers, Integer> appetizerOrders = order.getAppetizerMenus();
		for (Appetizers appetizer : appetizerOrders.keySet()) {
			if (appetizerOrders.get(appetizer) != ZERO) {
				order.addPrice(appetizerOrders.get(appetizer) * appetizer.getPrice());
			}
		}
	}

	public void calculateBeveragePrice(Order order) {
		Map<Beverages, Integer> beverageOrders = order.getBeveragesMenus();
		for (Beverages beverage : beverageOrders.keySet()) {
			int count = beverageOrders.get(beverage);
			if (count != ZERO) {
				order.addPrice(count * beverage.getPrice());
			}
		}
	}

	public void report() {
		outputView.printReportTitle(order);
		outputView.printOrderedMenu(order);
		outputView.printTotalPrice(order);
	}
}
