# -- 코드를 입력하세요
# SELECT warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N')
# from food_warehouse
# where left(address, 3) = '경기도'
# order by 1 asc

select warehouse_id, warehouse_name, address, ifnull(freezer_yn,'N')
from food_warehouse
where address like '경기도%'
order by warehouse_id asc

# FOOD_WAREHOUSE 테이블에서 
# 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회하는 SQL문을 작성해주세요. 
# 이때 냉동시설 여부가 NULL인 경우, 'N'으로 출력시켜 주시고 
# 결과는 창고 ID를 기준으로 오름차순 정렬해주세요.