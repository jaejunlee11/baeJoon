-- 코드를 입력하세요
# 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일
# 리뷰 ID, 식당 ID, 회원 ID, 점수, 리뷰 텍스트, 리뷰 작성일
# 1.리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
# 2. 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬

SELECT m.MEMBER_NAME, r.REVIEW_TEXT, Date_format(r.REVIEW_DATE,"%Y-%m-%d") as "REVIEW_DATE"
from MEMBER_PROFILE m
inner join REST_REVIEW r
on m.MEMBER_ID = r.MEMBER_ID
where m.MEMBER_ID in (SELECT m.MEMBER_ID
from MEMBER_PROFILE m
inner join REST_REVIEW r
on m.MEMBER_ID = r.MEMBER_ID
group by m.MEMBER_ID
having count(*) >= all (SELECT count(*)
from MEMBER_PROFILE m
inner join REST_REVIEW r
on m.MEMBER_ID = r.MEMBER_ID
group by m.MEMBER_ID))
order by `REVIEW_DATE`, REVIEW_TEXT;

# (SELECT count(*)
# from MEMBER_PROFILE m
# inner join REST_REVIEW r
# on m.MEMBER_ID = r.MEMBER_ID
# group by m.MEMBER_ID);