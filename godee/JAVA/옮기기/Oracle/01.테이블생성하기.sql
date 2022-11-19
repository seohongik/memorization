-- 현재 사용자 정보보기
SHOW USER;

-- 사용자 생성하기
create user scott identified by tiger;

-- 권한 부여하기
grant resource, connect to scott;
