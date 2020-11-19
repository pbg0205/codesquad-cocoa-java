# Day13.미션 6 한글 시계, 캘린더 만들기
## 목록(Contents)
- (1) 구현 영상
    - 쉘 만들기
        - history
        - concat

- (2) 구현 로직
    - history
    - concat
    - hclock
    - cal
<br/><br/>

> ## 1.**구현**
(1) history
```shell script
D:\codes\codesquad_cocoa_java\mission01\src\main> history
1 history
2 cd main
3 ls
4 cd src
5 ls
6 cd mission01
7 ls
```
(2) cat
```shell script
(1) 기본 명령
--------------------------------------------------------------------------------------------
D:\codes\codesquad_cocoa_java\mission01\src\main\java\algorithm\baekjoon11720> cat Main.java
package algorithm.baekjoon11720;

import java.util.Scanner;
....
--------------------------------------------------------------------------------------------


(2) option -h 추가시
--------------------------------------------------------------------------------------------
D:\codes\codesquad_cocoa_java\mission01\src\main\java\algorithm\baekjoon11720> cat Main.java -n
1 package algorithm.baekjoon11720;
2 
3 import java.util.Scanner;
4 
5 ....
--------------------------------------------------------------------------------------------


(3) 디렉토리에 cat 처리시
--------------------------------------------------------------------------------------------
D:\codes\codesquad_cocoa_java\mission01\src\main\java> cat algorithm
algorithm is Directory
--------------------------------------------------------------------------------------------


(4) 잘못된 경로 입력 시
--------------------------------------------------------------------------------------------
1. 한 개 처리 시
D:\codes\codesquad_cocoa_java> cat mission1
Invalid Path

2. 두 개 처리 시
D:\codes\codesquad_cocoa_java> cat mission1 mission2
Invalid Path
Invalid Path
--------------------------------------------------------------------------------------------
```

- 한글 시계 구현 영상
```
[명령어:hclock 처리 시]

한 두 세 네 다 섯 
여 섯 일 곱 여 덟 
아 홉 열 한 두 시 
자 이 삼 사 오 십 
정 일 이 삼 사 육 
오 오 칠 팔 구 분 

//실제 색상은 변경됩니다.
//깃허브 마크다운에 색상 변경이 안되는 점 양해바랍니다.
```
- 캘린더 구현 영상
```
[명령어 : cal 처리 시]

    ===========================
          2020년    11월         
    ===========================
    SUN MON TUE WED THR FRI SAT
                          1   2 
      3   4   5   6   7   8   9 
     10  11  12  13  14  15  16 
     17  18  19  20  21  22  23 
     24  25  26  27  28  29  30

//실제 해당 날짜 색상은 변경됩니다.
//깃허브 마크다운에 색상 변경이 안되는 점 양해바랍니다.
```

> ## 2. 구현 로직

> ### (1) historyCommand
#### 1. history에 대한 정보를 입력받아 저장한다.
>**변수 선언 : historyStack**
```java
    private Stack<String> historyStack;
```
history에 대한 정보를 기록하기 위해서는 그에 맞는 저장공간이 필요합니다. 기존 shell의 history기능은
최근 출력한 내용을 가장 먼저 출력하는 방식으로 진행합니다. 그렇다는 것은 <u>LIFO(Last In First Out)</u>의 
형태의 자료 구조를 사용하면 좀 더 효율적으로 자료를 출력할 수 있습니다.   
 이에 맞는 자료구조로는 Stack이 존재합니다. Stack은 원하는 자료 출력 형태인 LIFO구조를 띄고 있어 가장 최근에
 추가한 정보를 먼저 꺼내볼 수 있어 해당 히스토리를 불러오는 방법에 적합합니다.   
<br>
>**변수 선언 : option**
```java
    private String option;
```
history의 경우, -c 옵션을 사용하면 사용했던 커맨드가 모두 소멸하는 기능이 있습니다. 그래서 이를 확인하기 위해서 option의
존재유무를 확인하기 위한 option 변수를 별도로 설정해서 추후 option에 해당하는 로직을 처리하기 위해 변수를 가지고 있도록 구현했습니다.
<br><br>

>메서드 선언 : pushHistory
 ```java
    public void pushHistory(String command) {
        if (command.equals("history -c")) {
            command = "history";
        }

        historyStack.push(command);
    }
```
 이제 선언한 내용을 토대로 결과를 추가할 수 있는 method를 선언해야 합니다. 저는 pushHistory라는 메소드를
 선언했습니다. 로직을 다음과  같습니다.
 1. 만약 history -c(history 제거) 메서드가 존재하게 될 경우, 마지막 사용한 커멘드인 history를 추가한다.
 2. 아닌 경우, historyStack에 사용한 커맨드를 추가한다.
