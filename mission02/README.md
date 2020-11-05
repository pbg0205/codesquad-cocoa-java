# Day3.미션2 배열, 클래스, 객체 익히기
>## 목록(Contents)
- (1) 2-1:인디언 이름 짓기
- (2) 2-2:초간단 RPG 구현하기
- (3) TO-DO-LIST
<br/><br/>

## 1.미션 정리(Summary) 

>### 2-1:인디언 이름 짓기
- 다음과 같은 형태의 프로그램을 구현한다.
- 참고자료는 '인디언 이름 짓기'를 검색을 해보자.

    ```
        생년월일을 입력해 주세요>
        1999 12 9
        당신의 이름은 용감한 황소의 노래입니다. 
    ```
   
<br/><br/>
***
- ### 2-2:초간단 RPG 구현하기
>####파일 경로

    ````
    mission02 ────── src ────┬────  main ────┬────   rpg   ────┬──── domain ──┬── Game.java
                             │                                 │              ├── GameMap.java
                             │                                 │              ├── Player.java     
                             │                                 │              └── Point.java     
                             │                                 ├──    util    ─── RandomNumberCreator.java
                             │                                 ├──  validator ───      InputValidator.java
                             │                                 └──    view    ┬──           InputView.java
                             │                                                └──          OutputView.java
                             │  
                             └───── test ────── java ───┬─── Validator ─────── ValidatorTest.java
                                                        ├───  utiltest ─────── RandomCreatorTest.java
                                                        └─── domainTest─────┬─ MapTest.java
                                                                            ├─ PlayerTest.java
                                                                            └─ PointTest.java
                                                       
  
    ````

<br/>

>### 기능 정리
- 11 * 11 배열 초기화
- 화면 중앙에는 캐릭터 위치
- 임의의 장소에 몬스터 위치
- 임의의 장소에 1개의 지뢰를 배치한다. 단 지뢰는 플레이어가 밟기 전까지 화면에 표시하지 않는다.
- 콘솔 입력으로 WASD 중 하나의 키를 입력받고 엔터를 누르면 캐릭터가 상좌하우로 이동함
- 캐릭터가 지뢰를 밟으면 사망
- 캐릭터가 몬스터의 위치까지 이동하면 몬스터가 사라지고 정해진 점수 획득
- 점수 획득시 새로운 몬스터와 지뢰를 배치한다. 단 지뢰의 갯수는 2배 증가시킨다.
- 매 턴마다 현재 배열의 상태를 화면에 출력. 단 밟지 않은 지뢰는 표시하지 않는다.
- 똑같이 구현하지 않아도 되니 재미있는 게임을 만들어 보자.

>### 구현 화면
####1.게임 화면
````

      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  💣  🔳  🔳  🔳  😈  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  😁  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
    
    나아갈 방향을 선택해주세요
    위(W), 아래(S), 왼쪽(A), 오른쪽(D)
    w
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  💣  🔳  🔳  🔳  😈  🔳
      🔳  🔳  🔳  🔳  🔳  😁  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳


````
<br>

####2.승리 화면

````

      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  💣  🔳  🔳  😁  😈 🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
    
    나아갈 방향을 선택해주세요
    위(W), 아래(S), 왼쪽(A), 오른쪽(D)
    d
    축하합니다. 몬스터 사냥에 성공하셨습니다.
    승리 🏁
````
<br>

####3.패배 화면

````

      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  💣  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  😁  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  😈  🔳  🔳  🔳  🔳  🔳
      🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳  🔳

나아갈 방향을 선택해주세요
위(W), 아래(S), 왼쪽(A), 오른쪽(D)
w
아쉽습니다. 지뢰를 밟았어요.
패배💣
````

