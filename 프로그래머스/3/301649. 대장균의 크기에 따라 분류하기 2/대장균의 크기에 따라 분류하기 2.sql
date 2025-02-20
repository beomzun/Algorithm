select e.id,
case
    when e.per<=0.25 then "CRITICAL"
    when e.per<=0.5 then "HIGH"
    when e.per<=0.75 then "MEDIUM"
    else "LOW"
end as colony_name
from (
    select id, percent_rank() over (order by size_of_colony desc) as per from ecoli_data
) as e
order by e.id