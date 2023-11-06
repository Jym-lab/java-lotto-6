package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGeneratorTest {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> lotto = LottoGenerator.generate();

    @DisplayName("로또 번호 개수가 LOTTO_NUMBER_COUNT 개수만큼 있는지 검사")
    @Test
    void testGenerateCount() {
        Assertions.assertEquals(LOTTO_NUMBER_COUNT, lotto.size());
    }

    @DisplayName("생성된 숫자들이 유니크한지 테스트")
    @Test
    void testUniqueNumber() {
        Assertions.assertEquals(LOTTO_NUMBER_COUNT, new HashSet<>(lotto).size());
    }

    @DisplayName("생성된 숫자 리스트가 정렬되어 있는지 검사")
    @Test
    void testLottoSorted() {
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        Collections.sort(sortedLotto);
        Assertions.assertEquals(sortedLotto, lotto);
    }

    @DisplayName("생성된 숫자들이 지정된 범위 내에 있는지 검사")
    @Test
    void testLottoRange() {
        for (int number : lotto) {
            Assertions.assertTrue(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER);
        }
    }
}