<br><br>
>**메서드 선언 : excuteCommand(String commandLine)**
```java
    public void excuteCommand(String commandLine) {
        Stack stack_tmp = this.historyStack;
        int index = 1;

        checkOption(commandLine);

        if (this.option.equals("-c")) {
            removeAllhistory();
        }

        while (!stack_tmp.isEmpty()) {
            System.out.printf("%d %s\n", index++, stack_tmp.pop());
        }
    }
```
위 코드는 history가 실행되는 메소드입니다.   
1. 매개인자로 commandLine을 입력받는다.
2. 해당 커맨드에 옵션이 있는지를 확인한다(checkOption)
3. 만약 option이 존재하고 있다면 히스토리 내역을 삭제한다.(removeAllHistory)
4. 해당 history를 출력한다.

> 메서드 선언 : checkOption(String commandLine)
```java
    private void checkOption(String commandLine) {
        String[] commands = commandLine.split(" ");
        String option_tmp;

        if (commands.length == 1) {
            this.option = "";
            return;
        }

        option_tmp = commands[1];

        if (option_tmp.startsWith("-c")) {
            option = option_tmp;
        } else {
            this.option = "";
        }
    }
```
 기존에 Application에서 command를 탐색해서 해당 로직으로 이동했습니다. 이 메서드는 말그래도 해당 커맨드에
입력된 명령어에 대한 내용에 옵션(-c)에 대한 내용을 확인하는 메서드 입니다. 기존에 history라는 내용을 기반으로
탐색해서 들어왔기 때문에 가장 앞에 있는 command는 무조건 history일 수 밖에 없겠지요. 그렇기 때문에 저희는 두번째
인덱스를 탐색합니다.   
<br><br>
> removeAllHistory(String command)
```java
    private void removeAllhistory() {
        historyStack = new Stack<>();
    }
```
해당 메서드는 옵션(-c)가 존재할 때 처리하는 메서드입니다. 생각보다 삭제 메서드는 간단합니다. 기존에 저장되어 있던
historyStack을 빈 Stack으로 초기화하면 됩니다. 이렇게 빈 Stack으로 대체하게 되면 자연스럽게 내부에 존재하던 정보들은
모두 삭제되는 기능이 구현됩니다.

> ### (2) catCommand
catCommand의 경우는 불러오는 경로의 위치가 파일의 정보를 출력해주는 기능을 합니다. 해당 커맨드의 옵션에는 '-n'이 존재하는데, 
해당 옵션이 주어지면 출력하는 화면 왼쪽에 행을 표시합니다.

> **seperateCommands(String commandLine, Path path)**
```java
    private void seperateCommands(String commandLine, Path path) {
        String[] commands = commandLine.split(" ");
        int commandLen = commands.length;

        if (commandLen == 1) {
            return;
        }

        for (int index = 1; index < commandLen; index++) {
            String command = commands[index];
            checkOption(command);
            initPath(path, command);
        }
    }
```
 
해당 메서드의 경우 Application.java로 부터 전달받은 commmandLine을 전처리하여 멤버변수를 초기화하는 과정입니다.   
(1) 우선 command의 길이가 1이면 cat이후에 명령어가 존재하지 않기 때문에 해당 로직을 종료한다.
(**void checkOption(String command)**)
(2) 만약 command의 길이가 2이상일 경우, command를 순회하여 옵션과 경로를 순회하며 초기화합니다.
(**void initPath(Path path, String command)**)
> void checkOption(String command)
```java
    private static final String CAT_OPTION = "-n";

    private void checkOption(String command) {
        if (command.equals(CAT_OPTION)) {
            this.option = command;
        }
    }
```
> void initPath(Path path, String command)
```java
    private void initPath(Path path, String command) {
        String path_tmp = path.toString() + "\\" + command;
        insertPath(path_tmp);
    }

    private void insertPath(String pathAsString) {
        if (this.pathPrevAsString == null) {
            this.pathPrevAsString = pathAsString;
            return;
        }

        if (this.pathNextAsString == null) {
            this.pathNextAsString = pathAsString;
        }
    }
```

>**execute()**
```java
    public void execute() {
        if (!(hasPath(this.pathPrevAsString) ||
                hasPath(this.pathNextAsString))) {
            return;
        }

        if (hasOption()) {
            concatenateWithOption();
            return;
        }

        try {
            concatenate(this.pathPrevAsString);
            concatenate(this.pathNextAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```
위 메서드는 실질적으로 명령을 처리하는 메서드입니다.   
(1) 경로가 존재하는지 확인한다.   
(2) 옵션이 존재할 경우, 옵션이 포함된 명령을 처리한다.   
(3) 옵션이 존재하지 않을 경우, 옵션이 포함되지 않은 로직을 처리합니다.   
<br><br>

