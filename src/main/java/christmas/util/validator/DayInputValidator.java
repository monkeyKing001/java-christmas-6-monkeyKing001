package christmas.util.validator;

import christmas.util.Constants.DayConstants;
import christmas.util.Exceptions;

public class DayInputValidator {
	public static void inRangeCheck(int day) {
		if (day > DayConstants.DEC_DAY_MAX || day < DayConstants.DEC_DAY_MIN) {
			throw new IllegalArgumentException(Exceptions.ErrorMessage.INVALID_DAY);
		}
	}
}
