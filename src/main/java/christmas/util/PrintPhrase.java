package christmas.util;

public class PrintPhrase {
	public static final String FORMAT_ONE_DECIMAL = "#.##";
	public static final String FORMAT_PRICE = "###,###";
	public static final String COMMA = ",";
	public static final String BLANK = " ";
	public static final String BRACKET_START = "(";
	public static final String BRACKET_END = ")";
	public static final String LINE = "-";
	public static final String PRICE_UNIT = "원;";
	public static final String MENU_COUNT_UNIT = "개;";

	public static class InputMessage {
		public static final String MSG_GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
		public static final String MSG_DAY_RESERVATION = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
		public static final String MSG_ = "보너스 번호를 입력해 주세요.";
	}

	public static class OutputMessage {
		public static final String MSG_MENU_TITLE = "<주문메뉴>";
		public static final String MSG_TOTAL_BILL_BEFORE_DISCOUNT_TITLE = "<할인 전 총 주문 금액>";
		public static final String MSG_GIFT_TITLE = "<증정 메뉴>";
		public static final String MSG_BENEFIT_TITLE = "<혜택 내역>";
		public static final String MSG_BADGE_TITLE = "<12월 이벤트 배지>";

	}
}
