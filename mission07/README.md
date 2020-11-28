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
<br><br><br>

# Day17.수업 정리 및 자바 메모장 만들기
## 목록(Contents)
- (1) 수업 정리
    - What is AWT?
    - 수업 코드
- (2) 자바 메모장 만들기
    - 메뉴바 만들기
    - 파일 저장 기능
    - 파일 불러오기 기능
> ## 1.**수업 정리**

> ### (1) What is AWT?
 ```
 - GUI(Graphic User Interface)   
 사용자가 그래픽을 통해서 하드웨어와 상호작용하는 환경.
 - AWT(Abstract Window ToolKit)는
  GUI 어플리케이션의 개발에 필요한 여러 개의 관련 패키지와 클래스의 집합
 - 플랫폼(PlatForm)
  컴퓨터 시스템의 기본이 되는 특정 프로세서 모델과 하나의 컴퓨터 시스템을
  바탕으로 하는 운영체제  
 ```
1. ATW는 플랫폼 의존성을 띄고 있다.
GUI 컴포넌트를 직접 구현하지 않고 OS의 컴포넌트를 사용한다.
(↔ 반면에, swing class는 **플랫폼 독립적**이다.)  
 
    - **플랫폼 독립성** : 특정 운영체제나 기계에 의존적이지 않는 것을 의미.( 플랫폼 의존성)

2. SWING은 AWT의 확장형이다.
    - AWT보다 풍부한 기능의 컴포넌트를 제공함
    - JVM 기반으로 설치되어 있는 네이티브 플랫폼에 의존한다.(**OS에 의존X**)

3. AWT vs SWING
    - 성능 : AWT > SWING → AWT는 플랫폼 독립성을 포기하고, 속도를 선택
    - 코딩 : AWT < SWING → AWT보다 다양한 컴포넌트를 만들어야 해서 코딩할 요소 많음.
    - 학습 : AWT > SWING → AWT 먼저 학습하고 SWING을 공부하자.

> ### (2) 수업 코드
```java     
    class Test1 extends Frame {...}
``` 
 일반적으로는 Frame class을 extends로 확장받아 구현하는 방식으로 시작한다. 
```java
clas Test1{
    public Test1() {
        initUI();
    }

    private void initUI() {
        setTitle("Week4 App");
        setSize(640, 480); /* 1. dimension 객체 사용   2. 좌표 사용 */
    }
}
```
생성자를 통해서 Frame의 Title과 size를 사용하는 방법니다. size 설정하는 방법은 (1) dimesion 객체를 사용하거나, (2) 좌표를 사용하는
방법이 있다.
```java
class Test1{
    public Test1() {
        addButton();
    }
    
     private void addButton() {
         b = new Button("Click me if you can");
         b.setSize(100, 30);
         b.setLocation(this.getWidth() / 2, this.getHeight() / 2);
         b.addActionListener((ActionEvent e) -> { /* 1. Listener를 생성한다. */
             System.out.println(e.getActionCommand());
         });
         add(b);
     }   
}
```
해당 내용을 button을 추가하는 메서드를 생성자에 선언해서 인스턴스 생성과 동시에 버튼을 생성하도록 하는 방법이다. 
메서드 addButton은    
(1) 버튼 생성   
(2) 사이즈 설정   
(3) 위치 설정   
(4) 리스너 처리   
(5) frame에 추가   
방식으로 진행된다. 그리고 리스너를 처리하는 방식은 크게 3가지로 존재한다.

1.  addListener에 익명 클래스를 처리하는 방식
```
    b.addActionListener(new WindowListener(){
        @Override
        public void windowOpnend(WindowEvent e) {
        
        }
    }
```

