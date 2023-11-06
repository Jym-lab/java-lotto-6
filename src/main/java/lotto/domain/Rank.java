package lotto.domain;

public enum Rank {
    /*
    * FIRST (6, 2_000_000_000) - 6개 일치
    * SECOND (5, 30_000_000) - 5개 일치 && 보너스볼 일치
    * THIRD (5, 1_500_000) - 5개 일치
    * FOURTH (4, 50_000) - 4개 일치
    * FIFTH (3, 5_000) - 3개 일치
    * MISS (0, 0) - 당첨 실패
    */
    FIRST (6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS (0, 0);

    private int countMatch;
    private int winningAmount;
    Rank(int countMatch, int winningAmount) {
        this.countMatch = countMatch;
        this.winningAmount = winningAmount;
    }
}
