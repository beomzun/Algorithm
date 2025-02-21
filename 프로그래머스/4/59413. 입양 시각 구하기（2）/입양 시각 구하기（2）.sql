with recursive h as (
    select 0 as hour
    union all
    select hour+1 from h where hour<23
)

select hour, count(animal_id) as count
from animal_outs right join h on hour(datetime)=hour
group by hour
order by hour asc