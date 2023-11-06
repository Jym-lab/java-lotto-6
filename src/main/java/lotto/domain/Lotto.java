package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.List;

public class Lotto {
    /*
     * 2. 로또 당첨 번호 입력 에러
     * "1,2,3,4,5,6,7" - "로또 번호의 개수가 6개가 넘어가면 예외가 발생한다."
     * "1,1,2,2,3,3" - "로또 번호에 중복된 숫자가 있으면 예외가 발생한다."
     * "1,2,3,4,5,100" - "입력 값이 범위를 벗어나면 예외가 발생한다."
     */
    private final List<Integer> numbers;
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorMessage.LOTTO_SIZE_EXCEPTION.print();
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (numbers.stream().distinct().count() < numbers.size()){
            ErrorMessage.DUPLICATED_NUMBER.print();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers){
        boolean isOver = numbers.stream().anyMatch(num -> num > LOTTO_MAX_NUMBER);
        boolean isUnder = numbers.stream().anyMatch(num -> num < LOTTO_MIN_NUMBER);
        if (isOver || isUnder){
            ErrorMessage.NUMBER_OUT_OF_RANGE.print();
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusRange(int bonus){
        if (bonus > LOTTO_MAX_NUMBER || bonus < LOTTO_MIN_NUMBER){
            ErrorMessage.NUMBER_OUT_OF_RANGE.print();
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusDuplicate(int bonus){
        if (this.numbers.contains(bonus)){
            ErrorMessage.DUPLICATED_NUMBER.print();
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers(){
        return this.numbers;
    }
}
