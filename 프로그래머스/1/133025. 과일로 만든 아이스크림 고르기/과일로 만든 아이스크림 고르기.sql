-- 코드를 입력하세요
# (SELECT flavor from first_half where total_order > 3000) intersect (select flavor from icecream_info where ingredient_type = 'fruit_based')

select flavor
from first_half as h join icecream_info as i using(flavor)
where h.total_order>3000 and i.ingredient_type='fruit_based'
order by h.total_order desc
