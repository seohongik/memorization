-- 시작값이 10이고 10씩 증가하는 시퀀스 생성하기
CREATE SEQUENCE SAMPLE_SEQ
INCREMENT BY 10
START WITH 10;

COMMIT;

-- 데이터 사전에서 시퀀스 조회하기
SELECT sequence_name, min_value, max_value, increment_by, cycle_flag
FROM user_sequences;

-- NEXTVAL로 새로운 값 생성하기
SELECT sample_seq.nextval
FROM dual;

-- 시퀀스의 현재값 조회하기
SELECT sample_seq.currval
FROM dual;

-- 부서 번호를 위한 시퀀스 생성하기
CREATE SEQUENCE DNO_SEQ
INCREMENT BY 10
START WITH 10;

COMMIT;

-- 빈 테이블 복사하기
DESC dept_second;

DROP TABLE dept_second;

COMMIT;

CREATE TABLE DEPT_SECOND
AS
SELECT *
FROM department WHERE 0 = 1;

COMMIT;

-- 정보 입력하기
SELECT *
FROM dept_second;

INSERT INTO dept_second
VALUES(DNO_SEQ.nextval, 'ACCOUNTING', 'NEW YORK');

COMMIT;

SELECT *
FROM dept_second;

-- 최대값 확인하기
SELECT sequence_name, min_value, max_value, increment_by, cycle_flag
FROM user_sequences
WHERE sequence_name IN('DNO_SEQ');

-- 시퀀스 변경하기
ALTER SEQUENCE DNO_SEQ
MAXVALUE 50;

COMMIT;


-- 스퀀스 제거하기
DROP SEQUENCE DNO_SEQ;

COMMIT;

-- 테이블에 자동 생성된 인덱스 조회하기
SELECT index_name, table_name, column_name
FROM user_ind_columns
WHERE table_name IN('EMPLOYEE', 'DEPARTMENT');

-- 인덱스 생성하기
CREATE INDEX idx_employee_ename
ON employee(ename);

COMMIT;

SELECT index_name, table_name, column_name
FROM user_ind_columns
WHERE table_name IN('EMPLOYEE');

-- 인덱스 제거하기
DROP INDEX idx_employee_ename;
COMMIT;

-- 인덱스 재생성
ALTER INDEX pk_emp REBUILD;
COMMIT;

--고유 인덱스 지정하기
SELECT *
FROM dept_second;

CREATE UNIQUE INDEX idx_dept_dno
ON dept_second(dno);

COMMIT;

SELECT index_name, table_name, column_name
FROM user_ind_columns
WHERE table_name IN('DEPT_SECOND');

-- 주의 사항
CREATE UNIQUE INDEX idx_dept_loc
ON dept_second(loc);
COMMIT;


SELECT index_name, table_name, column_name
FROM user_ind_columns
WHERE table_name IN('DEPT_SECOND');

-- 결합 인덱스 정의하기
CREATE INDEX idx_dept_com
ON dept_second(dname,loc);
SELECT index_name, table_name, column_name
FROM user_ind_columns
WHERE table_name IN('DEPT_SECOND');

-- 함수 기반 인덱스 생성하기
CREATE INDEX idx_emp_second_annsal
ON emp_second(salary*12);

SELECT index_name, table_name, column_name
FROM user_ind_columns
WHERE table_name IN('EMP_SECOND');
