select count(*) as fish_count, fish_name
from fish_info left join fish_name_info using(fish_type)
group by fish_name
order by fish_count desc