package lotto.domain;

import org.mockito.internal.matchers.Null;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public enum Rank {
    /*
    * FIRST ((6, false), 2_000_000_000) - 6개 일치
    * SECOND ((5, true), 30_000_000) - 5개 일치 && 보너스볼 일치
    * THIRD ((5, false), 1_500_000) - 5개 일치
    * FOURTH ((4, false), 50_000) - 4개 일치
    * FIFTH ((3, false), 5_000) - 3개 일치
    * MISS ((0, false), 0) - 당첨 실패
    */
    FIRST ((matchCount, bonus) -> matchCount == 6, 2_000_000_000),
    SECOND((matchCount, bonus) -> matchCount == 5 && bonus, 30_000_000),
    THIRD((matchCount, bonus) -> matchCount == 5 && !bonus, 1_500_000),
    FOURTH((matchCount, bonus) -> matchCount == 4, 50_000),
    FIFTH((matchCount, bonus) -> matchCount == 3, 5_000),
    MISS ((matchCount, bonus) -> matchCount < 3, 0);

    private final BiPredicate<Integer, Boolean> condition;
    private int winningAmount;
    Rank(BiPredicate<Integer, Boolean> condition, int winningAmount) {
        this.condition = condition;
        this.winningAmount = winningAmount;
    }

    public static Rank searchRank(int matchCount, boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(matchCount, isBonus))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
