-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF f
inner join JULY j
on f.FLAVOR = j.FLAVOR
group by f.FLAVOR, f.TOTAL_ORDER	
order by (f.TOTAL_ORDER + sum(j.TOTAL_ORDER)) desc
limit 3;

# SELECT f.FLAVOR, f.TOTAL_ORDER, sum(j.TOTAL_ORDER)
# from FIRST_HALF f
# inner join JULY j
# on f.FLAVOR = j.FLAVOR
# group by f.Flavor, f.TOTAL_ORDER	

# select *
# from FIRST_HALF;

# select *
# from JULY;