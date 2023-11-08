package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final int LOTTO_PRICE = 1000;
    private final double PERCENTAGE = 100;
    public void run() {
        UserAmount userAmount;
        List<Lotto> lottoList;
        Lotto winningNumbers;
        int bonus;

        userAmount = new UserAmount(InputView.inputAmount());
        OutputView.printLottoCount(userAmount.lottoCount());

        lottoList = createRandomLotto(userAmount.lottoCount());
        OutputView.printLottoList(lottoList);

        winningNumbers = new Lotto(InputView.inputWinningNumbers());
        bonus = InputView.inputBonusNumber();
        validateBonus(winningNumbers, bonus);
        lottoResult(lottoList, new LottoResult(winningNumbers, bonus), userAmount);
    }

    private List<Lotto> createRandomLotto(int lottoCount) {
        List<Lotto> randomLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            randomLotto.add(new Lotto(LottoGenerator.generate()));
        }
        return randomLotto;
    }

    private void validateBonus(Lotto winningNumbers, int bonus) {
        winningNumbers.validateBonusRange(bonus);
        winningNumbers.validateBonusDuplicate(bonus);
    }

    private void lottoResult(List<Lotto> lottoList,
                             LottoResult winningLotto,
                             UserAmount userAmount) {
        Map<Rank, Integer> result = setResult();
        for (Lotto currentLotto : lottoList) {
            Rank rank = winningLotto.compareLotto(currentLotto);
            result.put(rank, result.get(rank) + 1);
        }
        OutputView.printResult(result);
        OutputView.printRateReturn(calculateRateReturn(userAmount, result));
    }

    private double calculateRateReturn(UserAmount userAmount,
                                       Map<Rank, Integer> result) {
        int sum = 0;
        for (Map.Entry<Rank, Integer> m : result.entrySet()) {
            Rank key = m.getKey();
            int value = result.get(key);
            sum += key.getWinningAmount() * value;
        }
        return (((double)sum / (double) (userAmount.lottoCount() * LOTTO_PRICE)) * PERCENTAGE);
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        Rank[] rank = Rank.values();
        for (int i = rank.length - 1; i >= 0; i--) {
            result.put(rank[i], 0);
        }
        return result;
    }
}
