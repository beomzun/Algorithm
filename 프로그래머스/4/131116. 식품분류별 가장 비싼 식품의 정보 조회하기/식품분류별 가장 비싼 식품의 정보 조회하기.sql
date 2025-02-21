select category, price as max_price ,product_name
from (
    select *, rank() over(partition by category order by price desc) as rnk
    from food_product
    where category in ('과자','국','김치','식용유')
) as info
where rnk=1
order by price desc

/*

*/