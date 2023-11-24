package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class MenuTest extends NsTest {
	@Test
	@DisplayName("Menu test 1 : parsing error - not number")
	void menuParsingError() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-a");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 1-1 : parsing error - no number")
	void menuParsingError1() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-3,타파스-");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 1-2 : parsing error - start comma")
	void menuParsingError2() {
		assertSimpleTest(() -> {
			runException("3", ",제로콜라-3");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 1-3 : parsing error - ends comma")
	void menuParsingError3() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-3,");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 1-4 : parsing error - double comma")
	void menuParsingError4() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-3,,타파스-3");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 1-5 : parsing error - double dash")
	void menuParsingError5() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-3,,타파스--3");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 2 : not found menu")
	void menuNotFoundError() {
		assertSimpleTest(() -> {
			runException("3", "아무거나-3,타파스-2");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 3 : not distinct menu")
	void menuNotDistinctError() {
		assertSimpleTest(() -> {
			runException("3", "타파스-2,타파스-2");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 4 : only beverage menu")
	void menuOnlyBeverageError() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-2,레드와인-2");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 5 : menu count over range")
	void menuOverRangeError() {
		assertSimpleTest(() -> {
			runException("25", "제로콜라-10,바비큐립-11");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Menu test 6 : menu count under range")
	void menuUnderRangeError() {
		assertSimpleTest(() -> {
			runException("3", "제로콜라-0,바비큐립-5");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
