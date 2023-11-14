package christmas.util;

public class PrintPhrase {
	public static final String FORMAT_ONE_DECIMAL = "#.##";
	public static final String FORMAT_PRICE = "###,###";
	public static final String COMMA = ",";
	public static final String BLANK = " ";
	public static final String BRACKET_START = "(";
	public static final String BRACKET_END = ")";
	public static final String MINUS = "-";
	public static final String PRICE_UNIT = "원";
	public static final String MENU_COUNT_UNIT = "개";

	public static class InputMessage {
		public static final String MSG_GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
		public static final String MSG_DAY_RESERVATION = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
		public static final String MSG_MENU_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

	}

	public static class OutputMessage {
		public static final String MSG_MENU_REPORT_TITLE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
		public static final String MSG_MENU_TITLE = "<주문 메뉴>";
		public static final String MSG_TOTAL_BILL_BEFORE_DISCOUNT_TITLE = "<할인 전 총주문 금액>";
		public static final String MSG_GIFT_TITLE = "<증정 메뉴>";
		public static final String MSG_BENEFIT_TITLE = "<혜택 내역>";
		public static final String MSG_TOTAL_DISCOUNT_TITLE = "<총혜택 금액>";
		public static final String MSG_TOTAL_BILL_TITLE = "<할인 후 예상 결제 금액>";
		public static final String MSG_BADGE_TITLE = "<12월 이벤트 배지>";
		public static final String MSG_D_DAY_DISCOUNT_TITLE = "크리스마스 디데이 할인: ";
		public static final String MSG_WEEKDAY_DISCOUNT_TITLE = "평일 할인: ";
		public static final String MSG_WEEKEND_DISCOUNT_TITLE = "주말 할인: ";
		public static final String MSG_SPECIAL_DISCOUNT_TITLE = "특별 할인: ";
		public static final String MSG_GIFT_DISCOUNT_TITLE = "증정 이벤트: ";
	}
}
