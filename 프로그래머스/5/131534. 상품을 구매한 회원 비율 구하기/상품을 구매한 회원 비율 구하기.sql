-- 코드를 입력하세요
# 회원 ID, 성별, 나이, 가입일 : USER_INFO 
# 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일 : ONLINE_SALE 
# 
# SELECT date_format(JOINED,"%Y") as "YEAR", date_format(JOINED,"%m") as "MONTH" , 
# (select count(distinct USER_ID)
#  from ONLINE_SALE 
#  where USER_ID in (select USER_ID
#                     from USER_INFO 
#                     where JOINED>="2021-01-01" and JOINED<"2022-01-01" and USER_ID)) as "PUCHASED_USERS"
# from USER_INFO 
# where JOINED>="2021-01-01" and JOINED<"2022-01-01" and USER_ID ;

SELECT date_format(SALES_DATE,"%Y") as "YEAR", date_format(SALES_DATE,"%m") as "MONTH" , count(distinct user_id) as `PUCHASED_USERS`, round(count(distinct user_id)/(select count(user_id)
                                                from USER_INFO
                                                where JOINED>="2021-01-01" and JOINED<"2022-01-01"),1) as PUCHASED_RATIO
from ONLINE_SALE
where USER_ID in (select USER_ID
                 from USER_INFO 
                where JOINED>="2021-01-01" and JOINED<"2022-01-01")
group by `year`, `month`