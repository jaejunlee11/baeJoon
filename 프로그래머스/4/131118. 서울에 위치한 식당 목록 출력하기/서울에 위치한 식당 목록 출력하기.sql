-- 코드를 입력하세요
# 식당 ID, 식당 이름, 음식 종류, 조회수, 즐겨찾기수, 주차장 유무, 주소, 전화번호
# 리뷰 ID, 식당 ID, 회원 ID, 점수, 리뷰 텍스트, 리뷰 작성일
SELECT i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES , i.ADDRESS, round(avg(r.REVIEW_SCORE),2) "SCORE"
from REST_INFO i
left join REST_REVIEW r
on i.REST_ID = r.REST_ID
where ADDRESS like "서울%" and r.REVIEW_SCORE is not null
group by i.REST_ID
order by `SCORE` desc, FAVORITES desc