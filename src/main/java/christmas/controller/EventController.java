package christmas.controller;

import christmas.model.Order;
import christmas.util.PrintPhrase;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
	private OrderController orderController;
	private DiscountController discountController;
	private InputView inputView;
	private OutputView outputView;
	private Order order;

	public EventController() {
		orderController = new OrderController();
		discountController = new DiscountController();
		order = new Order();
	}

	public void eventStart() {
		greeting();
		orderController.takeOrderDay();
		orderController.takeOrderMenu();
		orderController.calculatePrice();
		orderController.calculateGift();
		orderController.calculateDiscount();
		orderController.report();
		orderController.takeOrderDay(order);
		orderController.takeOrderMenu(order);
		orderController.calculatePrice(order);
		orderController.calculateGift(order);
		orderController.calculateDiscount(order);
		report(order);
		orderController.report();
	}

	private void report(Order order) {

	}

	public void greeting() {
		inputView.printMessage(PrintPhrase.InputMessage.MSG_GREETING);
	}

}
