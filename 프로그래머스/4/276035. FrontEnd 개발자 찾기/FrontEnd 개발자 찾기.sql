-- 코드를 작성해주세요
# 스킬의 이름, 스킬의 범주, 스킬의 코드 : SKILLCODES 
# 개발자의 ID, 이름, 성, 이메일, 스킬 코드 : DEVELOPERS 
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select sum(CODE) 
                    FROM SKILLCODES
                    WHERE CATEGORY = "Front End")
order by ID