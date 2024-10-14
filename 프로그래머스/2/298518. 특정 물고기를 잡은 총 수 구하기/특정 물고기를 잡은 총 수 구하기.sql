-- ID, FISH_TYPE, LENGTH, TIME
-- 아이디, 물고기 타입, 길이, 시간
-- BASS와 SNAPPER 수 출력
select count(*) as "FISH_COUNT"
from (select A.ID, B.FISH_NAME
from FISH_INFO A
left join FISH_NAME_INFO B
on A.FISH_TYPE = B.FISH_TYPE) FISH_NAME_INFO
where FISH_NAME = "BASS" or FISH_NAME = "SNAPPER";
