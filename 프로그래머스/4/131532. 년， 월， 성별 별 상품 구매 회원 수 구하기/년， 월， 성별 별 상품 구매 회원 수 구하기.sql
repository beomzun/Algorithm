select year(sales_date) as year, month(sales_date) as month, gender, count(distinct user_id) as users
from online_sale left join user_info using(user_id)
where gender is not null
group by year,month,gender
order by year asc,month asc,gender asc