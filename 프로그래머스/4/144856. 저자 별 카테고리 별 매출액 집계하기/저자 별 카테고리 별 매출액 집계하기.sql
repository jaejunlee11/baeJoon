-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(s.SALES * b.PRICE)  as "TOTAL_SALES"
from BOOK b
inner join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
inner join BOOK_SALES s
on b.BOOK_ID = s.BOOK_ID
where s.SALES_DATE<"2022-02-01" and s.SALES_DATE>="2022-01-01"
group by b.CATEGORY, a.AUTHOR_ID
order by a.AUTHOR_ID, b.CATEGORY desc

