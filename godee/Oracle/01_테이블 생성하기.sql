
-- 현재 사용자 정보보기
SHOW USER;

--tiger라는 패스워드로 scott이라는 사용자를 만들어주세요 

create user scott identified by tiger;

--권한 부여하기 

grant resource, connect to scott;