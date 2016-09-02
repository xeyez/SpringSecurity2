# SpringSecurity2
In-depth study for Spring Security.

## 구현 ##
* 권한에 따른 페이지 처리 (+ 권한 없을 시 Custom page 보이기)
* 로그아웃 후 지정한 페이지로 이동
* Custom 로그인 View
* MySQL 연동 및 읽기
* 회원 가입 (비밀번호 평문)
* 회원 가입 (비밀번호 bCrypt 암호화)
* 로그인 - 자동 로그인(Remember Me) (1주)

* Custom Table & Custom VO 사용
 * 계층별 분할(Persistence, Service)
 * MyBatis 연동

## 미구현 ##
* Session 및 Cookie 조작
 * Remember me (자동 로그인) Custom 구현
 * HttpSession 대신 Cookie 사용. (서버 과부하 줄이기)
* 회원 탈퇴, 비밀번호 변경, 회원 정보 수정
 * 내부 Logic은 다 짜여 있으나 View 처리는 안된 상태.
