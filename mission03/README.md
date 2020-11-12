# Day6.미션 3 가계부 구현하기
## 목록(Contents)
- (1) 3.가계부 구현하기
- (2) TO-DO-LIST
<br/><br/>


## 1.미션 정리(Summary) 

>### 3:가계부 구현하기
- 다음과 같은 형태의 프로그램을 구현한다.
- 간단한 가계부를 구현한다.
- 키보드를 통해 데이터 입력을 받고 화면에 내용을 출력한다.
- 사용자 등록: 사용자 이름 및 비밀번호를 입력받는다.
- 데이터 입력: 날짜, 적요, 수입, 지출을 입력받는다.
- 데이터 삭제: 특정 순번의 데이터를 삭제한다.
- 데이터 수정: 특정 순번의 데이터를 수정할 수 있다.
- 화면에 출력: 해당 월의 지출내역을 순번, 적요, 수입, 지출, 잔액으로 화면에 출력한다.

>### 구현 화면
#### 1.첫 화면
````
    ========== 소중한 내 돈 관리 가계부 ========
    1. 로그인
    2. 회원가입
    0. 종료
    실행할 명령어를 선택해주세요.
````
<br>

#### 2.회원 가입 화면 
````
    아이디와 비밀번호를 입력해주세요.
    (※비밀번호는 반드시 특수문자가 하나 이상 포함 되야 합니다.)
    ID : code-squad
    PW : code123!
    회원가입에 성공하셨습니다.
````

#### 3. 로그인 화면
````
    ==========로그인 페이지==========
    아이디와 비밀번호를 입력해주세요.
    ID : code-squad
    PW : code123!
    code-squad님 환영합니다    
````    
    
