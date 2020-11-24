# Day16.미션 7 2048게임
## 목록(Contents)
- (1) 구현 영상

> ## 1.**구현**
 자바 스윙(Java Swing)을 공부할 계획이었으나, 우선
 2048을 구현하고  Java Swing을 공부하고 구현해야 필요성을 느끼고 공부하려고 2순위로 미뤄두었습니다.
그런데 당일 완성 예정이었던 2048 게임이 로직이 잘못되어 기존 코드를 모두 엎고 다시 짜느라 모든 기능을 구현하지 못했네요;;
  처음 작성한 로직이 잘못되었다는 것을 깨닫고 다시 로직을 구성하느라 시간이 너무 오래 걸렸습니다.
그래서 현재 진행한 로직만 간단하게 소개하고 마무리 하겠습니다.

```
[위로 이동]
w
 0 4 2 0
 0 0 0 0
 0 0 0 0
 0 0 0 0

[왼쪽으로 이동]
a
 4 2 0 0
 0 0 0 0
 0 0 0 0
 0 0 0 0
```
현재 구현 기능을 보시는 것처럼 기존 2048게임처럼 한쪽으로 값들이 몰리는 것을
확인할 수 있었습니다. 현재 같은 값을 합하는 로직을 구현한 상태이지만 추가 값을 추가하는 기능을 구현해야
값을 합칠 수 있기 때문에 그 부분은 나중에 말씀드리는 것으로 하겠습니다.
```
── main ── java ─────┬───────── Application.java
                     ├───────── Board.java
                     ├───────── Command.java
                     ├───────── InputView.java
                     ├───────── Main.java
                     ├───────── Number.java
                     └───────── RandomCreator.java

```
- Application.java : Applicaition 전체 구현 로직
- Board.java : 2048 맵. 
- Command.java(enum) : 명령어
- InputView.java : 입출력 클래스
- Main.java : Main method 존재 클래스
- Number.java : 맵 안에 들어가는 숫자 값
- RandowmCreator : 값을 추가하기 위한 위치 값 반환 클래스

이번 2048을 구현하기 위해서는 연속해서 빈공간에 값을 추가해주어야 합니다. 현재 생각하고 있는 로직은 턴 1회가 지날때마다
2를 랜덤하게 추가해주는 것을 목적으로 하고 있습니다. 이를 구현하기 위해서 RandomCreator 클래스를 선언해서 난수가 자동적으로 생산
되는 클래스를 별도로 선언했습니다.   
 그리고 enum을 사용해보고 싶어서 Command를 enum 클래스로 선언해주었습니다.
현재는 움직임만 완성한 단계라 간략하게 코드에 대해 설명하도록 하겠습니다.
 
 ```java
[Application.java]

    private void setCommand(String command_str) {
        if (command_str.equalsIgnoreCase("w")) {
            command = Command.UP;
        }
        if (command_str.equalsIgnoreCase("s")) {
            command = Command.DOWN;
        }
        if (command_str.equalsIgnoreCase("a")) {
            command = Command.LEFT;
        }
        if (command_str.equalsIgnoreCase("d")) {
            command = Command.RIGHT;
        }
    }

```
기존의 코드의 경우 단순히 equalsIgnoreCase를 선언하는 방법이었지만 이번 2048 게임에서는
우선 enum 클래스의 객체로 변환하고자 하였습니다.   
 왜 굳이 저렇게 한번 더 돌아가는 로직을 짰는지에 대해 의문점이 있겠지만 실제 명령어를 처리하는 부분에서 보면
 훨씬 코드의 가독성이 좋아지는 것을 볼 수 있습니다.
 ```java
[Application.java]

        public void actionCommand() {
            setCommand(InputView.inputCommand());
    
            if (command == Command.UP) {
                board.moveToUp();
            }
    
            if (command == Command.DOWN) {
                board.moveToUnder();
            }
    
            if (command == Command.LEFT) {
                board.moveToLeft();
            }
    
            if (command == Command.RIGHT) {
                board.moveToRight();
            }
    
            board.printMapStatus();
        }
```
 현재 코드를 보면 내용을 보고 바로 의미 파악이 가능합니다. 예를 들어 이 명령어는 위로 가는 
 명령어라는 것을 한눈에 확인할 수 있습니다. 비록 지금은 enum을 잘 활용하지 못하지만 자바의 강점 중에 하나가
 enum이라는 이야기가 있습니다. 추후에 enum 공부를 더 열심히 해서 관련된 글을 기재하도록 하겠습니다.   
  이번에는 한가지 예시(Command.moveToup())을 통해서 로직을 설명하도록 하겠습니다.
 ```java
    [board.java]

    private Number[][] numberArray;

    public Board() {
        initNumberArray();
    }

    private void initNumberArray() {
        this.numberArray = new Number[RANGE_MAX][RANGE_MAX];

        for (int row = 0; row < RANGE_MAX; row++) {
            initColumn(row);
        }

        makeNumber(2);
        makeNumber(4);
    }
```
 로직을 이해하기 위해서는 Board class를 확인해보아야 합니다. 보시는 것과 같이 이차원 배열을 선언하였습니다.
 그리고 가장 눈에 띄는 것은 타입이 Number이라는 것입니다.  
    
 Q. 그냥 정수 이차원 배열을 선언해도 되는데 왜 저렇게 구현했어요?   
  2048게임은 숫자가 연속적으로 이동하면서 값이 변경되는 상황이 많이 발생합니다.
  값이 변경되거나 이동하는 상황에서 계속해서 코드에 연산자를 사용할 수 있지만 계속해서 연산자를 사용하게 되면
  의미를 파악하기 어려울 뿐만 아니라 코드가 지저분해 보이는 경우가 발생하기도 합니다.   
  이를 개선하고자 객체 타입을 정의해서 각자의 값들이 자발적으로 객체 자신의 상태를 변경하고자 하였습니다.   
  아래 코드는 값 자체가 곱하는 행위를 Board.java에서 사용한 코드입니다.
  확실히 곱한다는 것을 확인할 수 있습니다.
  
  ```java
[Number.java]
    public void multiply() {
        this.number *= 2;
    }

[Board.java]
    if (areSameNumbers(firstNumber, secondNumber)) {
        firstNumber.multiply();
    } else {
        queue_temp.add(firstNumber);
        firstNumber = secondNumber;
    }
```

