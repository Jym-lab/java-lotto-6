package lotto.domain;

import lotto.view.ErrorMessage;

public class UserAmount {
    private final int LOTTO_PRICE = 1_000;
    private final int amount;
    public UserAmount (String amount){
        int tmp = validateNumber(amount);
        validateNegative(tmp);
        validateDivide(tmp);
        this.amount = tmp;
    }
    public int lottoCount() {
        return this.amount/LOTTO_PRICE;
    }
    private int validateNumber(String amount){
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e){
            ErrorMessage.NOT_A_NUMBER.print();
            throw new IllegalArgumentException();
        }
    }

    private void validateNegative(int amount){
        if (amount <= 0){
            ErrorMessage.NEGATIVE_NUMBER.print();
            throw new IllegalArgumentException();
        }
    }
    private void validateDivide(int amount) {
        if (amount % LOTTO_PRICE != 0){
            ErrorMessage.NOT_DIVISIBLE_NUMBER.print();
            throw new IllegalArgumentException();
        }
    }
}
