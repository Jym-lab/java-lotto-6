package lotto.domain;

import java.util.List;

public class LottoResult {
    private final Lotto winningLotto;
    private final int bonus;

    public LottoResult(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Rank compareLotto(Lotto userLotto) {
        List<Integer> userLottoNumbers = userLotto.getLottoNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getLottoNumbers();
        int matchCount = (int) userLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
        boolean isBonus = userLottoNumbers.contains(bonus);
        return Rank.searchRank(matchCount, isBonus);
    }
}
