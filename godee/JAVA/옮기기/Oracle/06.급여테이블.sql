CREATE TABLE SALGRADE(
GRADE       NUMBER      CONSTRAINT PK_SAL PRIMARY KEY, -- 급여 등급
LOSAL       NUMBER,                                    -- 급여 하한값
HISAL       NUMBER                                     -- 급여 상한값
);

COMMIT;