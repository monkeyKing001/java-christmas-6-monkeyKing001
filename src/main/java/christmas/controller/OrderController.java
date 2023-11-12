package christmas.controller;

import christmas.model.Client;
import christmas.model.Discount;
import christmas.model.Order;
import christmas.util.PrintPhrase;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {
	InputView inputView;
	OutputView outputView;
	Order order;
	Client client;
	Discount discount;

	public OrderController() {
		order = new Order();
		client = new Client();
		discount = new Discount();
	}

	public void takeOrderDay() {
		inputView.takeOrderDay();
	}

	public void takeOrderMenu() {
	}

	public void calculate() {
	}

	public void report() {
	}

	public void greeting() {
		inputView.printMessage(PrintPhrase.InputMessage.MSG_GREETING);
	}
}
