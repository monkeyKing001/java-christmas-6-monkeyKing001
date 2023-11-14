package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

import christmas.model.Badge;
import christmas.model.Discount;
import christmas.model.Gift;
import christmas.model.Order;
import christmas.model.menu.Appetizers;
import christmas.model.menu.Beverages;
import christmas.model.menu.Desserts;
import christmas.model.menu.MainMenus;
import christmas.model.menu.MenuInfo;
import christmas.util.Constants;
import christmas.util.Constants.IntegerConstants;
import christmas.util.PrintPhrase;

public class OutputView {
	public static void printMSG(String msg) {
		System.out.println(msg);
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
			if (count != IntegerConstants.ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	private static void printDessertInfo(Map<Desserts, Integer> desserts) {
		for (Map.Entry<Desserts, Integer> entry : desserts.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != IntegerConstants.ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	private static void printMainMenuInfo(Map<MainMenus, Integer> mainMenus) {
		for (Map.Entry<MainMenus, Integer> entry : mainMenus.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != IntegerConstants.ZERO) {
				printMSG(menuName.getName() + PrintPhrase.BLANK + count + PrintPhrase.MENU_COUNT_UNIT);
			}
		}
	}

	public static void printAppetizerInfo(Map<Appetizers, Integer> menuInfo) {
		for (Map.Entry<Appetizers, Integer> entry : menuInfo.entrySet()) {
			MenuInfo menuName = entry.getKey();
			Integer count = entry.getValue();
			if (count != IntegerConstants.ZERO) {
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

	public static void printDiscountList(Order order) {

		System.out.println();
		printMSG(PrintPhrase.OutputMessage.MSG_BENEFIT_TITLE);
		Discount discount = order.getDiscount();
		Gift gift = order.getGift();
		if (discount.getTotalDiscount() == IntegerConstants.ZERO) {
			printMSG(PrintPhrase.NONE);
			return;
		}
		printDiscountByTitle(discount.getDDayDiscount(), PrintPhrase.OutputMessage.MSG_D_DAY_DISCOUNT_TITLE);
		printDiscountByTitle(discount.getDessertMenuDiscount(), PrintPhrase.OutputMessage.MSG_WEEKDAY_DISCOUNT_TITLE);
		printDiscountByTitle(discount.getMainMenuDiscount(), PrintPhrase.OutputMessage.MSG_WEEKEND_DISCOUNT_TITLE);
		printDiscountByTitle(discount.getSpecialDiscount(), PrintPhrase.OutputMessage.MSG_SPECIAL_DISCOUNT_TITLE);
		printDiscountByTitle(gift.getGiftPrice(), PrintPhrase.OutputMessage.MSG_GIFT_DISCOUNT_TITLE);
	}

	public static void printDiscountByTitle(int discount, String msg) {
		DecimalFormat decimalFormat = new DecimalFormat(PrintPhrase.FORMAT_PRICE);
		if (discount != Constants.IntegerConstants.ZERO) {
			printMSG(msg + PrintPhrase.MINUS +
				decimalFormat.format(discount) +
				PrintPhrase.PRICE_UNIT);
		}
	}

	public static void printTotalDiscount(Order order) {
		System.out.println();
		Discount discount = order.getDiscount();
		Gift gift = order.getGift();
		printMSG(PrintPhrase.OutputMessage.MSG_TOTAL_DISCOUNT_TITLE);
		int totalDiscount = discount.getTotalDiscount() + gift.getMyGiftPrice();
		DecimalFormat decimalFormat = new DecimalFormat(PrintPhrase.FORMAT_PRICE);
		if (totalDiscount != IntegerConstants.ZERO) {
			System.out.print(PrintPhrase.MINUS);
		}
		printMSG(decimalFormat.format(totalDiscount) + PrintPhrase.PRICE_UNIT);
	}

	public static void printBill(Order order) {
		System.out.println();
		printMSG(PrintPhrase.OutputMessage.MSG_TOTAL_BILL_TITLE);
		int totalBill = order.getTotalBill();
		DecimalFormat decimalFormat = new DecimalFormat(PrintPhrase.FORMAT_PRICE);
		printMSG(PrintPhrase.MINUS +
			decimalFormat.format(totalBill) +
			PrintPhrase.PRICE_UNIT);
	}

	public static void printBadge(Order order) {
		Badge badge = order.getBadge();
		System.out.println();
		printMSG(PrintPhrase.OutputMessage.MSG_BADGE_TITLE);
		printMSG(badge.getName());
	}

	public static void printGift(Order order) {
		Gift gift = order.getGift();
		System.out.println();
		printMSG(PrintPhrase.OutputMessage.MSG_GIFT_TITLE);
		if (gift.EnableGetGift()) {
			printMSG(PrintPhrase.OutputMessage.MSG_GIFT);
		} else if (!gift.EnableGetGift()) {
			printMSG(PrintPhrase.NONE);
		}
	}

	public static void printReport(Order order) {
		printReportTitle(order);
		printOrderedMenu(order);
		printTotalPrice(order);
		printGift(order);
		printDiscountList(order);
		printTotalDiscount(order);
		printBill(order);
		printBadge(order);
	}
}
