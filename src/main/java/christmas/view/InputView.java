package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Exceptions;
import christmas.util.PrintPhrase;
import christmas.util.validator.DayInputValidator;
import christmas.util.validator.MenuInputValidator;

public class InputView {
	public static void printMessage(String msg) {
		System.out.println(msg);
	}

	public static int takeOrderDay() {
		printMessage(PrintPhrase.InputMessage.MSG_DAY_RESERVATION);
		int day = -1;
		String dayStr = Console.readLine();
		try {
			day = Integer.parseInt(dayStr);
			DayInputValidator.inRangeCheck(day);
		} catch (Exception e) {
			printMessage(Exceptions.ErrorMessage.INVALID_DAY);
			takeOrderDay();
		}
		return (day);
	}

	public static String takeOrderMenu() {
		printMessage(PrintPhrase.InputMessage.MSG_MENU_ORDER);
		String menu = Console.readLine();
		try {
			MenuInputValidator.parsingCheck(menu);
			MenuInputValidator.menuCheck(menu);
		} catch (Exception e) {

		}
		return menu;
	}
}
