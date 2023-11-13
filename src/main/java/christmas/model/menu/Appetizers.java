package christmas.model.menu;

import static christmas.util.Constants.IntegerConstants.*;
import static christmas.util.Constants.StringConstants.*;

import java.util.Arrays;

public enum Appetizers {
	MUSHROOM_SOUP(MUSHROOM_SOUP_NAME, MUSHROOM_SOUP_PRICE),
	TAPAS(TAPAS_KOR_NAME, TAPAS_PRICE),
	CAESAR_SALAD(CAESAR_SALAD_KOR_NAME, CAESAR_SALAD_PRICE),
	UNKNOWN(UNKNOWN_NAME, ZERO);
	private final String name;
	private final int price;

	private Appetizers(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public static Appetizers find(String menuName) {
		return Arrays.stream(values())
			.filter(menu -> menu.name.equals(menuName))
			.findAny()
			.orElse(UNKNOWN);
	}
}
