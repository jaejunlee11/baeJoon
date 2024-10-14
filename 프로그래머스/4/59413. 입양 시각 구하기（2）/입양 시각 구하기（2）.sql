-- ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
with recursive cte (n)
as (select 0 as n
   union all
   select n+1
   from cte
   where n<23)
select A.n as "HOUR", (case when B.count is null then 0
                else B.count end) as "COUNT"
from cte A
left join 
(SELECT HOUR, count(*) as "count"
from (SELECT HOUR(DATETIME) as "HOUR"
from ANIMAL_OUTS) A
group by HOUR
order by HOUR) B
on A.n = B.HOUR