package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    /*
    * 여기서부터 로또 구입 금액 테스트
    * 1. 영어가 포함되었는지
    * 2. 숫자가 음수인지
    * 3. 1000으로 나누어 떨어지는지
    */
    @DisplayName("구입 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void amountIsNegative(){
        assertThatThrownBy(() -> new UserAmount("-180,000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void AmountContainsAlphabet(){
        assertThatThrownBy(() -> new UserAmount("1800ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void amountNotDivisibleByThousand(){
        assertThatThrownBy(() -> new UserAmount("180,100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}