<br/><br/>
*** 
###3.TO-DO-LIST
>- **객체로 동치 비교 방법 찾기**
>   - [equals & hashcode 재정의 코드(이펙티브 자바)](https://github.com/gmlwjd9405/effective-java-3e-source-code/tree/master/src/effectivejava/chapter3/item10)
>- 클래스 변수
>    - 모든 인스턴스가 <u>공통된 저장공간(변수)를 공유</u>하고 싶은 경우
>    - <u>인스턴스를 생성하지 않고도 언제라도 바로 사용</u>할 수 있다.
>- 멤버 변수 사용 이유
>    - (조교님 피드백) 멤버 변수로 입력받아 출력할 필요 없다 → 함수의 파라미터로 입력받아 메소드를 처리하자.
>    - 멤버 변수(member variable)
>        - 사용이유 : 인스턴스마다 <U>고유한 상태를 유지해야하는 속성</U>이 필요한 경우 사용
>        - 해당 변수의 <U>모든 메소드(멤버 함수)에 접근 가능</U>하다.

<br/><br/>

# Day4. 리뷰 및 수업
## 목록(Contents)
- [1] 수업 내용 정리(JVM & call by value/reference)
- [2] 초간단 RPG 구현하기 : equals 재정의
<br/><br/>

## 1. 수업 내용 정리
> ###What is JVM?(Java Virture Machine)
 기존의 프로그램(C,C++)을 실행하기 위해서는 운영체제(OS)의 의존적이기 떄문에 호환성이 떨어졌다.   
 하지만 <u>JAVA는 JVM(Java Virture Machine)사용해서 OS의 의존성을 해결했다.</u> 즉, 개발자가 하나의 코드만 만들면
 똑같은 운영체제에서 똑같이 실행할 수 있다. <u>호환성이 높은 장점</u>이 존재하지만 반대로 OS와 응용 프로그램 사이에 <u>JVM
 이 개입하기 때문에 속도가 떨어진다는 단점</u>을 가진다.   
<br>

> ###JVM의 메모리구조
- method area(메서드 영역)
    - .class(byte code)를 분석해서 클래스 데이터를 저장하는 공간
        - <u>클래스 변수(class variable)이 생성 및 저장</u>된다.   

- Heap(힙 영역)
        - 생성된 인스턴스를 저장하는 공간
        - <u>모두 사용한 객체는 GC(Garbage Collector)가 할당된 메모리를 반환한다.</u>
        
- call stack(호출 스택)
        - 메서드의 작업에 필요한 메모리 공간을 제공
        - 메서드 호출 시, 호출 스택에 호출된 메서드를 위한 메모리 할당
        - 메서드가 작업 수행하는 동안 <u>지역 변수(매개 변수), 참조 변수 연산 중간 결과</u>를 저장하고 있다.
        - <u>할당이 완료되면 메모리 공간은 반환</u>된다.   

            ```     
          <호출스택 특징>
            - 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
            - 메서드가 수행을 마치고나면 사용했던 메모리를 반환하고 스택에서 제거된다.
            - 호출스택의 제일 위에 있느느 메서드가 현재 실행 중인 메서드이다.
            - 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다
            ```
<br>

>###call by value/reference
 - call by value(값에 의한 호출)
    - 함수 안에서 매개변수 값을 바꿔도 바깥에 영양을 주지 않는다.
    - argument != parameter : <u>메서드의 argument을 값으로 복사 후 메서드 로직을 처리하기 떄문에 다른 값으
    로 인지하자!</u>
         ```
            public static void main(String[] args){
                int a = 10;
                System.out.println(add(a)); //결과:10
            }
            
            public void add(int a){
                a = a + 5;
            }                
         ```
    <br>
 - call by reference(참조에 의한 호출)
    - heap에 있는 객체의 주소번지를 저장해 필요 시, 주소를 통해 값을 호출하는 방식
    - 함수 안에서 매개변수 값을 바꾸면 바깥에도 안준다.
    - argument == parameter : argument가 주소 번지를 복사해서 paramter를 저장해서 필요할 때마다 변경하는 형태
         ```
            public static void main(String[] args){
                int[] arr = new int[5];    
                for(int element : arr){
                    System.out.print(arr)// 결과:00050
                }    
            }
            
            public static void add(int[] arr){
                arr[3] = 5;
            }
         ```
<br>

> ###kruth shuffle
- 모든 변수를 나열한 후, 요소들을 섞는 방법
    ```
       Random r = new Random();
       for(int i = length - 1; i > 0; i--){
            swap(arr, i, r.nextInt();
        }
  
        swap(arr, prev, next){
            int temp= = arr[prev];
            arr[prev] = arr[next];
            arr[next] = temp;
        }
    ``` 
  <br>
  
## Refactoring(초간단 RPG 구현하기) : equals 재정의
- ###변경 내용
    - #### 승리 조건equals 재정의
        해당 코드를 보면 player의 정보를 외부로 호출을 하는 코드는 의존성을 상승시키는 코드이므로
        해당 코드를 equals를 통해서 리팩토링을 해야겠다고 생각했다.
    
        ```
            private boolean sameWithMonster() {
                return (player.getX() == monster.getX()) && (player.getY() == monster.getY());
            }                
        ```
    <br/>
    
    - #### equals를 재정의하는 이유
        <u>논리적 동치성</u>을 구현하기 위함이다. 컴퓨터가 기본적으로 객체를 비교하는 경우, <u>두 객체 간 참조 
        값을 통해 값을 비교</u>하기 때문에 모든 값은 독립적으로 취급한다.(두 개의 같은 종류 빼빼로가 있지만 두 개는 다른 빼빼로)
        그러므로 equals를 재정의 하면 <u>두 값을 동일한 값으로 취급</u>하는 방법이다.
    <br>
     
    - #### Point 객체를 재정의 하자
        ```
               @Override
               public boolean equals(Object o) {
                   if (!(o instanceof Point)){
                       return false;
                   }
           
                   Point p = (Point)o;
           
                   return p.x == x && p.y == y;
               } 
        ```
      해당 코드를 확인해보자.   
      o instanceof Point는 o가 Point는 Point class에 소속되는 클래스 여부를 확인하는 코드이다. 즉, Point 
      class의 자식인지를 확인하는 메소드이다. 클래스에 소속되지 않으면 같은 값이 아니라는 것을 위한 코드이다.   
       아래 부분이 논리적 동치성(두 개가 같다는 기준)에 해당하는 코드이다. 입력받은 객체를 비교하기 위해 down
      casting 후 두 좌표가 같을 경우 두 값을 동일하다고 취급하는 경우이다.
       ```
                @Override
                public boolean equals(Object o) {
                    if (!(o instanceof PlayerPoint))
                        return false;
            
                    return super.equals(o);
                }
      
       ```
       또한 Player의 instance가 아닌 클래스를 예외 처리하는 결과를 반환하고 자식 클래스인 PlayerPoint
       @equals를 재정의 하여 부모의 재정의한 equals를 사용하겠다고 명시해주자!
       이렇게 코드를 작성시 반사성을 위반하는 것을 방지할 수 있다.
       - 반사성 : x.equals(y) = true이고 y.equals(x) 모두 true임을 반환하는 방법
       <br>
       
       
       
       