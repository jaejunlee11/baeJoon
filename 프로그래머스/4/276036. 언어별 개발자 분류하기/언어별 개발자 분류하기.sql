-- NAME, CATEGORY, CODE
-- 스킬 이름, 스킬 범주, 스킬 코드
-- ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_CODE
-- 개발자 id, 이름, 성, 이메일, 스킬 코드
-- grade, id, email 조회
with grade as (
select ID, (case when ((select count(*)
                      from SKILLCODES
                      where NAME="Python" and (SKILL_CODE & CODE != 0)) >0) and
            ((select count(*)
                      from SKILLCODES
                      where CATEGORY="Front End" and (SKILL_CODE & CODE != 0)) >0) then "A"
           when ((select count(*)
                      from SKILLCODES
                      where NAME="C#" and (SKILL_CODE & CODE != 0)) >0) then "B"
            when ((select count(*)
                      from SKILLCODES
                      where CATEGORY="Front End" and (SKILL_CODE & CODE != 0)) >0) then "C" end) as "GRADE"
    from DEVELOPERS
)
select A.GRADE, A.ID, B.EMAIL
from grade A
left join DEVELOPERS B
on A.ID = B.ID
where GRADE is not null
order by GRADE, A.ID