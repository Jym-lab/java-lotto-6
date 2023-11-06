package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    /*
    * 2. 로또 당첨 번호 입력 에러
    * "1,2,3,4,5,6,7" - "로또 번호의 개수가 6개가 넘어가면 예외가 발생한다."
    * "1,1,2,2,3,3" - "로또 번호에 중복된 숫자가 있으면 예외가 발생한다."
    * "1,,2,3,4,5" - "연속적으로 콤마가 사용되면 예외가 발생한다." - Integer.parse에서 Exception
    * "1,2,3,4,5,3z2" - "숫자가 아닌 값이 입력되면 예외가 발생한다" - Integer.parse에서 Exception
    * "1,2,3,4,5,100" - "입력 값이 범위를 벗어나면 예외가 발생한다."
    * "1,2,3,4,5" - "로또 번호의 개수가 5개 이하라면 예외가 발생한다."
    */
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

    @DisplayName("입력 값이 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 5개 이하라면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 입력 범위를 벗어났다면 예외가 발생한다.")
    @Test
    void createBounsNumberOutOfRange(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> lotto.validateBonusRange(100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lotto.validateBonusRange(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호 리스트에 있다면 예외가 발생한다.")
    @Test
    void createBounsNumberDuplicate(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> lotto.validateBonusDuplicate(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}