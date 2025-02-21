/*
종류별로 가장 큰 물고기들 조회
*/
select id, fish_name, length
from (
    select *, rank() over(partition by fish_type order by length desc) as rnk from fish_info
) as rnk_table left join fish_name_info using(fish_type)
where rnk=1
order by id asc