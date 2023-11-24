package christmas.util;

public class Exceptions {
	public static class ErrorMessage {
		public static final String ERROR = "[ERROR] ";
		public static final String TRY_AGAIN = "다시 입력해 주세요.";
		public static final String INVALID_DAY = ERROR + "유효하지 않은 날짜입니다. " + TRY_AGAIN;
		public static final String INVALID_MENU = ERROR + "유효하지 않은 주문입니다. " + TRY_AGAIN;
	}
}
