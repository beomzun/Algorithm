# -- 코드를 입력하세요
# select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(avg(r.review_score),2) as score
# from rest_info as i join rest_review as r on i.rest_id = r.rest_id
# where i.address like '서울%'
# group by rest_id
# order by score desc, i.favorites desc

select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(avg(r.review_score),2) as score
from rest_info as i join rest_review as r on i.rest_id = r.rest_id
where i.address like '서울%'
group by i.rest_id
order by score desc, i.favorites desc

# 서울에 위치한 식당들
# 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수
# 리뷰 평균점수는 소수점 세 번째 자리에서 반올림 해주시고
# 결과는 평균점수를 기준으로 내림차순 정렬해주시고, 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