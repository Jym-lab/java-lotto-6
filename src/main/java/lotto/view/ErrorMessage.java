package lotto.view;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자만 입력해주세요."),
    NEGATIVE_NUMBER("[ERROR] 음수는 입력 불가합니다."),
    NOT_DIVISIBLE_NUMBER("[ERROR] 구매 금액은 1000원권만 사용해주세요."),
    DUPLICATED_NUMBER("[ERROR] 당첨 번호는 중복되지 않게 입력해주세요."),
    NUMBER_OUT_OF_RANGE("[ERROR] 입력 값은 1에서 45사이의 숫자를 입력해주세요."),
    LOTTO_SIZE_EXCEPTION("[ERROR] 로또 번호는 정확히 6개가 입력되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
