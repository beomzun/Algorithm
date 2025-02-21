select count(*) as fish_count, max(length) as max_length, fish_type
from fish_info
where fish_type in (
    select fish_type from (
        select fish_type,avg(length) as avg_length
        from (
            select id,fish_type,
            case
                when length is null then 10
                else length
            end as length
            from fish_info
        ) as base
        group by fish_type
    ) as sec
    where avg_length >=33
)
group by fish_type
order by fish_type asc