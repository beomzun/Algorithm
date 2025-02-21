select sum(score) as score ,emp_no,emp_name,position,email
from hr_employees left join hr_grade using(emp_no)
group by emp_no
order by score desc
limit 1