# select e.id, 
# case
#     when e.rnk<=0.25 then 'CRITICAL'
#     when e.rnk<=0.5 then 'HIGH'
#     when e.rnk<=0.75 then 'MEDIUM'
#     else 'LOW'
# end as colony_name
# from (
#     select id, percent_rank() over(order by size_of_colony desc) as rnk
#     from ecoli_data
# ) as e
# order by e.id asc

select e.id,
case
    when e.rnk<=0.25 then "CRITICAL"
    when e.rnk<=0.5 then "HIGH"
    when e.rnk<=0.75 then "MEDIUM"
    else "LOW"
end colony_name
from (
    select id, percent_rank() over(order by size_of_colony desc) as rnk
    from ecoli_data
) as e
order by e.id asc

# 대장균 개체의 크기를 내름차순으로 정렬했을 때 상위 0% ~ 25% 를 'CRITICAL', 26% ~ 50% 를 'HIGH', 51% ~ 75% 를 'MEDIUM', 76% ~ 100% 를 'LOW' 라고 분류합니다. 
# 대장균 개체의 ID(ID) 와 분류된 이름(COLONY_NAME)을 출력하는 SQL 문을 작성해주세요. 
# 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요. 
# 단, 총 데이터의 수는 4의 배수이며 같은 사이즈의 대장균 개체가 서로 다른 이름으로 분류되는 경우는 없습니다.