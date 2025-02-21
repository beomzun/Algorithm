select dept_id, dept_name_en, round(avg(sal),0) as avg_sal
from hr_employees left join hr_department using(dept_id)
group by dept_id
order by avg_sal desc