> concatenateWithNoption(String pathAsString)
```java
    private void concatenateWithNoption(String pathAsString) throws IOException {
        if (!hasPath(pathAsString)) {
            return;
        }

        if (checkDirectory(pathAsString)) {
            return;
        }

        try {
            connectionFile(pathAsString);
            printLineWithRowNum();
        } catch (NullPointerException | FileNotFoundException e) {
            pathValidationMessage();
        }
    }
```
해당 로직은 옵션(-n)이 포함되었을 때 처리하는 메서드 입니다. 위의 두 조건(path 존재X, 디렉토리)에 대한 
예외처리를 진행한 후,  행과 포함된 로직을 로직을 처리하게 됩니다. 해당 로직을 처리하는 과정에서 path가 존재
하지 않을 경우, FileNotFoundException과 BufferedReader가 NullPointException이 발생할 수 있기 때문에 예외를 처리하는
try/catch문을 작성하였습니다.   
(또한 해당 로직은 option이 존재하지 않는 경우의 메서드인 **concatenate** 와 동일합니다)

> **hclock, cal은 추후 업로드할 예정입니다.**


## Java IO

---

>### What is IO ?

- Input (data) : program이 동작하는데 프로그램 상으로 들어오는 모든 데이터
- Output (data) : program 밖으로 나가는 모든 데이터(ex. 파일, 네트워크, 콘솔)
<br><br>
>### What is Stream?

![스트림]([https://www.slipp.net/wiki/download/attachments/12189761/stream.bmp?version=1&modificationDate=1368461094000&api=v2](https://www.slipp.net/wiki/download/attachments/12189761/stream.bmp?version=1&modificationDate=1368461094000&api=v2))

- #### steam(스트림) : 데이터를 운반하는데 사용되는 연결통로
    - 스트림은 단방향으로만 통신이 가능하다.

        (입출력 필요 시, InputStream과 OutputStream 필요)

    - 스트림은 먼저 보낸 데이터를 건너뜀 없이 연속적으로 데이터를 주고 받는다.(FIFO 구조)

(사진 출처 : slipp.net)

- #### Seconday Stream(보조 스트림) : 스트림의 기능을 보완하는 역할
    - 실제로 데이터를 입출력하는 기능은 없다.
    - 하지만, 스트림의 기능을 향상 시키거나 새로운 기능을 추가
    - 보조스트림만으로는 입출력을 처리할 수 없고, 스트림을 먼저 생성한 다음에 이를 이용해서 보조스트림을 생성해야 한다.

    (예시)

    ```java
    FileInputStream fis= new FileInputStream("test.txt");
    BufferedInputStream bis = new BufferedInputStream(fis);//스트림에 보조스트림 만듦.
    bis.read();//보조스트림이 데이터를 읽는다.
    ```

    - FileInputSteram fis: 실제 입력 기능 수행
    - BufferedInputStream bis : 보조스트림 역할로 버퍼만 제공
    - 버퍼를 사용여부에 따라 입출력 성능차이가 크기 때문에 주로 버퍼를 이용한 보조스트림을 사용하는 경우가 많다.

> ### **데이터 전송 형태에 따른 스트림 분류**

- 데이터는 크게 두가지 방식으로 데이터를 전달한다.
    1. 바이트기반 스트림
    2. 문자기반 스트림
<br><br>
#### **1. 바이트기반 스트림**

- 바이트(<u>1byte</u>)로 데이터를 입출력하는 방식의 스트림.
- byte단위의 입출력 클래스는 InputStream, OutputStream과 같은 추상 클래스를 상속받아 만들어진다.
- (+ ex. InputStream을 상속받은 경우 반드시 read()를 구현해야하는 핵심 메서드)
- <u>InputStream(OutputStream) 과 같이 추상클래스로 정의</u>되어 있고, <u>read(write)를 구현</u>해야한다.

    (추상 클래스를 사용한 이유 : <u>입출력의 대상에 따라 읽고 쓰는 방식이 다를 것</u>이기 때문에)

- ex) 글자 끝에 InputStream, OutputStream이 붙어있음.
<br><br>

#### **2. 문자기반 스트림**

- Java에서는 char형이 <u>2byte</u>이기 때문에 바이트기반의 스트림으로 문자를 처리하는데 어려움이 있음
- 이를 보완하기 위해서 문자데이터를 입출력할 때는 문자 기반 스트림을 사용한다.
- Reader(Writer) 또한 <u>추상 클래스로 정의</u>되어 있고, <u>입출력을 받기 위해서는 read(write)을 구현</u>해야 한다.

    (추상 클래스를 사용한 이유 : <u>입출력의 대상에 따라 읽고 쓰는 방식이 다를 것</u>이기 때문에)

- ex) 글자 끝에 Reader, Writer가 붙어있음.