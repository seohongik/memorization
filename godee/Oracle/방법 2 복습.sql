
--25기 서홍익 부서테이블 생성하기(2)
CREATE TABLE DEPARTMENT
(
    DNO     NUMBER(2)       NOT NULL,   --부서번호
    DNAME   VARCHAR2(14)    NOT NULL,   --부서명
    LOC     VARCHAR2(13)    NOT NULL,    --지역명
    CONSTRAINT PK_DEPT PRIMARY KEY(DNO)
);

COMMIT;



--25기 서홍익 부서테이블 구조 확인하기(2)

DESC department;






--25기 서홍익 사원테이블 생성하기(2)
CREATE TABLE EMPLOYEE
(
    ENO      	NUMBER(4)    NOT NULL, --사원번호
    ENAME 	    VARCHAR2(10) NOT NULL,                             --사원명
    JOB        	VARCHAR2(9)  NOT NULL,        	                  --업무명
    MANAGER     NUMBER(4),         		                  --해당사원의 상사번호
    HIREDATE  	DATENOT      NOT NULL,                 	                  --입사일  
    SALARY     	NUMBER(7,2)  NOT NULL,                              --급여    
    COMMIION 	NUMBER(7,2),                              --커미션    
    DNO       	NUMBER(2)    NOT NULL,    --부서번호
    CONSTRAINT PK_EMP PRIMARY KEY(ENO),
    CONSTRAINT FK_DNO FOREIGN KEY(DNO)REFERENCES  DEPARTMENT
);
COMMIT;

--25기 서홍익 사원테이블 구조 확인하기(2)

DESC employee;

DROP TABLE employee;

commit;










--25기 서홍익 부서테이블 생성하기(2)
CREATE TABLE DEPARTMENT
(
    DNO     NUMBER(2)       NOT NULL,   --부서번호
    DNAME   VARCHAR2(14)    NOT NULL,   --부서명
    LOC     VARCHAR2(13)    NOT NULL,    --지역명
    CONSTRAINT PK_DEPT PRIMARY KEY(DNO)
);

COMMIT;



--25기 서홍익 부서테이블 구조 확인하기(2)

DESC department;






--25기 서홍익 사원테이블 생성하기(2)
CREATE TABLE EMPLOYEE
(
    ENO      	NUMBER(4)    NOT NULL,                      --사원번호
    ENAME 	    VARCHAR2(10) NOT NULL,                      --사원명
    JOB        	VARCHAR2(9)  NOT NULL,        	            --업무명
    MANAGER     NUMBER(4),         		                    --해당사원의 상사번호
    HIREDATE  	DATENOT      NOT NULL,                      --입사일  
    SALARY     	NUMBER(7,2)  NOT NULL,                      --급여    
    COMMIION 	NUMBER(7,2),                                --커미션    
    DNO       	NUMBER(2)    NOT NULL,                      --부서번호
    CONSTRAINT PK_EMP PRIMARY KEY(ENO),
    CONSTRAINT FK_DNO FOREIGN KEY(DNO)REFERENCES  DEPARTMENT
);
COMMIT;

--25기 서홍익 사원테이블 구조 확인하기(2)

DESC employee;

DROP TABLE employee;

commit;














--25기 서홍익 사원테이블 생성하기(2)
CREATE TABLE EMPLOYEE
(
    ENO      	NUMBER(4)    NOT NULL,                    --사원번호
    ENAME 	    VARCHAR2(10) NOT NULL,                    --사원명
    JOB        	VARCHAR2(9)  NOT NULL,        	          --업무명
    MANAGER     NUMBER(4),         		                  --해당사원의 상사번호
    HIREDATE  	DATE         NOT NULL,                    --입사일  
    SALARY     	NUMBER(7,2)  NOT NULL,                    --급여    
    COMMIION 	NUMBER(7,2),                              --커미션    
    DNO       	NUMBER(2)    NOT NULL,                    --부서번호
    CONSTRAINT PK_EMP PRIMARY KEY(ENO),
    CONSTRAINT FK_DNO FOREIGN KEY(DNO)REFERENCES DEPARTMENT
);
COMMIT;

DESC employee;

--급여 테이블 생성하기(2)

CREATE TABLE SALGRADE(
    DNO     NUMBER  NOT NULL,        --급여등급
    LOSAL   NUMBER  NOT NULL,         --급여 하한값
    HISAL   NUMBER  NOT NULL,      --급여 상한값  
    CONSTRAINT PK_SAL PRIMARY KEY(DNO)
);

COMMIT;




--급여 테이블 구조 확인하기(2)



DESC salgrade;
