---
### [로직]
```java
class Board {
    private static final int RANGE_MAX = 4;

    private Number[][] numberArray;

    public Board() {
        initNumberArray();
    }
    ...
}
```
 Board class를 보시면 알 수 있듯이 Number 타입의 이차원 배열 형태로 선언했습니다.
 위에 설명한 것과 같이 객체로 별도로 선언시, 값의 자발적인 행위를 유도할 수 있습니다.

```java
class Board{
...
    private void initNumberArray() {
        this.numberArray = new Number[RANGE_MAX][RANGE_MAX];

        for (int row = 0; row < RANGE_MAX; row++) {
            initColumn(row);
        }

        generateNumber(2);
        generateNumber(4);
    }
}
```
위 로직은 이차원 배열을 초기하고 2, 4의 위치를 임의로 위치할 수 있는 메서드 입니다.
다시 보니 메서드 이름이 불분명한 것 같네요;;   
개괄적인 설명으로 마무리하고 아래부터는 로직에 대해 설명하겠습니다.

```java
    public void moveToUp() {
        for (int col = 0; col < RANGE_MAX; col++) {
            checkUpwardMovement(col);
        }
    }
```
 이차원 배열은 행과 열로 구분되어 있습니다. 만약 모든 값들이 위로 올라가기 위해서는 어떻게 해야 할까요?
 열을 기준으로 해서 행들의 값들을 모두 위로 이동하도록 구현하면 됩니다.   
 위에 보시는 것과 같이 우선 열을 기준으로 하고 이후에 행을 탐색하도록하는 로직을 구현합니다. 
 ```java
class Board{
    ...
    private void checkUpwardMovement(int col) {
        Queue<Number> queue = new LinkedList<>();

        for (int row = 0; row < RANGE_MAX; row++) {
            Number thisNumber = this.numberArray[row][col];

            if (thisNumber.equals(Number.zero())) {
                continue;
            }
            queue.add(thisNumber);
        }

        queue = checkMultiply(queue);
        moveElementsToUp(queue, col);
    }
}
```
우선 로직은 아래와 같이 구성됩니다.
- 행을 탐색하며 숫자 값을 입력받는다.(0 제외)
- Queue에 추가하며 같은 숫자일 경우, 값을 더한다.
- 연산된 결과를 가지고 해당하는 행을 모두 갱신한다.

위 내용을 미뤄보았을 때는 첫번째 내용에 해당하는 부분이겠네요.
그러다면 빠르게 두번째 단계를 확인해볼게요.
```java
class Board{
        ...
   private Queue<Number> checkMultiply(Queue<Number> queue) {
        Queue<Number> queue_temp = new LinkedList<>();
        Number firstNumber;
        Number secondNumber;

        if (queue.size() == 1) {
            firstNumber = queue.poll();
            queue_temp.add(firstNumber);
            return queue_temp;
        }

        firstNumber = queue.poll();

        while (!queue.isEmpty()) {
            secondNumber = queue.peek();

            if (areSameNumbers(firstNumber, secondNumber)) {
                firstNumber.multiply();
            } else {
                queue_temp.add(firstNumber);
                firstNumber = secondNumber;
            }
            queue.poll();

            if(queue.isEmpty()) {
                queue_temp.add(firstNumber);
            }
        }

        return queue_temp;
    }
}
```
 해당 로직은 아까 말씀드렸던 숫자를 합하는 로직을 구현한 부분입니다.
 하지만 큐는 나중에 갱신을 해야하는 역할도 있기 때문에 무작정 값들을 버릴 수 었다는 점은 유의해주세요!
 우선적으로 값이 하나만 존재하는 경우가 있을 수 있습니다. 그 상황을 대비해서 윗 부분에 조건문을 통해 한 개의 값만
 존재할 때에 대한 경우를 대비합니다. 그러고 나서 아래에 부터 2개 이상일 경우에 대한 로직을 처리하도록 합니다.
 위 내용을 보시면 같은 경우는 값을 곱해서 추가하고 아닐 경우에는 기존의 값을 넣고 1번 값을 대신하는 것을 볼 수 있습니다.
 ```java
class Board{
    private void moveElementsToUp(Queue<Number> queue, int col) {
        int row = 0;

        while (row < RANGE_MAX) {
            if (!queue.isEmpty()) {
                Number number = queue.poll();
                this.numberArray[row++][col] = number;
                continue;
            }

            this.numberArray[row++][col] = Number.zero();
        }
    }
}
```
 마지막으로 연산이 완료된 Queue를 해당 행에 값을 갱신하는 코드입니다. for문을 많이 사용하지만 이번 경우는
 Queue가 모두 출력하고 모든 값을 갱신할 수 있는 row의 값도 중요하기 때문에 row를 기준으로 반복문을 돌리도록 했습니다.
 이런 식으로 진행하면 가장 위에서 보셨던 것과 같은 장면을 보실 수 있을겁니다.   
  별거 없는 내용에 장황하게 써놓았지만 아직 연습중이라는 점을 이해해주시고 이런식으 코드를 작성했구나 정도로만 
봐주시면 감사하겠습니다.