# select id from ecoli_data
# where parent_id in (
#     select id from ecoli_data 
#     where parent_id in (
#         select id from ecoli_data where parent_id is null
#     )
# )
# order by id

select id from ecoli_data
where parent_id in (
    select id from ecoli_data
        where parent_id in (
            select id from ecoli_data
            where parent_id is null
    )
)
order by id asc

# 3세대의 대장균의 ID(ID) 를 출력하는 SQL 문을 작성해주세요. 
# 이때 결과는 대장균의 ID 에 대해 오름차순 정렬해주세요.