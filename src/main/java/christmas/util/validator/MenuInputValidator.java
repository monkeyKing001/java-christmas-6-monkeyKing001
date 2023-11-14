package christmas.util.validator;

import java.util.HashSet;
import java.util.Set;

import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.util.Constants;
import christmas.util.Constants.IntegerConstants;
import christmas.util.PrintPhrase;
import christmas.util.Util;

public class MenuInputValidator {
	public static void parsingCheck(String menu) {
		if (Util.startsWithComma(menu) || Util.endsWithComma(menu)) {
			throw new IllegalArgumentException();
		}
		if (Util.getTokenSize(menu, PrintPhrase.COMMA) == Constants.IntegerConstants.ZERO) {
			throw new IllegalArgumentException();
		}
		String[] tokens = menu.split(PrintPhrase.COMMA);
		for (String menuInfo : tokens) {
			String[] menuInfoTok = menuInfo.split(PrintPhrase.MINUS);
			if (menuInfoTok.length != IntegerConstants.MENU_INFO_TOKEN_SIZE) {
				throw new IllegalArgumentException();
			}
			if (!Util.isNumber(menuInfoTok[1])) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static void menuCheck(String menu) {
		menuFoundCheck(menu);
		menuDistinctCheck(menu);
		menuOnlyBeverageCheck(menu);
		menuCountCheck(menu);
	}

	private static void menuCountCheck(String menu) {
		int totalCount = 0;
		String[] tokens = menu.split(PrintPhrase.COMMA);
		for (String menuInfo : tokens) {
			String[] menuInfoTok = menuInfo.split(PrintPhrase.MINUS);
			String menuName = menuInfoTok[0];
			int count = Integer.parseInt(menuInfoTok[1]);
			totalCount += count;
			if (count < IntegerConstants.MIN_MENU_COUNT) {
				throw new IllegalArgumentException();
			}
			if (totalCount > IntegerConstants.MAX_MENU_COUNT) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static void menuOnlyBeverageCheck(String menu) {
		String[] tokens = menu.split(PrintPhrase.COMMA);
		for (String menuInfo : tokens) {
			String[] menuInfoTok = menuInfo.split(PrintPhrase.MINUS);
			String menuName = menuInfoTok[0];
			if (Beverages.find(menuName) != Beverages.UNKNOWN) {
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	public static void menuDistinctCheck(String menu) {
		String[] tokens = menu.split(PrintPhrase.COMMA);
		Set<String> menuSet = new HashSet<>();
		for (String menuInfo : tokens) {
			String menuName = menuInfo.split(PrintPhrase.MINUS)[0];
			menuSet.add(menuName);
		}
		if (menuSet.size() != tokens.length) {
			throw new IllegalArgumentException();
		}
	}

	public static void menuFoundCheck(String menu) {
		String[] tokens = menu.split(PrintPhrase.COMMA);
		for (String menuInfo : tokens) {
			String[] menuInfoTok = menuInfo.split(PrintPhrase.MINUS);
			String menuName = menuInfoTok[0];
			if (Beverages.find(menuName) == Beverages.UNKNOWN &&
				MainMenus.find(menuName) == MainMenus.UNKNOWN &&
				Appetizers.find(menuName) == Appetizers.UNKNOWN &&
				Desserts.find(menuName) == Desserts.UNKNOWN) {
				throw new IllegalArgumentException();
			}
		}
	}
}
