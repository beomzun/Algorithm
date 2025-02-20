select o.product_id, p.product_name, sum(p.price*o.amount) as total_sales
from food_product p right join food_order o
on o.product_id=p.product_id and 
o.produce_date between "2022-05-01" and "2022-05-31"
where p.price*o.amount>0
group by o.product_id
order by total_sales desc, o.product_id asc