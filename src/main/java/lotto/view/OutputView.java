package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String LOTTO_COUNT = "개를 구매했습니다.";
    private static final String WINNING_COUNT = "{0} ({1}원) - {2}개";
    private static final String RATE_RETURN = "총 수익률은 {0}%입니다.";

    public static void printLottoCount(int LottoCount) {
        System.out.println(LottoCount + LOTTO_COUNT);
    }

    public static void printLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void printResult(Map<Rank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        result.forEach(OutputView::printLottoResult);
    }

    private static void printLottoResult(Rank key, int value) {
        if (!key.equals(Rank.MISS)){
            NumberFormat numberFormat = NumberFormat.getInstance();
            System.out.println(MessageFormat.format(WINNING_COUNT,
                    key.getMessage(),
                    numberFormat.format(key.getWinningAmount()),
                    value));
        }
    }

    public static void printRateReturn(double rate) {
        System.out.println(MessageFormat.format(RATE_RETURN,
                String.format("%.1f", rate)));
    }
}