#### 4. 목록 추가
````
    날짜를 입력해주세요
    (※구분자는 .,- 중에 하나를 입력해주세요.)
    2020-11-09
    
    내역을 입력해주세요.
    바밤바
    
    금액을 입력해주세요.
    (지출은 마이너스(-)로 입력해주세요.
    -3000
````
#### 5. 목록 조회
````
======== 목록 ========
        날짜                   적요         금액
0 : 2020-12-09               바밤바       -3000
````
#### 6. 목록 수정
````
    수정할 인덱스를 입력해주세요.
    0
    
    날짜를 입력해주세요
    (※구분자는 .,- 중에 하나를 입력해주세요.)
    2020-11-10
    
    내역을 입력해주세요.
    죠스바
    
    금액을 입력해주세요.
    (지출은 마이너스(-)로 입력해주세요.
    -2000

    ======== 목록 ========
            날짜                   적요         금액
    0 : 2020-12-10               죠스바       -2000
````
#### 7. 목록 삭제
````
    삭제할 인덱스를 입력해주세요.
    0

    <조회 시 화면>
    조회할 목록이 존재하지 않습니다.
````

### 8. 로그 아웃 및 다른 id 로그인
````
    실행할 명령어를 선택해주세요.
    1. 조회
    2. 추가
    3. 수정
    4. 삭제
    5.로그아웃
    0. 종료
    5

    ========== 소중한 내 돈 관리 가계부 ========
    1. 로그인
    2. 회원가입
    0. 종료
    실행할 명령어를 선택해주세요.
    1

    ==========로그인 페이지==========
    아이디와 비밀번호를 입력해주세요.
    ID : code
    PW : code!
    code님 환영합니다
````
*** 
### 3.TO-DO-LIST
- [ ] 로그 아웃 메세지 내용 처리   
- [ ] 잘못된 입력 후, 종료 에러 개선하기   
- [ ] 수정 및 추가 입력 시, 유효성 검사 하기   
- [ ] 조회 콘솔 출력 내용 꾸미기
- [ ] 총합 연산 로직 구현하기


# Day7. 수업 정리 및 가계부 리팩토링
>## 목록(Contents)
- (1) 복습
- (2) 재귀함수
- (3) 객체지향 프로그래밍
- (4) 클래스
<br/><br/>

## 1.복습(Summary & QnA)
> ### Call by Value & Call by Reference 차이
- Call by Value : <u>매개 변수를 복사</u>해서 사용하는 방식
- Call by Reference : <u>매개 변수의 주소를 참조</u>해서 사용하는 방식
<br><br>

> ### [Q] Call by Reference가 Call by Value 보다 강점인 부분?

#### 1. 함수 내 매개 변수의 변경이 가능하다.
- 주소 값을 복사해서 사용하기 때문에 값 변경 시, Heap영역에 있는 객체 주소를 찾아가 값을 변경한다.

#### 2. 메모리 절약의 효과가 있다.
- 만약 call  by value 방식을 사용한다면 값 전체를 복사 방식으로 인해 </u>메모리 비효율성을 초래</u>할 수 있다.   
 만약 <u>객체의 값 혹은 변수 값이 클 경우</u>, 복사한 변수 혹은 객체만큼 메모리를 별도로 할당해야 한다.
<br><br>

> ### [Q] 함수의 리턴(return)을 사용하는 이유?
- <u>결과 값을 반환하여 다른 객체들과 메세지(message)를 주고 받을 수 있다</u>.
- <u>함수를 탈출하는 역할</u>을 한다.
<br><br>

## 2. 수업 내용 정리(Summary)
>### 재귀함수(Recursive Function)

>#### 재귀함수를 사용하는 이유?
1.장점
- 코드의 직관성에 유리하다.
- 주변 개발자의 두뇌가 좋아진다.(어떻게 로직이 구성되는지 확인한다.)

2.단점
- 메모리를 많이 할당한다.
- 연속적으로 결과 값을 반환하기 전까지 메서드를 연속해서 호출하므로 그에 해당하는 메모리를   
할당하게 되어 비효율성을 초래한다.

>#### 재귀 알고리즘 문제
- 피보나치 수열2(2748) ([문제](https://www.acmicpc.net/problem/2748) /  [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission03/src/main/java/algorithm/baekjoon2748/Main.java))
- 하노이 타워(11729) ([문제](https://www.acmicpc.net/problem/11729) /  [풀이](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/mission03/src/main/java/algorithm/baekjoon11729/Main.java))
<br><br>

>### 객체지향 프로그래밍
- 정의 : 객체 간의 메세지를 주고 받는 방식으로 프로그램을 구현하는 방식
- Simula : 최초의 객체 지향 언어로, 기존 모의 실험을 진행하기 위해서 사용
- 장점
    - 거대하고 복잡한 프로그래밍 작성이 가능하다.
    - 유지 보수가 절차 지향에 비해 쉽다.
    
>### 클래스
- 정의 : 상태와 행동을 가지는 어떤 것
    - 상태 : 멤버 변수(member variable)
    - 행동 : 메소드(method)
- 사용자 정의 데이터 타입으로 선언이 가능하다.
- 클래스 != 객체 : <u>객체는 클래스의 인스턴스화</u>한 대상을 일컫는 말이다.
<br><br>

# Day8. 미션 3 가계부 기능 추가
## 목록(Contents)
- (1) 총 합계 구현
- (2) 소비 유형 추가(현금/카드)
- (3) 날짜에 따른 오름차순 정렬
    - Comparator
    - Comparable
- (4) 검색 기능 구현(날짜, 적요, 금액, 소비 유형)
<br/><br/>

>### (1) 총 합계 구현

RecordList.java

    
        private int getSumOfRecords() {
            return recordList.stream().mapToInt(Record::getMoney).sum();
        }
ArrayList형태로 입력된 값을 stream을 사용해서 합산을 구하는 방식으로 구현했다.

> What is Stream?

 스트림이란 '데이터의 흐름'입니다. <u>배열 또는 컬렉션 인스턴스의 함수의 조합들을 이용해 가공된 결과</u>를 받을 수 있습니다.
 또한 <u>람다를 이용해서 코드이 길이가 줄고</u> 배열과 <u>컬렉션을 함수형으로 처리</u>할 수 있습니다.   
 스트림은 세가지 작업으로 나눌 수 있습니다.
 1. 생성하기: 스트림 인스턴스 생성
 2. 가공하기: 필터링 및 맵핑등 원하는 결과를 만들기 위한 중간 작업
 3. 결과 만들기 : 최종적으로 결과를 만들어내는 작업
 ````
    전체 -> 맵핑 -> 필터링 1 -> 필터링 2 -> 결과 만들기 -> 결과물
 ````   
<br>

[stream 참고 블로그]   
- [Java 스트림 Stream (1) 총정리](https://futurecreator.github.io/2018/08/26/java-8-streams/)   
- [Java 스트림 Stream (2) 고급](https://futurecreator.github.io/2018/08/26/java-8-streams-advanced/)
<br/><br/>

>### (2) 소비 유형 추가(현금/카드)
 Record.java

        private String payType;

소비 유형을 구현하기 위해 Record class의 인스턴수 변수로 선언했다. boolean isCash로 구현할지 고민 했다. 하지만 <u>코드 구현시
 의미가 불명확해질 것 같다는 생각이 들었다.</u> 그래서 의미를 좀더 구체적으로 하고자 <u>String payType 으로 선언</u>해 결제 
 방식을 구체적으로 의미를 받아들일 수 있도록 구현했다. 현재는 현금과 카드만 입력받는 경우에만 입력이 되도록 로직을 구현했지만
  다른 결제 방식을 통한 결과 값 저장받을 수 있을 것이다.
<br/><br/>
> ###(3) 날짜에 따른 오름차 순 정렬

Record.java

    private Calendar calendar;
 
 기존 날짜 타입을 Calendar class로 입력받았다. 하지만 입력 날짜를 입력 받기 위해서는 SimpleDateFormat를 이용해야 하는 
 번거로움이 존재했고 Comparable을 이용해 값을 비교하는데 어려움이 있었다. 그래서 UseDate 클래스를 만들어 날짜를 직접 구현하기
 로 했다.
 
 Record.java
 
        private UseDate useDate;

UseDate.java

        private int year;
        private int month;
        private int date;
        
위와 같이 연, 월, 일을 관리를 별도로 관리하도록 구현했다. 위와 같이 구현한 이유는 연, 월, 일 기준으로 비교를 하기 위함이다.
아래와 같이 함수형 프로그래밍을 이용해 Comparator 불변 필드를 선언했다.

    private static final Comparator<UseDate> USE_DATE_COMPARATOR =
            Comparator.comparingInt((UseDate ud) -> ud.year)
            .thenComparing(ud -> ud.month)
            .thenComparing(ud -> ud.date);
            
 Comparator는 기본 정렬과 다르게 정렬 기준을 세우고 싶은 경우 사용하는 인터페이스이다. Comparator는 유일하게 compare 함수를
 사용할 수 있다.   
 <br><br>

>### compare 작성법    
````
    (1) 비교법
    첫 번째 파라미터(x) > 두 번째 파라미터(y) : (+) 리턴 
    첫 번째 파라미터(x) = 두 번째 파라미터(y) : (0) 리턴
    첫 번째 파라미터(x) < 두 번째 파라미터(y) : (-) 리턴
````

[예시]
````
    @Override
    public int compare(Point p1, Point p2){
        if(p1.x > p2.x){
            return 1; //x 오름차순 정렬
        }

        if(p1.x == p2.x){
            if(p1.y > p2.y){
                return -1; // y 내림차순 정렬
            }
        }

        return -1;
    }
````

위와 같은 방법을 이용하면 나만의 기준을 정렬로 한 코드를 구현할 수 있다.   
계속해서 검색을 하다보니 함수형 프로그래밍을 이용한 Comparator를 사용하는 법을 알아냈다.
````
class UseDate implements Comparable<UseDate>{
    private static final Comparator<UseDate> USE_DATE_COMPARATOR =
            Comparator.comparingInt((UseDate ud) -> ud.year)
            .thenComparing(ud -> ud.month)
            .thenComparing(ud -> ud.date);
...
    
    @Override
    public int compareTo(UseDate other) {
        return USE_DATE_COMPARATOR.compare(this, other);
    }
}
````       
가장 윗 부분을 확인해보자. comparingInt는 정수값을 비교하겠다는 의미이다. 오른 쪽의 (UseDate ud)는 UseDate의 타입인 ud 변수로
하여 <u>우선 연도(year)를 비교해서 오름차순으로 정렬</u>하고 <u>월(month), 일(date)을 기준으로 비교하겠다는 의미</u>이다.
 이 코드를 보며 느낀 것은 함수형 프로그래밍으로 코드를 구현할 경우 의미를 파악하기 수월하다는 것이었다. 
정렬 기준은 Comparable을 implement받아 compareTo를 구현하고 내부를 Comparator.compare을 통해 정렬 기준을 확립했다.
 
```` 
class Record implements Comparable<Record> {
...
    @Override
    public int compareTo(Record other) {
        return (this.useDate).compareTo(other.useDate);
    }
}
````

또한 날짜 기준으로 Record를 정렬해야 하므로 Record 클래스에 Comparable 및 날짜(UseDate)를 기준으로 오름차순 하도록
구현하였다.

#### [구현화면]
````
    ======== 목록 ========
      인덱스                   날짜                   적요                   금액                현금/카드
        0                1900-01-01                  바밤바                 -300                 cash
        1                1900-01-01                  바밤바                 -200                 cash
        2                1990-05-01                  택시비                -3000                 cash
                                                                          -3500
````
위와 같이 결과 값이 잘 출력되는 것을 확인할 수 있다.
<br><br>

>### (4) 검색 기능 구현(날짜, 적요, 금액, 소비 유형)
 검색 기능은 입력한 내용과 결과를 RecordList에서 비교 후, 결과에 대한 인덱스를 List로 반환하여 결과를 출력하는 방식으로 구현
 했다.   
 App.java
 
    private void searchByCategory(int appCommand) {
    ...
        //날짜 검색
        if (appCommand == 1) {
            UseDate useDate = new UseDate(InputView.inputStringValue());
            searchList = loginMember.searchBy(useDate);
        } 
    ...
    }
 
 Member.java
 
    public List<Integer> searchBy(UseDate useDate) {
        return recordList.searchByDate(useDate);
    }
    
 RecordList.java
     
     public List<Integer> searchBy(UseDate useDate) {
         return recordList.searchByDate(useDate);
     }
     
 Record.java
     
     public boolean matchByUseDate(UseDate useDate) {
         return this.useDate.equals(useDate);
     }

해당 로직을 보면 다소 번거로워 보일 수 있다. 위와 같은 로직을 거쳐 처리한 이유는 Member class 내의 인스턴스 변수로
RecordList를 선언했기 때문이다. 여기서 의문점이 생길 수도 있다. <u>Record에서 직접 정보를 확인하면 되지 않나?</u>
가능은 하다 하지만 객체지향 프로그래밍에서의 정보은닉에 대한 규칙에 위배된다.   
그렇다면 왜 정보 은닉을 사용해야 하는걸까? [Effective Java](http://www.yes24.com/Product/Goods/65551284)에서는 정보 은닉의
장점을 이렇게 이야기 하고 있다.
````
    1. 시스템 개발 속도를 높인다. 여러 컴포넌트를 병렬로 개발할 수 있기 때문이다.
    2. 시스템 관리 비용을 낮춘다. 각 컴포넌트를 더 빨리 파악하여 디버깅할 수 있고, 다른 컴포넌트로 교체하는 부담도 적다.
    3. 성능 최적화에 도움을 준다. 다른 컴포넌트에 영향을 주지 않고 해당 컴포넌트만 최적화할 수 있기 때문이다.
    4. 소프트웨어 재사용성을 높인다. 외부에 거의 의존하지 않고 독자적으로 동작할 수 있는 컴포넌트라면 그 컴포넌트와 함께 개발되지 않은
    낯선 환경에서도 유용하게 쓰일 가능성이 크기 때문이다.
    5. 큰 시스템을 제작하는 난이도를 낮춰준다. 시스템 전체가 아직 완성되지 않은 상태에서도 개별 컴포넌트의 동작을 검증할 수 있기 때문이다.
````
아직 와닿지 않는 문장도 아직 있지만 4, 5번이 현재로서 와닿을 수 있는 내용인 것 같다. 위와 같은 내용 뿐만 아니라 객체는 자기 
자신이 능동적으로 작동할 수 있는 권한이 있어야 한다. 그러기 위해서는 직접 값을 참조하는 행위는 지양해야 한다.   

 RecordList 또한 직접 Record의 정보를 확인할 수 없기 때문에 Record에게 비교한 결과만 확인하기 위한 요청을 하게 된다.
 Record는 비교 결과를 RecordList에게 전달해주고 그 결과를 기반으로 인덱스를 list에 담는다. 인덱스를 담은 리스트들은 App.java로 
 이동해서 인덱스 결과와 일치하는 정보를 반환한다.
 <br><br>
 
 # Day9. 수업 내용 정리 및 추가 기능 구현
 ## 목록(Contents)
 - (1) String && StringBuffer
 - (2) 객체 관련 추가 설명(enum, interface)
 - (3) 접근 제한자
 - (4) static + final
 - (5) Collection framework
    - 검색 기능
    - 대소 비교
 <br/><br/>
 
> ### **(1) String && StringBuffer**
>#### **[String]**
>- **불변 객체(immutable object)**이다.
>- **객체를 지웠다가 객체를 다시 생성하고 주소를 참조하는 방식을 반복**한다.
>- 동작 방식 :**사용하지 않으면 garbage collector가 제거 → 객체 생성 → 주소 참조**
>
>#### **[StringBuffer]**
>- **변경 가능 객체(객체 내부 수정이 가능**하다)
>- **기존 객체의 값에 CRUD가 가능**하기 때문에 속도면에서 효율적이다.
<br><br/>

> ### **(2) 객체 관련 추가 설명(enum, interface)**
>### **[enum]**
>- 열거형을 의미하는 class의 종류이고 기업에서 정해져 있는 값을 처리하기 위한 방법에 유용한 방법이다.  
>
>### **[interface]**
>- 인터페이스는 객체를 생성할 수 없다. <u>자바는 **다중 상속이 불가능**하기 때문에</u> 사용할 수 없다.
> 하지만 인터페이스는 다른 프로그래밍 언어와 같이 <u>**다중 상속을 흉내내고 싶기 때문**</u>하다. 
> 주로 interace 이름에 **-able**을 많이 사용한다.   
>- <u>주로 기능을 정의하는 방식</u>으로 사용한다. 예를 들어, 날 수 있는, 잡아 먹을 수 있는 능력을 상속받아서 사용하는 경우에
> 사용하기 위해서 인터페이스를 사용한다.
>
>#### **[자바의 메서드는 객체일까?]**
>
>- 자바는 함수를 람다식을 이용해서 객체처럼 사용할 수 있다.
>- **함수형 프로그래밍** : <u>함수를 매개변수로 입력받아 값을 리턴하는 방식</u>을 구현할 수 있는 기능
<br><br>


>### **(3)접근 제한자**
>
>- private : 클래스 내부 (※일단 변수 범위를 설정 기준이 없으면 private로 시작하자)
>- protected : 상속받은 클래스만 사용 가능
>- default(package-private) : 해당 패키지 내에서만 사용가능
>- public : 모든 접근자 사용가능
<br><br>

>### **(4) static + final**
>### **[final 기능]** 
> 1.final 사용 위치에 따라 의미가 다르다.
> - final 변수 : **변경이 불가능한 값(상수)**이다.
> - final class :  **해당 클래스는 상속할 수 없다.**
> - final method : **Overriding(재정의)**할 수 없다.
><br><br>
>### [static 변수]
> static 변수는 <u>클래스 전체에서 하나만 사용하는 변수</u>이다. 하나만 클래스에서 공용으로 사용한다. 
>그러므로 **static 변수는 this를 사용하지 못한다**. 왜냐하면 <u>this의 의미는 **'객체 자기 자신'**</u>이기 때문이다.
<br><br>

>### (5) Collection framework
>#### (1)검색 기능
>   ```java
>    //Java 8 이후 버전부터 가능
>    for(var p : l){
>        if(p.value = 999){
>            System.out.println("찾았다.");
>        }
>    }
>    
>    //인덱스가 필요한 경우
>    for(int i = 0; i < l.size(); i++){
>        if(p.value = 999){
>            System.out.println("찾았다");
>        }
>    }
>    
>    시간 복잡도 : O(n)
>   ```
> 해당 변수 값을 찾기 위한 방법이다. 원하는 입력 값에 따라 list를 순회하고 결과 값과 일치할 경우 해당 객체를 반환한다.
>```java
>//검색 기능 구현
>
>Point p = new Point(999, 999, 999);
>
>for(Point now : list){
>	if(p.equals(now){
>		System.out.println("찾았다");
>	}
>}
>```
> 이번에는 객체를 이용해 값을 검색하는 방법이다. 객체를 선언해서 검색 결과를 반환하고 싶지만 결과값이 반환되지 않는다.
> 왜냐하면 <u>생성된 객체는 각각의 다른 주소값을 참조</u>하기 때문이다. 이를 해결하기 위해서 즉, <u>현실 세계와 같이
> 두 값이 같은 것으로 판단하기 위해서는 equals를 재정의</u> 하도록 한다.
>
> ```java
>  @Override
>      public boolean equals(Object o) {
>          if (!(o instanceof Point)) {
>              return false;
>          }
>  
>          Point other = (Point) o;
>  
>          return other.x.equals(this.y) &&
>                  other.x.equals((this.y));
>      }
>  ```
> 위와 같이 해당 클래스에 equals를 재정의하여 논리적 동치성, 다시 말해 현실 세계와 같이 두 값이 같다는 기준을 설정할 수 있다.
> 위 코드는 아래와 같은 로직으로 진행된다.
> 1. Point의 부모 클래스가 아닐 경우 이 또한 둘은 다른 객체이다.
> 2. 두 값의 기준은 x와 y가 같을 경우 두 객체가 같은 객체로 인식하자.
>
>위와 같이 같은 객체의 기준을 선정하면 객체값으로 검색하는 기능을 완성할 수 있다.
><br><br>
>#### (2) 대소 비교
> 대소 비교를 하기 위해서는 두가지 interface를 알고 있어야 한다. (1)Comparable, (2) Comparator이다.
>Comparable interface는 compareTo 메서드 하나만 가지고 있는 interface이다.
>> Comparable interface
>```java
>class Point implements Comparable<Point>{
>...
>    @Override
>    public compareTo(Point other){
>        return this.x - other.x;
>    }
>}
>```
>위의 코드와 같이 해당 클래스에 Comparable을 implement를 받아 compareTo를 재정의 하였다. 위 코드는 x기준 오름차순 정렬이다.
>compareTo method 작동원리는 아래와 같이 판단하면 편할 것 같다!
>- this.x - other.x > 0 -> this(자기자신)이 더 큰 경우는 **오름차순 정렬**이다. 
>- this.x - other.x == 0 -> this(자기자신)과 값이 같으므로 **동치 관계**이다. 
>- this.x - other.x < 0 -> this(자기자신)이 작으므로 **내림차순 정렬**이다. 
>
>>Comparator interface
>
>```java
>   class Point implements Comparator<Point>{
>    ...
>    @Override
>    public int compare(Point other){
>        return this.x - other.x;
>    }   
>}
>```
>위 코드도 Comparable과 동일하게 implements 받아 compare을 재정의하는 방식으로 구현한다. 위 코드는 Comparable의 코드와 같이
>x 오름차순 정렬을 구현한 내용이다.   
>
>```java
>   class ComparatorY implements Comparator<Point>{
>    @Override
>    public int compare(Point other){
>        return this.x - other.x;
>    }
>}
>```
>
>또는 Comparator를 직접 class로 구현하는 방법도 있다. interface는 직접 객체를 생성할 수 없기 때문에 별도로 class를 정의해야
>한다. 방법은 기존과 같다. Comparator를 implements한 후, compare를 재정의한다. 그렇다면 구현한 ComparatorY를 어떻게 사용하면
>좋을까?
>```java
>Collections.sort(list, new ComparatorY());
>``` 
>이와 같이 Collections의 static 메서드에 추가적으로 입력을 해주도록 한다. 그렇다면 의미는 list를 comparatorY 기준으로 정렬하겠
>다는 의미로 코드를 구성할 수 있다.   
> 하지만 별도의 인스턴스를 생성하는 방법은 옛날 방법이고 코드의 직관성이 떨어진다. 이를 해결하고자하는 방법이 <u>일급 컬렉션(first
>class collection)</u>이다.
>
>>일급 컬렉션(First Class Collection)
>```java
>Collections.sort(list,(Point p1, Point p2)->{
>    return p2.value - p1.value
>});
>```
> 위와 같은 방법은 람다식으로 표현한 방법이다. 기존의 자바의 경우 가장 아쉬운 점이 있었다. 바로 <u>함수를 매개변수로 사용하지
>못한다는 점</u>이었다. 하지만 JAVA 8 부터 람다식이 도입되면서 <u>함수를 매개변수 형태로 사용할 수 있는 기능이 추가</u>되었다. 
>- 일급 컬렉션 : Collection을 Wrapping하면서, 그 외 다른 멤버 변수가 없는 상태
>- 이점
>   - 비지니스에 종속적인 자료구조
>   - Collection의 불변성 보장
>   - 상태와 행위를 한 곳에 관리
>   - 이름있는 컬렉션
>
>자세한 내용은 [일급 컬렉션의 소개와 써야할 이유(by.jojoldu)](https://jojoldu.tistory.com/412)내용을 참고해서 공부할 예정.
