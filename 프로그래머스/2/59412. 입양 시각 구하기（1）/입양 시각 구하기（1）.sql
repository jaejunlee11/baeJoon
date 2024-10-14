-- ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
-- 동물 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부
-- 몇시에 몇번의 입양이 발생하는지 조회
select HOUR, count(*) as "COUNT"
from (select HOUR(DATETIME) as "HOUR"
    from ANIMAL_OUTS
     where HOUR(DATETIME)<20 and HOUR(DATETIME)>8) A
    group by HOUR
    order by HOUR