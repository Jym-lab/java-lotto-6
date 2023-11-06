package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {
    LottoResult winngingLotto = new LottoResult(new Lotto(List.of(1, 9, 16, 19, 33, 42)), 5);

    @DisplayName("1등")
    @Test
    void lottoFirst() {
        Assertions.assertEquals(Rank.FIRST,
                winngingLotto.compareLotto(new Lotto(List.of(1, 9, 16, 19, 33, 42))));
    }

    @DisplayName("2등")
    @Test
    void lottoSecond() {
        Assertions.assertEquals(Rank.SECOND,
                winngingLotto.compareLotto(new Lotto(List.of(1, 5, 9, 16, 19, 33))));
    }

    @DisplayName("3등")
    @Test
    void lottoThird() {
        Assertions.assertEquals(Rank.THIRD,
                winngingLotto.compareLotto(new Lotto(List.of(1, 9, 16, 19, 33, 44))));
    }

    @DisplayName("4등")
    @Test
    void lottoFourth() {
        Assertions.assertEquals(Rank.FOURTH,
                winngingLotto.compareLotto(new Lotto(List.of(1, 9, 16, 19, 35, 44))));
    }

    @DisplayName("5등")
    @Test
    void lottoFifth() {
        Assertions.assertEquals(Rank.FIFTH,
                winngingLotto.compareLotto(new Lotto(List.of(1, 9, 16, 22, 35, 44))));
    }

    @DisplayName("미당첨")
    @Test
    void lottoMiss() {
        //2개
        Assertions.assertEquals(Rank.MISS,
                winngingLotto.compareLotto(new Lotto(List.of(1, 3, 5, 9, 10, 11))));
        //1개
        Assertions.assertEquals(Rank.MISS,
                winngingLotto.compareLotto(new Lotto(List.of(1, 5, 7, 8, 10, 11))));
        //0개
        Assertions.assertEquals(Rank.MISS,
                winngingLotto.compareLotto(new Lotto(List.of(2, 4, 6, 8, 10, 12))));
    }
}
