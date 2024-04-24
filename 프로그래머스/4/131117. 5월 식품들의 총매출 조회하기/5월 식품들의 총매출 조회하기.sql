-- 코드를 입력하세요
SELECT o.PRODUCT_ID, p.PRODUCT_NAME, sum(p.PRICE*o.AMOUNT) as "TOTAL_SALES"
from FOOD_PRODUCT p
inner join FOOD_ORDER o
on p.PRODUCT_ID = o.PRODUCT_ID
where "2022-05-01"<=o.PRODUCE_DATE and o.PRODUCE_DATE<"2022-06-01"
group by o.PRODUCT_ID
order by `TOTAL_SALES` desc, o.PRODUCT_ID;

# select *
# from FOOD_PRODUCT p
# inner join FOOD_ORDER o
# on p.PRODUCT_ID = o.PRODUCT_ID
# where "2022-05-01"<=o.IN_DATE and o.OUT_DATE<"2022-06-01"