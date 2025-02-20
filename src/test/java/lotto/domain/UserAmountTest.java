package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserAmountTest {
    /*
     * 여기서부터 로또 구입 금액 테스트
     * 1. 숫자가 음수인지
     * 2. 1000으로 나누어 떨어지는지
     */
    @DisplayName("구입 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void amountIsNegative() {
        assertThatThrownBy(() -> new UserAmount(-180000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void amountNotDivisibleByThousand() {
        assertThatThrownBy(() -> new UserAmount(180100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
