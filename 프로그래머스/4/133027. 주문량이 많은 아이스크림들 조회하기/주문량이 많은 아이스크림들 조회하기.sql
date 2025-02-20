select flavor from (
    select * from first_half
    union all
    select * from july
) as merge
group by flavor
order by sum(total_order) desc
limit 3