# 구현 목록 정리
## 📌코드 구현 목표
```markdown
1. 도메인 로직에 단위 테스트를 구현해야 한다.
  가. 기능을 로직 단위로 잘라서 구현한 뒤 테스트를 수행한다.
  나. 먼저 테스트 코드를 작성한 뒤 각 테스트 코드에 맞는 기능을 구현한다.
```
### ❓ 도메인이란?
```markdown
소프트웨어 공학에서 도메인(또는 비즈니스)은
소프트웨어가 풀고자하는 현실 세상의 문제를 가리킨다.
말이 조금 어렵긴한데 은행 앱의 도메인은 입금, 출금, 계좌조회 등의 기능이고
틱톡같은 동영상 앱의 도메인은, 영상 업로드, 조회, 공유등이 틱톡 도메인이다.
```
### 🔔 도메인 로직
```markdown
도메인 로직 또는 비즈니스 로직이란 위에서 설명한 도메인을 해결할 솔루션을
컴퓨터가 이해하고 처리할 수 있도록 코딩해둔 것을 말한다.
하지만 여기서 프로그램을 어떻게 빠르게 동작할 것인지,
많은 정보를 어떻게 저장할 것인지에 대한 건 도메인 로직이 아니다.
```
### 🔨 실천방안
```markdown
먼저 디렉토리 구조를 좀 변경할 생각이다.
MVC 패턴에 기반하여 구조를 변경한다. DB를 다루지 않으니 Model은 제외
└──src
    ├── main
    │   ├── java
    │   │   └── lotto
    │   │       ├── controller
    │   │       ├── domain
    │   │       └── view
    │   └── Application.java
```
---
## 🧑‍💻 기능 구현 목록 작성
### View - 사용자 입력 클래스 (InputView)
- 구입 금액 입력 (inputAmount)
- 로또 당첨 번호 입력 (inputWinningNumbers)
- 보너스 번호 입력 (inputBounsNumber)
### View - 시스템 출력 클래스 (OutputView)
- 티켓 구매 개수 출력 (printTickets)
- 당첨 메시지 출력 (printResultMessage)
- 당첨 통계 출력 (printWinningStatistics)
- 수익률 출력 (printRevenuePer)
- 에러 메시지 출력 (printErrorMessage)
### View - 에러 메시지(ErrorMessage)
- 에러메시지들 Java Enum으로 관리

### domain - 로또 구입 금액 처리(UserAmount)
- 구입 금액 에러 검출 후 저장 (constructor)
- 구입한 로또 개수 (lottoCount)
- 입력받은 금액이 숫자인지 (validateNumber)
- 1000원(1장 구입 금액)으로 나누어 떨어지는지 (validateDivide)
- 입력받은 금액이 음수인지 (validateNegative)

### domain - 당첨금 Java Enum(Rank)
- FIRST ((6, false), 2_000_000_000) - 6개 일치
- SECOND ((5, true), 30_000_000) - 5개 일치 && 보너스볼 일치
- THIRD ((5, false), 1_500_000) - 5개 일치
- FOURTH ((4, false), 50_000) - 4개 일치
- FIFTH ((3, false), 5_000) - 3개 일치
- MISS ((0, false), 0) - 당첨 실패

### domain - 로또 번호 생성(LottoGenerator)
- 1에서 45사이의 중복없는 n개의 로또 티켓 생성 (generate)

### domain - 로또(Lotto)
- 입력된 로또 번호가 정상인지 검출 후 저장 (constructor)
- 로또 번호가 6개 이상이거나 5개 이하인지 검사 (validate)
- 당첨 로또 값에 중복 값이 있는지 검사 (validateDuplicate)
- 당첨 로또 입력 값이 입력 범위를 초과 하였는지 검사 (validateRange)
- 보너스 번호가 당첨 로또에 있는지 검사 (validateBouns)
### domain - 로또 당첨 판별(LottoResult)
- 로또가 당첨과 몇개 일치하는지 검사하고 Rank 리턴 (match)
### controller - 로또 프로그램 실행(LottoController)
- 로또 앱 실행 (run)
- 당첨 수익률 계산 (calculrateRevenuePer)
---
## ✍ TestCode 작성
### 1. 사용자 입력
1. 로또 구입 금액 입력 에러 - "올바르지 않은 금액"
    * "180,100" - 숫자가 1000으로 나누어 떨어지지 않는 경우
    * "-180,000" - 음수가 입력 된 경우
2. 로또 당첨 번호 입력 에러 - "올바르지 않은 입력 값"
    * "1,,2,3,4,5,6" - 연속적으로 콤마가 사용된 경우
    * "1, ,2,3,4,5,6" - 입력 값에 공백이 포함된 경우
    * "1,2,3,4,1 5,3z2" - 숫자와 공백 또는 문자열이 함께 입력된 경우
    * "1,2,3,4,5,6,7" - 입력 값이 7개 이상인 경우
    * "1,2,3,4,5,100" - 입력 값이 범위를 벗어난 경우
    * "1,1,2,2,3,3" - 중복 값이 입력된 경우
    * "1,2,3,4,5" - 로또 번호의 개수가 5개 이하인 경우
3. 랜덤 로또 숫자 생성 테스트
4. 구매한 로또 번호와 당첨 번호 비교해 등수 확인
5. 수익률 계산 테스트