2. addListener에 람다를 사용하는 방식
```
    b.addActionListener((ActionEvent e) -> {
        System.out.println(e.getActionCommand());
    });
```
- 장점 : 훨씬 코드가 간결하면서 보기 편한다.
- 단점 : 람다는 모르면 사용하기 어렵다.
3. Listener 사용방법
```java
           @Override
            public void windowClosing(WindowEvent e) { /* windowEvent 객체 형태로 입력 받아서 명령을 처리한다 */
                System.out.println("닫힘버튼 눌렸니?");
                dispose();
                /* e.getWindow().dispose() 형태로 사용이 필요없는 이유 :
                 *       프레임의 내부 함수와 멤버변수를 받았기 때문에(Closable)
                 */
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }
            ....(구현 메서드들)
        });
```
- 단점 : 모든 메서드들을 구현해야 한다.
4. Adapter 사용방법
```
    b.addActionListener(new MyAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }     
   });
```
- 장점 : 모든 메서드들을 정의할 필요없이 원하는 부분만 구현하면 된다.
- 왜냐하면 adapter의 메서드들은 비어있는 메서드이기 때문이다.

> ## (2) 자바 메모장 만들기
![자바메모장](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/docs/images/notepad.PNG)   
해당 내용을 소스 코드로 대체합니다. → [[소스코드]](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/notepad/NoteView.java)

