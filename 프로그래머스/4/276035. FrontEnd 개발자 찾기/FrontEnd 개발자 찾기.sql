select d.id,d.email,d.first_name,d.last_name from developers d
where d.skill_code & (
    select sum(s.code) from skillcodes s where category="front end"
) > 0
order by d.id asc