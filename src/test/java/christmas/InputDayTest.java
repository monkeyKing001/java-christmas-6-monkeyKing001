package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class InputDayTest extends NsTest {
	@Test
	@DisplayName("Day test 1 : not a digit")
	void dayExceptionNotDigit() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});

		assertSimpleTest(() -> {
			runException("dayOne");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});

		assertSimpleTest(() -> {
			runException("One");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});

		assertSimpleTest(() -> {
			runException("Two");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	@DisplayName("Day test 2 : not in range")
	void dayExceptionRange() {
		assertSimpleTest(() -> {
			runException("0");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});

		assertSimpleTest(() -> {
			runException("-1");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});

		assertSimpleTest(() -> {
			runException("32");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});

		assertSimpleTest(() -> {
			runException("-2147483650"); //underflow -> 1
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
