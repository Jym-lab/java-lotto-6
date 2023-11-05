package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static String inputAmount(){
        System.out.println(INPUT_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String inputBounsNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
