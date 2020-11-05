## Day1.미션
### 목록(Contents)
- (1) 파일 경로
- (2) 구구단 출력
- (3) 알고리즘 문제

### 미션 정리(Summary)  
- 파일 경로
    ````
    mission01 ────── src ────┬────  main ────┬──── gugudan ────┬──── domain ─┬── Gugudan.java
                             │               │                 │             └── Manual.java
                             │               │                 └── validator ─── Validator.java
                             │               └─── algorithm ───┬─── baekjoon1330
                             │                                 ├─── baekjoon2438
                             │                                 ├─── baekjoon2443
                             │                                 ├─── baekjoon2753
                             │                                 ├─── baekjoon2884
                             │                                 ├─── baekjoon9498
                             │                                 ├─── baekjoon11720
                             │                                 └─── baekjoon14681
                             │  
                             └───── test ─────── java ─────── Validator ─────── ValidatorTest.java
    ````
***
- ### 1.GitHub 저장소 만들기
    - 과정 중 [사용할 본인의 저장소](https://github.com/pbg0205/codesquad-cocoa-java)를 만든다.
    - 저장소의 README.md 파일을 적당히 편집하고 푸시한다.
    - 저장소 리스트 를 업데이트한다.
    - 작성한 코드는 깃헙에 저장하고 커밋 / 푸시한다.
    - 주의사항: 불필요한 파일들은 커밋에 포함하지 않는다.
***    
- ### 2.구구단
    - 입력: 시작단과 끝단을 입력받는다.
    - 출력 : 시작단부터 끝단까지 예쁘게 출력한다.
    - 출력 화면
    ```
    [구구단 규칙]
    
                      구구단 만들기                    
      =====================================================
                            <<규칙>>                      
      1. 두 숫자는 띄어쓰기 기준으로 입력합니다.(ex. 3 7 -> O)
      2. 두 숫자는 2이상 9이하의 숫자를 입력합니다.(ex. 13 16 -> X)
      3. 첫번 째수가 두 번째 수보다 작게 입력합니다.(ex. 7 3 -> X)
      =====================================================

    ````

    ````
    [구구단 입력]
        =====================================================
        원하는 두 숫자를 입력해주세요.
        =====================================================        
        3 4
    ````
  
    ````
  [구구단 출력]
  
  ________3단________
  3 × 1 = 3
  3 × 2 = 6
  3 × 3 = 9
  3 × 4 = 12
  3 × 5 = 15
  3 × 6 = 18
  3 × 7 = 21
  3 × 8 = 24
  3 × 9 = 27
  ________4단________
  4 × 1 = 4
  4 × 2 = 8
  4 × 3 = 12
  4 × 4 = 16
  4 × 5 = 20
  4 × 6 = 24
  4 × 7 = 28
  4 × 8 = 32
  4 × 9 = 36
  =====================================================
  출력이 완료되었습니다!
  프로그램을 종료합니다.
  =====================================================
    ````
  
    ````
    [예외 처리]
    1. 하나 입력 경우 ─────────────────────────────────────────────────────────────
  
    원하는 두 숫자를 입력해주세요.
    3
    값를 0개 혹은 1개 입력하셨습니다. 다시 입력해주세요.
  ───────────────────────────────────────────────────────────────────────────────
  
  
  
    2. 숫자가 아닌 경우─────────────────────────────────────────────────────────────
  
  원하는 두 숫자를 입력해주세요.
  ㅏ 2
  첫번째 값이 숫자가 아닙니다. 다시 입력해주세요
  ───────────────────────────────────────────────────────────────────────────────  
  
  
  
    3. 첫번째 숫자 > 두번 째 숫자────────────────────────────────────────────────────
  
  원하는 두 숫자를 입력해주세요.
  4 3
  첫번째 수가 두 번째 수보다 큽니다.(첫번째 수 > 두번 째 수), 다시 입력해주세요
  ───────────────────────────────────────────────────────────────────────────────  
    ````
   
   
 ***  
### 3.알고리즘 문제
- 조건문 연습
    - [if문 단계(baekjoon)](https://www.acmicpc.net/step/4)
        - ([문제](https://www.acmicpc.net/problem/1330) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon1330/Main.java))두 수 비교하기(1330)
        - ([문제](https://www.acmicpc.net/problem/9498) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon9488/Main.java))시험 성적(9488)
        - ([문제](https://www.acmicpc.net/problem/2753) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/tree/master/mission01/src/main/java/algorithm/baekjoon2753))윤년(2743)
        - ([문제](https://www.acmicpc.net/problem/14681) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon14681/Main.java))사분면 고르기(14681)
        - ([문제](https://www.acmicpc.net/problem/2884) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon2884/Main.java))알람 시계(2884)
- 반복문 연습
    - ([문제](https://www.acmicpc.net/problem/2438) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon2438/Main.java))별 찍기 - 1(2438)
    - ([문제](https://www.acmicpc.net/problem/11720) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon11720/Main.java))숫자의 합(11720)

- 별찍기
    - [별찍기(baekjoon)](https://www.acmicpc.net/workbook/view/20)
        - ([문제](https://www.acmicpc.net/problem/2442) / [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission01/src/main/java/algorithm/baekjoon2442/Main.java))별 찍기 - 5(2442)
        
        
## Day2
### 1. 함수와 메소드 차이
> 함수(function)과 메소드(method)   
> - 공통 특징
>      - 매개 변수를 입력받아 결과값을 반환 한다.(void형 제외)   
> - 차이점
>   - 메서드(method) : 특정 class에 반드시 속해야 한다는 제약이 있다.   
>   - 함수(function) : 람다식을 통해 메서드가 하나의 독립적인 기능을 하는 역할
>
### 2. 파일 읽기의 기초
1.Scanner()
``` 
    Scanner scanner = new Scanner(System.in);
    
    int intValue = scanner.nextInt();           // 정수형 값을 입력받고 싶은 경우 사용
    double doubleValue = scanner.nextFloat();   // 실수형 값을 입력받고 싶은 경우 사용
    String strValue = scanner.nextLine();       //문자형 값을 입력받고 싶은 경우
    
    scanner.close();                            //입력 스트림을 닫는 메소드
```
- java.util class중 입력을 받을 때 사용하는 클래스
- 정수, 실수, 문자열을 읽어올 수 있다.

2.BufferedReader()
```
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in);
    String strValue = br.readLine();           //줄 단위로 문자 형태로 입력을 받겠다는 의미    
    int intValue = br.read();                  //char단위로 한 문자씩 입력받는다.
    
    //만약 줄단위로 숫자를 입력을 받고 싶다면?
    int intValue = Integer.parseInt(br.readLine());
    /*
     * - 의미
     * 1. br.readLine() : 줄단위로 입력을 받아
     * 2. Integer.parseInt() : 문자형 값을 정수 형태로 변경하겠다.
     */
    br.close();
```
- java.io class에 위치
- buffered을 사용하여 입출력이 빠르다.(대략 Scanner의 6배)
 
 