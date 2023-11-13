package christmas.model.menu;

import static christmas.util.Constants.IntegerConstants.*;
import static christmas.util.Constants.StringConstants.*;

import java.util.Arrays;

public enum MainMenus {
	T_BONE_STAKE(T_BONE_STAKE_KOR_NAME, T_BONE_STAKE_PRICE),
	BARBEQUE_RIB(BARBEQUE_RIB_KOR_NAME, BARBEQUE_RIB_PRICE),
	SEAFOOD_PASTA(SEAFOOD_PASTA_KOR_NAME, SEAFOOD_PASTA_PRICE),
	CHRISTMAS_PASTA(CHRISTMAS_PASTA_KOR_NAME, CHRISTMAS_PASTA_PRICE),
	UNKNOWN(UNKNOWN_NAME, ZERO);
	private final String name;
	private final int price;

	private MainMenus(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public static MainMenus find(String menuName) {
		return Arrays.stream(values())
			.filter(menu -> menu.name.equals(menuName))
			.findAny()
			.orElse(UNKNOWN);
	}
}
