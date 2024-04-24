-- 코드를 입력하세요
# 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부 : ANIMAL_INS 
# 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부 : ANIMAL_OUTS 


SELECT i.NAME, i.DATETIME
from ANIMAL_INS i
left outer join ANIMAL_OUTS o
on i.ANIMAL_ID = o.ANIMAL_ID
where o.DATETIME is null
order by i.DATETIME
limit 3;