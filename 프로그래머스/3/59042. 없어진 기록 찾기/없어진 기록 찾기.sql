-- 코드를 입력하세요
# ANIMAL_ID 외래키
# i.DATETIME존재 , o.DATETIME없는 동물의 id와 이름 조회
SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_INS i
right outer join ANIMAL_OUTS o
on i.ANIMAL_ID = o.ANIMAL_ID
where i.INTAKE_CONDITION is null
order by o.ANIMAL_ID;