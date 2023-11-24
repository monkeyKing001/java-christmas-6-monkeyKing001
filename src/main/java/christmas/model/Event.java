package christmas.model;

public class Event {
	Order order;

	public Event() {
		order = new Order();
	}

	public Order getOrder() {
		return order;
	}
}
