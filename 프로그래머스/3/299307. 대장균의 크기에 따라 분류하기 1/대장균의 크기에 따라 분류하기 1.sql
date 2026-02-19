# select e.id,
# case
#     when e.size_of_colony<=100 then "LOW"
#     when e.size_of_colony<=1000 then "MEDIUM"
#     else "HIGH"
# end as size
# from ecoli_data e
# order by e.id

select e.id,
case
    when e.size_of_colony<=100 then "LOW"
    when e.size_of_colony>1000 then "HIGH"
    else "MEDIUM"
end size
from ecoli_data e
order by e.id asc


# 대장균 개체의 크기가 100 이하라면 'LOW', 100 초과 1000 이하라면 'MEDIUM', 1000 초과라면 'HIGH' 라고 분류합니다.
# 대장균 개체의 ID(ID) 와 분류(SIZE)를 출력하는 SQL 문을 작성해주세요.
# 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요.