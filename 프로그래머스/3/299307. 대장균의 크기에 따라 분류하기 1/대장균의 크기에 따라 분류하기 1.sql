select e.id,
case
    when e.size_of_colony<=100 then "LOW"
    when e.size_of_colony<=1000 then "MEDIUM"
    else "HIGH"
end as size
from ecoli_data e
order by e.id