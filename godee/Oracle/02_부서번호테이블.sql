CREATE TABLE DEPARTMENT(
    DNO     NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,   --부서번호
    DNAME   VARCHAR2(14),                               --부서명
    LOC     VARCHAR2(13)                                --지역명
);

COMMIT;