# Day18.미션 8 2048 UI 구현하기 + 그림판 선그리기
## 목록(Contents)
(1) 구현영상  
(2) 그림판 선그리기
<br><br>
> ### (1) 구현영상   
![캡처](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/docs/images/2048.PNG)
 [코드는 여기!](https://github.com/pbg0205/codesquad-cocoa-java/tree/master/mission07/src/main/java/game2048)   
  전에 한번 스터디를 하면서 Java GUI를 처음 접해보게 되었는데 이렇게 다시 접하게 될 줄 몰랐다. 그 때도 미숙한 코드를 가지고 
  어떻게든 달력을 만들어볼려고 아등바등하던 때가 엊그제 같은데 지금 코드스쿼드에 와서 2048게임을 만들고 있다니 그래도 기쁘다.
 아직 AWT와 SWING부분을 적용해본 적이 많지 않아서 아직도 직접 코드로 구현해볼 때 어려움이 따르는게 사실이었다. 그리고 기존에
 콘솔 기반으로 프로그래밍을 작업했을 때는 어렵지만 클래스 분류를 하는 방식이 쉬었는데 이번 GUI의 경우 Frame에 add를 하는 경우에
 기존에 있는 타입이 아니면 add가 되지 않는 현상이 있서 별도로 클래스를 분류하는 것이 어려워 이번 단계에서는 GameView class에
 GUI 코드와 승리 조건에 대한 코드를 추가되었다. 서당개로 살아온 입장에서 객체는 최대한 하나의 책임을 가지고 행동할 수 있도록
 구현해야 한다고 들었지만 아직까지 자바의 길은 멀기만 하지만 아직 더 공부해보고 싶다.   
 
### [여기서부터 코드 정리]
  
 ```java
class GameView extends Frame {
    private static final int ARRAY_RANGE_MAX = 4;
    private Board board; 
    
    private Label[][] labels;
    private Font font;
```
 우선적으로 해당 클래스는 GUI 구현을 목적으로 작성한 클래스이다. 그런데 초코칩같이 사이에 박혀있는 내부 로직에 대한 점은 꾸준히
 학습해서 하나씩 빼낼 예정이다. 아직 많이 부족하다. 다시 집중하고 코드를 보자.   
  이전에 2048게임을 콘솔에 구현한 버전에서 게임판을 Number[][] 형태의 이차원 배열로 선언했다. GUI 또한 이와 같이 이차원 배열로
  표현하는 것이 코드를 구현하는데 있어 혼돈할 요소과 줄어들 것 같아 Label[][] 이차원 배열로 선언했다. 그리고 글씨체를 조금 더
  다듬기 위해 Font를 사용했다. 
     
 ```java
class GameView extends Frame {
    public GameView() {
        initFrame();
        initFont();
        initBoard();
        setLabels();
        initEvent();
    }    
}
```
  우선 내가 처음 구현하면서 생각한 방식은
 1. Frame을 초기화한다.
 2. Label을 초기화 한다.
 3. 명령어가 입력되는 과정에서 Label을 계속해서 갱신된다.   

그렇다면 아래와 같은 코드를 어떻게 구현했는지 확인해보자.

```java
class GameView extends Frame {
    private void initFrame() {
        setTitle("2048");
        setSize(640, 480);
        setLayout(new GridLayout(ARRAY_RANGE_MAX, ARRAY_RANGE_MAX, 30, 30));
        setLocation(getWidth() / 2, getHeight() / 2);
        setVisible(true);
    }
}
```
Frame은 기본적으로 3가지 과정을 거쳐야 한다.
1. 생성(extends Frame(혹은 생성자 선언방식))
2. 크기 설정(setSize())
3. 보이기(setVisible())

나머지는 이 기본적인 과정에 조금 더 이뻐보이기 위해서 작업한 것으로 생각하면 편하다.
setLayOut의 경우 Frame 내부의 컴포넌트들을 어떤 식으로 정렬해서 보여줄 것인지에 대한 내용이고,
setLocation의 경우 컴포넌트의 위치를 설정하는 메서드이다.

```java
class GameView extends Frame {
    private void setLabels() {
        this.labels = new Label[ARRAY_RANGE_MAX][ARRAY_RANGE_MAX];

        for (int row = 0; row < ARRAY_RANGE_MAX; row++) {
            initLabel(row);
        }
    }

    private void initLabel(int row) {
        for (int col = 0; col < ARRAY_RANGE_MAX; col++) {
            String value = String.valueOf(board.getNumber(row, col));
            labels[row][col] = new Label(value);
            setLabelDetail(row, col);
        }
        pack();
    }

    private void setLabelDetail(int row, int col) {
        labels[row][col].setSize(50, 50);
        labels[row][col].setAlignment(Label.CENTER);
        labels[row][col].setFont(font);

        add(labels[row][col]);
    }
}
```

Labels는 이전에 이야기한 것과 같이 board 클래스 내부의 이차원 배열과 똑같은 형태로 표현하기
위해서 동일하게 이차원 배열을 사용해서 값을 초기화하는 과정이다. 또한 내부 열에 해당하는 부분에 도착하면 
그 부분을 board의 위치한 숫자와 동일한 값으로 초기화시키고 세부내용을 조정(좀 더 꾸미는) 코드를 작성한 것이다.
가장 큰 단점은 나에게는 뛰어난 미적 감각이 존재하지 않기 때문에 기본에 충실하려고 노력하면서 코드를 작성했다.
```java
class GameView extends Frame {    
    private void initEvent() {
        addCommand();
        addExitEvent();
    }
}
```
컴포넌트의 세팅을 완성한 후, 이제 동작에 대한 설정을 해야 한다. 2048게임은 기존 FPS 움직임 방식(AWSD)방식과 같게
설정했다.
```java
class GameView extends Frame {
    private void addCommand() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'w') {
                    board.moveToUp();
                }

                if (ke.getKeyChar() == 's') {
                    board.moveToUnder();
                }

                if (ke.getKeyChar() == 'a') {
                    board.moveToLeft();
                }

                if (ke.getKeyChar() == 'd') {
                    board.moveToRight();
                }

                checkWinner();
                checkFinish();

                removeAll();
                setLabels();
            }
        });
    }
}
```
 이 코드는 상당히 길어보이지만 막상 말하면 별거 없다. 한마디로 키보드에 대한 입력값을 처리하는 부분이다.
입력에 대한 명령어를 처리하기 위해서 KeyAdapter를 사용했다. keyType 메서드는 키보드가 눌렀다 뗏을 때
처리하는 메서드이다. 그래서 움직임에 따라서 조건문을 처리해서 해당 값에 대한 명을 처리하도록 구현했다.   
 그리고 아래 보이는 코드의 경우 Label들을 갱신해야 하기 때문에 모든 값들을 다시 지우고 다시 추가하는
 방식으로 구현했다.   
 
 # Day19. 수업 정리
  ## 목록(Contents)
 - (1) awt/swing을 이용한 고양이 다마고치
 - (2) 쓰레드 Timer
 
 > ### awt/swing을 이용한 고양이 애니메이션
이번 강의는 swing을 이용한 고양이 애니메이션 구현 라이브 코딩이었다. 기존의 수업의 경우 CS의 전반적인 지식과 키워드를 중접적으로 
 설명하셨지만 이번 시간은 직접 코드를 작성하시는 점에서 기대가 되었다. 이전에 코코아 과정을 신청하면서 나보다 잘하는 분은 코드를
 작성하는지에 대한 궁금증이 있었다. 그래서 기존의 다른 수업들 보다 나에게는 더욱 크게 다가왔다.
  swing은 java GUI 프로그램이다. awt의 경우 OS의 컴포넌트를 사용하기 때문에 상대적으로 플랫폼에 의존적인 것에 반해 swing의 
  경우 자체 컴포넌트를 사용하기 때문에 플랫폼 독립적이라고 본다고 한다. 이전에 책의 예제를 통해 간단히 접한 단계라 아직 부족한 
  부분이었는데 이번 기회에 이전의 나보다는 GUI에 한 발자국 성장한 모습이길 기대하면서 복습 겸 회고를 작성한다.
  
```java
    public class MainWindow extends JFrame implements Runnable{
        private BufferedImage background;
        private Neko neko;
        private Thread thread;
        private long frame  = 0; /* 프로그램 작동 프레임을 확인하기 위한 변수? */
        private Input input;

        public MainWindow() {
            initUI();
            initNeko();
            initOthers();
        }
    }
```
 우선적으로 MainWindow의 인스턴스를 생성 시, 세가지 함수를 불러오는 것을 확인할 수 있다.
 1. initUI : Frame에 대한 설정과 mouseaction에 관한 내용을 담고 있다.
 2. initNeko() : 고양이 이미지를 load하기 위한 내용을 담고 있다.
 3. initOthers() : Thread 생성.(thread = new Thread(this))
 
 ```java
     public class MainWindow extends JFrame implements Runnable{

        private void initUI() {
            setTitle(TITLE);
            addBackground();
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            input = new Input(this);
            addMouseListener(input);
            addMouseMotionListener(input);
            setLocationRelativeTo(null);
            setResizable(false);
        }
    }
```
- setDefaultCloseOperation(DISPOSE_ON_CLOSE): 오른쪽 상단 X표시 클릭 시, 종료되는 조건
    - DISPOSE_ON_CLOSE : 등록되어 있는 임의의 WindowListener 오브젝트를 호출한 후, 자동적으로 프레임을 숨겨 파기
- addMouseListener : input 값을 받아 작동하도록 setting하는 작업
- setLocationRelativeTo(null) : 윈도우를 매개변수 안의 컴포넌트에 따라 상대적인 위치를 지정할 수 있다.
    - argument가 null일 경우, 윈도우 중앙에 출력한다.
    - setDefualtCloseOperation()와 세트처럼 따라다니는 메서드
- setResizable(false) : 창크기를 조절하는 메서드

```java
    public class Neko {
        private Map<CatStatus, List<BufferedImage>> cats = new HashMap<>(); /* 이미지를 HashMap으로 부르기 위함 */
        private CatStatus catStatus; /* 고양이 상태를 나타내는 enum */
        private long lastFrame; /* 이전 고양이 상태의 정보값을 담기위한 변수 */
        private boolean noOp;    
    }
```
HashMap을 통해서 고양이의 상태를 key값으로 해당 동작을 저장하는 이미지를 List형태 입력한 형태다. K,V방식은 주로 인력관리 프로그램에서
사람들을 빠르게 확인할 수 있는 용도로 많이 봐왔다. 이미지 작업을 HashMap형태로 표현할 수 있다는 것이 신기하다.

```java
public enum CatStatus {
    STAND,
    SLEEP,
    SLEEPING,
    TOP,
    TOP_LEFT,
    TOP_RIGHT,
    LEFT,
    RIGHT,
    BOTTOM,
    BOTTOM_LEFT,
    BOTTOM_RIGHT,
    WAKE_UP
}
```
 그리고 Honux는 CatStatus를 enum형태로 정의했다. enum은 주로 정해진 명령에 대한 처리를 하기 위해서 주로 사용했었다. 
 enum은 '서로 관련된 상수를 편리하게 선언하기 위한 방법'이라고 한다.
```java
public class MainWindow extends JFrame implements Runnable{
    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this); /* 배경화면 그리기 */
        int x = getWidth() / 2; /* 프로그램 가로 중앙에 위치 */
        int y = getHeight() / 2; /* 프로그램의 세로 중앙에 위치 */
        int w = Neko.W;
        int h = Neko.H;

        g.drawImage(neko.getImage(frame), x, y, x + w * 2, y + h * 2, 0, 0, w, h, this);
         /* 고양이의 첫 위치를 중앙에 위치해서 생성하도록 paint하기 */
    }
}
```
 지난주 나의 최대의 난제는 Listenrer와 paint였다. 대체 저것은 어떻게 작동하는 것이지? 하는 의문이었다. 어딜 찾아봐도
 Graphics g를 argument로 사용하는 코드는 없었다. 어딜봐도 없었다. 그런데 이 인자는 코드 내부에서 받아서 사용하는 함수가
 아니라 매개인자를 전달해 주는 주체가 JVM 혹은 OS 였다. 그러니 어디서도 확인할 수 없었다.
  paint 함수와 같이 JVM과 OS에게 값을 전달받아 사용하는 함수가 callback함수이다. callback 함수는 비동기처리와도 연관이 많다고
  하는데 한번 추후에 공부해봐야 겠다.
 - paint : 그래픽 이벤트가 발생했을 때 호출하는 메서드
 - repaint : 강제로 한번 더 호출하고자 할 때 사용하는 메서드.
    - 자바 그래픽 메서드
        - [참고 reference](https://darkhorizon.tistory.com/37)
        - [paint 기초내용 블로그](https://javacrush.tistory.com/entry/java-%ED%8E%98%EC%9D%B8%ED%8A%B8-%EA%B8%B0%EC%B4%88)
    <br><br>
```
public class MainWindow extends JFrame implements Runnable{
        public static void main(String[] args) {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            mainWindow.start();
    
        }
}
```
main method를 통해 mainWindow 인스턴스가 생성되면서 앞서 이야기 한 값들 이 모두 초기화 된다.
그리고 mainWindow는 내부의 멤버변수로 thread 선언 및 사용하도록 작성했기 start를 사용해서 Thread를 작동시킨다.

```java
public class MainWindow extends JFrame implements Runnable {
    @Override
    public void run() {
        while (true) {
            frame++;
            try {
                Thread.sleep(GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            update();
            repaint();
            System.out.println(frame);
        }
    }
}
```
 start method를 호출하면 thread를 생성하고 내부 run 메서드를 호출해서 thread를 작동시킨다.
 내부 로직을 확인해보면 GAP이라는 시간만큼 정지 후 작동해서 고양이의 위치를 변경(update)하고
  repaint를 호출해 변경된 위치에 고양의 이미지 다시 그린다.
 <br> <br>
 
 # Day20. 알고리즘 데이!
 ## 목록(Contents)
 ###leet code
 - (1) two-sum ([문제](https://leetcode.com/problems/two-sum/) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/algorithm/Two_Sum.java))
 - (2) reverse-integer ([문제](https://leetcode.com/problems/reverse-integer/) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/algorithm/ReverseInteger.java))
 - (3) palindrome-number ([문제](https://leetcode.com/problems/palindrome-number/) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/algorithm/Palindrome.java))
 - (4) roman-to-integer ([문제](https://leetcode.com/problems/roman-to-integer/) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/algorithm/RomanNumberals.java))
 - (5) longest-common-prefix ([문제](https://leetcode.com/problems/longest-common-prefix/) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/algorithm/longest_common_prefix.java))
 - (6) merge-two-sorted-lists ([문제](https://leetcode.com/problems/merge-two-sorted-lists/) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission07/src/main/java/algorithm/two_sorted_lists.java))
