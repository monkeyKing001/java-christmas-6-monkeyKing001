package christmas.controller;

import christmas.util.PrintPhrase;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
	private OrderController orderController;
	private DiscountController discountController;
	private InputView inputView;
	private OutputView outputView;

	public EventController() {
		orderController = new OrderController();
		discountController = new DiscountController();
	}

	public void eventStart() {
		greeting();
		orderController.takeOrderDay();
		orderController.takeOrderMenu();
		orderController.calculatePrice();
		orderController.calculateGift();
		orderController.calculateDiscount();
		orderController.report();
	}

	public void greeting() {
		inputView.printMessage(PrintPhrase.InputMessage.MSG_GREETING);
	}

}
