# select year, max_size-e.size_of_colony as year_dev, id
# from ecoli_data e left join (
#     select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) as max_size
#     from ecoli_data
#     group by year
# ) as s on year(e.DIFFERENTIATION_DATE) = s.year
# order by year asc, year_dev asc

select year(l.differentiation_date) as year, (r.max_size-l.size_of_colony) as year_dev, l.id
from ecoli_data as l left join (
    select max(size_of_colony) as max_size, year(differentiation_date) as year
    from ecoli_data
    group by year
) as r on year(l.differentiation_date)=r.year
order by year asc, year_dev asc

# 분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력하는 SQL 문을 작성해주세요. 
# 분화된 연도별 대장균 크기의 편차는 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기로 구하며 
# 결과는 연도에 대해 오름차순으로 정렬하고 같은 연도에 대해서는 대장균 크기의 편차에 대해 오름차순으로 정렬해주세요.