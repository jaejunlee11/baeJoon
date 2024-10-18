-- Member_ID, MEMBER_NAME, TLNO,GENDER,DATE_OF_BIRTH
-- 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일
-- REVIEW_ID, REST_ID, MEMBER_ID, REVIEW_SCORE, REVIEW_TEXT, REVIEW_DATE
-- 리뷰 ID, 식당 ID, 회원 ID, 점수, 리뷰 텍스트, 리뷰 작성일
-- 리뷰를 가장 많이 작성한 회원의 리뷰
select A.MEMBER_NAME, B.REVIEW_TEXT, DATE_FORMAT(B.REVIEW_DATE, "%Y-%m-%d") as "REVIEW_DATE"
from (select A.MEMBER_NAME, A.MEMBER_ID
from MEMBER_PROFILE A
left join (SELECT RANK() over(order by countREVIEW desc) as "review_rank", MEMBER_ID
from (SELECT MEMBER_ID, count(*) as "countREVIEW"
from REST_REVIEW
group by MEMBER_ID) sub) B
on A.MEMBER_ID = B.MEMBER_ID
where B.review_rank = 1) A
left join REST_REVIEW B
on A.MEMBER_ID = B.MEMBER_ID
order by REVIEW_DATE, REVIEW_TEXT;