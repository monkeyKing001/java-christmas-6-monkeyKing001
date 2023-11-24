package christmas.controller;

import christmas.model.Event;
import christmas.model.Order;
import christmas.util.PrintPhrase;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
	private OrderController orderController;
	private InputView inputView;
	private OutputView outputView;

	public EventController() {
		orderController = new OrderController();
	}

	public void eventStart(Event event) {
		Order order = event.getOrder();
		greeting();
		orderController.takeOrderDay(order);
		orderController.takeOrderMenu(order);
		orderController.calculatePrice(order);
		orderController.calculateGift(order);
		orderController.calculateDiscount(order);
		orderController.calculateBill(order);
		orderController.calculateBadge(order);
		report(order);
	}

	private void report(Order order) {
		outputView.printReport(order);
	}

	public void greeting() {
		inputView.printMessage(PrintPhrase.InputMessage.MSG_GREETING);
	}
}
