-- ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE
-- 개체 아이디, 부모 아이디, 크기, 분화된 날짜, 개체의 형질
-- 크기순으로 정렬시 상위 25퍼, 50퍼, 75퍼 나눠서 ID와 COLONY_NAME출력
select ID, (case when ntile(4) over (order by SIZE_OF_COLONY desc) = 1 then "CRITICAL"
                when ntile(4) over (order by SIZE_OF_COLONY desc) = 2 then "HIGH"
                when ntile(4) over (order by SIZE_OF_COLONY desc) = 3 then "MEDIUM"
                else "LOW" end) as "COLONY_NAME"
from ECOLI_DATA
order by ID;

