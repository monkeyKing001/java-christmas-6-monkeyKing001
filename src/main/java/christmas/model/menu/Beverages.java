package christmas.model.menu;

import static christmas.util.Constants.IntegerConstants.*;
import static christmas.util.Constants.StringConstants.*;

import java.util.Arrays;

public enum Beverages {
	ZERO_COKE(ZERO_COKE_NAME, ZERO_COKE_PRICE),
	RED_WINE(RED_WINE_NAME, RED_WINE_PRICE),
	CHAMPAGNE(CHAMPAGNE_NAME, CHAMPAGNE_PRICE),
	UNKNOWN(UNKNOWN_NAME, ZERO);
	private final String name;
	private final int price;

	private Beverages(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public static Beverages find(String menuName) {
		return Arrays.stream(values())
			.filter(menu -> menu.name.equals(menuName))
			.findAny()
			.orElse(UNKNOWN);
	}
}
