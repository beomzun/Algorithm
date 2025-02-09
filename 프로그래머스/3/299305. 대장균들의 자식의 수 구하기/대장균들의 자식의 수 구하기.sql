-- 코드를 작성해주세요
select p.id, count(c.parent_id) as child_count
from ecoli_data p left join ecoli_data c on c.parent_id = p.id
group by p.id
order by p.id asc
