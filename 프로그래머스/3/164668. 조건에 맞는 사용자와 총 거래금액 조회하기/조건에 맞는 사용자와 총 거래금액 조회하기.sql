-- BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS
-- 게시글 아이디, 작성자 아이디, 제목, 내용, 가격, 작성일, 거래상태, 조회수
-- USER_ID,NICKNAME,CITY, STREET_ADDRESS1, STREET_ADRESS2, TLNO
-- 회원 아이디, 닉네임, 시, 도로명 주소, 상세주소, 전화번호
select A.USER_ID, A.NICKNAME, B.TOTAL_SALES
from USED_GOODS_USER A
right join (select WRITER_ID, sum(PRICE) as "TOTAL_SALES"
from USED_GOODS_BOARD
where STATUS = "DONE"
group by WRITER_ID) B
on A.USER_ID = B.WRITER_ID
where B.TOTAL_SALES >= 700000
order by B.TOTAL_SALES