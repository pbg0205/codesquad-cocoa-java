# Day13.미션 6 한글 시계, 캘린더 만들기
## 목록(Contents)
- (1) 구현 영상
    - 쉘 만들기
        - history
        - concat
    - 한글 시계, 캘린더 만들기
- (2) shell command
<br/><br/>

> ### **구현영상**
#### 1.구현 영상
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