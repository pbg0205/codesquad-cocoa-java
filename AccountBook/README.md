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