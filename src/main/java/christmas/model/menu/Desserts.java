package christmas.model.menu;

import static christmas.util.Constants.IntegerConstants.*;
import static christmas.util.Constants.StringConstants.*;

import java.util.Arrays;

public enum Desserts {
	CHOCO_CAKE(CHOCOLATE_CAKE_KOR_NAME, CHOCOLATE_CAKE_PRICE),
	ICE_CREAM(ICE_CREAM_KOR_NAME, ICE_CREAM_PRICE),
	UNKNOWN(UNKNOWN_NAME, ZERO);
	private final String name;
	private final int price;

	private Desserts(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public static Desserts find(String menuName) {
		return Arrays.stream(values())
			.filter(menu -> menu.name.equals(menuName))
			.findAny()
			.orElse(UNKNOWN);
	}
}
