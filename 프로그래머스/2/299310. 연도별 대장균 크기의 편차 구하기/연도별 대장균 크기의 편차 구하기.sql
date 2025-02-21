select year, max_size-e.size_of_colony as year_dev, id
from ecoli_data e left join (
    select year(DIFFERENTIATION_DATE) as year, max(size_of_colony) as max_size
    from ecoli_data
    group by year
) as s on year(e.DIFFERENTIATION_DATE) = s.year
order by year asc, year_dev asc