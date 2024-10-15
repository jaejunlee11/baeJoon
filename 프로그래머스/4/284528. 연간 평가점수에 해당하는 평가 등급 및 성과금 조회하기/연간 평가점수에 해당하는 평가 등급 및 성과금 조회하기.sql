-- DEPT_ID, DEPT_NAME_KR, DEPT_NAME_EN, LOCATION
-- 부서ID, 국문 부서명, 영문 부서명, 부서 위치
-- EMP_NO, EMP_NAME, DEPT_ID, POSITION, EMAIL, COMP_TEL, HIRE_DATE, SAL
-- 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉
-- EMP_NO,YEAR,HALF_YEAR,SCORE
-- 사번, 연도, 반기, 평가 점수
-- 사원별 성과금 정보 조회
select A.EMP_NO, A.EMP_NAME, B.GRADE, SAL*B.PLUS as "BONUS"
from HR_EMPLOYEES A
right join 
(select EMP_NO, (case when avg(SCORE)>= 96 then "S"
                    when avg(SCORE)>=90 then "A"
                    when avg(SCORE)>=80 then "B"
                    else "C" end) as "GRADE", (case when avg(SCORE)>= 96 then 0.2
                    when avg(SCORE)>=90 then 0.15
                    when avg(SCORE)>=80 then 0.1
                    else 0 end) as "PLUS"
from HR_GRADE
group by EMP_NO) B
on A.EMP_NO = B.EMP_NO