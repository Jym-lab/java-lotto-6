package lotto.view;

public class ErrorMessage {
    private static final int LOTTO_PRICE = 1000;
    private static final String NOT_A_NUMBER = "[ERROR] 금액은 숫자만 입력해주세요.";
    private static final String NEGATIVE_NUMBER = "[ERROR] 음수는 입력 불가합니다.";
    private static final String NOT_DIVISIBLE_NUMBER = "[ERROR] 구매 금액은 " + LOTTO_PRICE + "원권만 사용해주세요.";

    public static void numberError() {
        System.out.println(NOT_A_NUMBER);
    }

    public static void negativeError() {
        System.out.println(NEGATIVE_NUMBER);
    }

    public static void divisibleError() {
        System.out.println(NOT_DIVISIBLE_NUMBER);
    }
}
