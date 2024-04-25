-- 코드를 입력하세요
# 환자번호, 환자이름, 성별코드, 나이, 전화번호를
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO,"NONE") as "TLNO"
from PATIENT 
where AGE<=12 and GEND_CD="W"
order by AGE desc, PT_NAME