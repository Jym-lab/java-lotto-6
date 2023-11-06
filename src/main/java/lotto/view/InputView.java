package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static int inputAmount() {
        System.out.println(INPUT_AMOUNT);
        return numberCasting(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return listSplit(Console.readLine().split(","));
    }

    public static int inputBounsNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return numberCasting(Console.readLine());
    }

    private static int numberCasting(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            ErrorMessage.NOT_A_NUMBER.print();
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> listSplit (String[] numbers) {
        List<Integer> ret = new ArrayList<>();
        for (String number : numbers) {
            ret.add(numberCasting(number));
        }
        return ret;
    }
}
