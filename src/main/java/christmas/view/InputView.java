package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Exceptions;
import christmas.util.PrintPhrase;

public class InputView {
	public static void printMessage(String msg) {
		System.out.println(msg);
	}

	public static int takeOrderDay() {
		printMessage(PrintPhrase.InputMessage.MSG_DAY_RESERVATION);
		int day = -1;
		try {
			String dayStr = Console.readLine();
			day = Integer.parseInt(dayStr);
		} catch (Exception e) {
			printMessage(Exceptions.ErrorMessage.INVALID_DAY);
			takeOrderDay();
		}
		return (day);
	}

	public static String takeOrderMenu() {
		printMessage(PrintPhrase.InputMessage.MSG_MENU_ORDER);
		String menu = Console.readLine();
		return menu;
	}
}
