package lotto.view;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 금액은 숫자만 입력해주세요."),
    NEGATIVE_NUMBER("[ERROR] 음수는 입력 불가합니다."),
    NOT_DIVISIBLE_NUMBER("[ERROR] 구매 금액은 1000원권만 사용해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
