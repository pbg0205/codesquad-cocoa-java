# final-project : 쿠크샐러드(swing GUI 가계부)
## 목록(Contents)
### 1. 목표
### 2. 요구사항
### 3. 구현
### 4. 소감

---
> ### 1. 목표
- [x] Swing GUI를 이용한 프로그램 제작해보자.
- [x] 코드 스쿼드에서 배웠던 내용들을 최대한 활용해보자.
- [x] View와 내부 로직을 구분하는 코드를 작성하자.
<br><br>
> ### 2. 요구사항
- [x] **1.로그인**
    - [x] (1) IO를 이용한 회원 정보 공간을 만들기.
    - [x] (2) IO를 이용한 회원 가계부 내용 저장 공간 만들기.
    - [x] (3) 로그아웃
    
- [x] **2.회원가입**
    - [x] (1) 기존 회원 아이디 중복 확인
    - [x] (2) 비밀번호 일치 여부 확인
    - [x] (3) 비밀번호 내, 특수문자 포함 확인
    - [x] (4) 가입 완료 시, 회원 정보 생성
    
- [x] **3.가계부**
    - [x] 가계부 내역 출력하기
    - [x] 내역 추가하기
    - [x] 내역 수정하기
    - [x] 내역 삭제하기
    - [ ] 내역 추가, 수정, 삭제 완료 후, 내역 출력 갱신
<br><br>
    
> ### 3. 구현
#### **1.로그인**
(1) 로그인 메인 화면   
![로그인 메인](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/login_page.png)   
(2) 로그인 성공 화면   
![로그인 성공](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/login_success.PNG)   
<br>

#### **2.회원가입**
(1) 회원가입 화면   
![회원가입](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/signup_input.PNG)   
(2) 아이디 중복 예외 화면   
![아이디 중복](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/duplicated_Id_message.PNG)   
(3) 비밀번호 불일치 예외 화면   
![불일치](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/not_same_password.PNG)    
(4) 특수문자 미포함 비밀번호 화면    
![특수문자](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/not_special_character.PNG)   
<br><br>

#### **3.가계부 페이지**
(1) 가계부 메인 화면   
![가계부 메인](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/main_page.PNG)   
(2) 가계부 추가 화면   
<1.추가화면>   
![추가 화면](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/add_command.PNG)   
<2.추가완료>   
![추가 완료](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/add_confirm.PNG)   
<br>
(3) 가계부 수정 화면   
<1.수정화면>   
![수정 화면](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/modify_command.PNG)   
<2.수정완료>   
![수정 완료](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/modify_confirm.PNG)   
<br>
(4) 가계부 삭제 화면   
<1.삭제화면>   
![삭제 화면](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/delete_command.PNG)   
<2. 삭제완료>   
![삭제 완료](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/delete_page.PNG)   
- 0번 인덱스의 '바밤바'가 삭제된 것을 확인할 수 있습니다.
<br>

#### **4.소감**
**<코코아를 지원하게 된 계기>**  
 이전에 프로그래밍을 **독학하면서 항상 느끼고 있었던 갈증**은
  - 현재 학습 방법에 대한 **확신이 없다.**
  - 모르는 것을 **물어볼 사람**이 없다.
  - **내 코드를 리뷰**받고 싶다.   
  
 개발자는 평생 공부해야 하는 직업으로 알고 있습니다. 저 또한 개발자 지망생으로서 독학에서 오는 갈증을 해소하고 싶었고  좋은 습관
 을 들일 수 있는 좋은 기회라고 생각했습니다. 코드스쿼드의 메인 코스는 마스터즈 코스이지만, 프리코스로 코코아 코스가 있는 것을 
 알게되었습니다. 6개월인 마스터즈코스에 반해 코코아 과정은 1달동안 코드스쿼드의 학습 분위기를 미리 체험해볼 수 있었습니다.   
   
  코코아 과정을 겪으면서 **세 가지의 장점**이 있었습니다.
  - zoom을 이용한 온라인 학습방식으로 **이동 시간의 제약이 없다.**
  - 그룹원들과 의사소통을 통해 **다양한 접근 방법**을 얻을 수 있습니다.
  - 같이 으쌰으쌰할 **열정적인 동료**과 함께 학습할 수 있다.
  
 위의 장점을 보면 1번을 제외한 장점들은 결국 **본인의 적극성**에 따라 달라지는 것 같습니다. 그리고 코드스쿼드 분위기 또한 이와 
 같다고 생각합니다. 수업 위주, 코드 따라치는 방식이 아닌 직접 본인이 고민해보고 해결하는 방식입니다. 결국 자신이 노력한 만큼 
 많이 얻어가는 과정이라고 생각합니다. 아마 이 부분이 코드스쿼드가 추구하는 방향성이라고 생각합니다.   
  다행히 5주 과정을 진행하면서 그룹원들이 다들 열심히 해준 덕분에 의지가 떨어질 때마다 정신줄 부여잡고 학습할 수 있었습니다.
 5주동안 함께 열심히 학습한 그룹원들, 질문에 친절에 대답해주신 조교님들, 그리고 백엔드 마스터로 항상 멘탈을 잡아주신 호눅스 
 모두에게 감사드립니다.   
 마지막으로 저번에 기념사진 올리고 마치겠습니다. 빠이!   
 ![title](https://github.com/pbg0205/codesquad-cocoa-java/blob/master/AccountBook/image/codesquad.png){: width="500" height="500"}