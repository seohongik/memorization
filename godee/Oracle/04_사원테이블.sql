CREATE TABLE EMPLOYEE
(
    ENO    	NUMBER(4)  CONSTRAINT PK_EMP PRIMARY KEY, --사원번호
    ENAME 	VARCHAR2(10),                             --사원명
    JOB        	VARCHAR2(9),        	                      --업무명
    MANAGER       NUMBER(4),         		                       --해당사원의 상사번호
    HIREDATE  	DATE,                 	                    --입사일  
    SALARY     	NUMBER(7,2),                              --급여    
    COMMIION 	NUMBER(7,2),                              --커미션    
    DNO       	NUMBER(2)   CONSTRAINT FK_DNO REFERENCES DEPARTMENT --부서번호
);

COMMIT;







