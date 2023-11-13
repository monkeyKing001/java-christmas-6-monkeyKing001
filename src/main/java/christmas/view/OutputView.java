package christmas.view;

import static christmas.util.Constants.IntegerConstants.*;

import java.text.DecimalFormat;
import java.util.Map;

import christmas.model.Order;
import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.model.menu.MenuInfo;
import christmas.util.PrintPhrase;

public class OutputView {
	public static void printMSG(String msg) {
		System.out.println(msg);
	}

	public static void printReport(Order order) {

	}

	public static void printReportTitle(Order order) {
		System.out.printf(PrintPhrase.OutputMessage.MSG_MENU_REPORT_TITLE, order.getDay());
		System.out.println();
	}

	public static void printOrderedMenu(Order order) {
		System.out.println();
		printMSG(PrintPhrase.OutputMessage.MSG_MENU_TITLE);
		Map<Appetizers, Integer> appetizers = order.getAppetizerMenus();
		Map<MainMenus, Integer> mainMenus = order.getMainMenus();
		Map<Desserts, Integer> desserts = order.getDessertMenus();
		Map<Beverages, Integer> beverages = order.getBeveragesMenus();
		printAppetizerInfo(appetizers);
		printMainMenuInfo(mainMenus);
		printDessertInfo(desserts);
		printBeverageInfo(beverages);
	}

	private static void printBeverageInfo(Map<Beverages, Integer> beverages) {
		for (Map.Entry<Beverages, Integer> entry : beverages.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	private static void printDessertInfo(Map<Desserts, Integer> desserts) {
		for (Map.Entry<Desserts, Integer> entry : desserts.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	private static void printMainMenuInfo(Map<MainMenus, Integer> mainMenus) {
		for (Map.Entry<MainMenus, Integer> entry : mainMenus.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	public static void printAppetizerInfo(Map<Appetizers, Integer> menuInfo) {
		for (Map.Entry<Appetizers, Integer> entry : menuInfo.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	public static void printTotalPrice(Order order) {
		System.out.println();
		printMSG(PrintPhrase.OutputMessage.MSG_TOTAL_BILL_BEFORE_DISCOUNT_TITLE);
		int totalPrice = order.getTotalPrice();
		DecimalFormat decimalFormat = new DecimalFormat(PrintPhrase.FORMAT_PRICE);
		System.out.println(decimalFormat.format(totalPrice));
	}
}
