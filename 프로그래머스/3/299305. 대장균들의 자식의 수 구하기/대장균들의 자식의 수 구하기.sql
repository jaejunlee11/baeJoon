-- id, parent_id, size_of_colony, differentiation_date, genotype 존재
-- 아이디, 부모 아이디, 개체의 크기, 분화 날짜, 개체 형질
-- 아이디와 자식의 숫자 출력
select A.ID, IFNULL(B.num,0) as "CHILD_COUNT"
from ECOLI_DATA A
left join (
    select PARENT_ID, count(*) as "num"
    from ECOLI_DATA
    group by PARENT_ID) B
on A.ID = B.PARENT_ID;