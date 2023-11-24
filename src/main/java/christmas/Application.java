package christmas;

import christmas.controller.EventController;
import christmas.model.Event;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		Event event = new Event();
		EventController eventController = new EventController();
		eventController.eventStart(event);
		;
	}
}
