package lotto.view;

public class OutputView {
    private static final String LOTTO_COUNT = "개를 구매했습니다.";

    public static void printLottoCount(int LottoCount) {
        System.out.println(LottoCount + LOTTO_COUNT);
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
