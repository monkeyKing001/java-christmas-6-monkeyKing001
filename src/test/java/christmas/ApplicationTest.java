package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	private static final String LINE_SEPARATOR = System.lineSeparator();

	@Test
	void 모든_타이틀_출력() {
		assertSimpleTest(() -> {
			run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
			assertThat(output()).contains(
				"<주문 메뉴>",
				"<할인 전 총주문 금액>",
				"<증정 메뉴>",
				"<혜택 내역>",
				"<총혜택 금액>",
				"<할인 후 예상 결제 금액>",
				"<12월 이벤트 배지>"
			);
		});
	}

	@Test
	void 혜택_내역_없음_출력() {
		assertSimpleTest(() -> {
			run("26", "타파스-1,제로콜라-1");
			assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
		});
	}

	@Test
	void 날짜_예외_테스트() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 주문_예외_테스트() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-a");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 혜택내역() {
		assertSimpleTest(() -> {
			runException("3", "바비큐립-2,타파스-2");
			assertThat(output()).contains(
				"<할인 전 총주문 금액>" + LINE_SEPARATOR + "119,000원",
				"<증정 메뉴>" + LINE_SEPARATOR + "없음",
				"크리스마스 디데이 할인: -1,200원",
				"특별 할인: -1,000원",
				"<총혜택 금액>" + LINE_SEPARATOR + "-2,200원",
				"<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "116,800원",
				"<12월 이벤트 배지>" + LINE_SEPARATOR + "없음"
			);
		});
		assertSimpleTest(() -> {
			runException("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
			assertThat(output()).contains(
				"<할인 전 총주문 금액>" + LINE_SEPARATOR + "142,000원",
				"<증정 메뉴>" + LINE_SEPARATOR + "샴페인 1개",
				"크리스마스 디데이 할인: -1,200원",
				"평일 할인: -4,046원",
				"특별 할인: -1,000원",
				"증정 이벤트: -25,000원",
				"<총혜택 금액>" + LINE_SEPARATOR + "-31,246원",
				"<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "135,754원",
				"<12월 이벤트 배지>" + LINE_SEPARATOR + "산타"
			);
		});
		assertSimpleTest(() -> {
			runException("26", "해산물파스타-1,레드와인-1,티본스테이크-1");
			assertThat(output()).contains(
				"<할인 전 총주문 금액>" + LINE_SEPARATOR + "150,000원",
				"<증정 메뉴>" + LINE_SEPARATOR + "샴페인 1개",
				"<혜택 내역>" + LINE_SEPARATOR,
				"증정 이벤트: -25,000원",
				"<총혜택 금액>" + LINE_SEPARATOR + "-25,000원",
				"<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "150,000원",
				"<12월 이벤트 배지>" + LINE_SEPARATOR + "산타"
			);
		});
		assertSimpleTest(() -> {
			runException("26", "해산물파스타-1,레드와인-1,티본스테이크-1,초코케이크-1");
			assertThat(output()).contains(
				"<할인 전 총주문 금액>" + LINE_SEPARATOR + "165,000원",
				"<증정 메뉴>" + LINE_SEPARATOR + "샴페인 1개",
				"<혜택 내역>" + LINE_SEPARATOR,
				"평일 할인: -2,023원",
				"증정 이벤트: -25,000원",
				"<총혜택 금액>" + LINE_SEPARATOR + "-27,023원",
				"<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "162,977원",
				"<12월 이벤트 배지>" + LINE_SEPARATOR + "산타"
			);
		});
	}

	@Test
	@DisplayName("Weekend check")
	void 혜택내역1() {
		assertSimpleTest(() -> {
			runException("31", "타파스-1,레드와인-3");
			assertThat(output()).contains(
				"<할인 전 총주문 금액>" + LINE_SEPARATOR + "185,500원",
				"<증정 메뉴>" + LINE_SEPARATOR + "샴페인 1개",
				"<혜택 내역>" + LINE_SEPARATOR,
				"특별 할인: -1,000원",
				"증정 이벤트: -25,000원",
				"<총혜택 금액>" + LINE_SEPARATOR + "-26,000원",
				"<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "184,500원",
				"<12월 이벤트 배지>" + LINE_SEPARATOR + "산타"
			);
		});
	}

	@Test
	@DisplayName("Weekend check2")
	void 혜택내역2() {
		assertSimpleTest(() -> {
			runException("31", "타파스-1,티본스테이크-1");
			assertThat(output()).contains(
				"<할인 전 총주문 금액>" + LINE_SEPARATOR + "60,500원",
				"<증정 메뉴>" + LINE_SEPARATOR + "없음",
				"<혜택 내역>" + LINE_SEPARATOR,
				"특별 할인: -1,000원",
				"<총혜택 금액>" + LINE_SEPARATOR + "-1,000원",
				"<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "59,500원",
				"<12월 이벤트 배지>" + LINE_SEPARATOR + "없음"
			);
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
