# -- 코드를 입력하세요
# SELECT dr_name, dr_id, mcdp_cd, date_format(hire_ymd, '%Y-%m-%d') as hire_ymd
# from doctor
# where mcdp_cd in ('CS','GS')
# order by hire_ymd desc, dr_name asc

select dr_name, dr_id, mcdp_cd, date_format(hire_ymd,'%Y-%m-%d')
from doctor
where mcdp_cd in ('CS','GS')
order by hire_ymd desc, dr_name asc

# DOCTOR 테이블에서
# 진료과가 흉부외과(CS)이거나 일반외과(GS)인
# 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문을 작성해주세요.
# 이때 결과는 고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬해주세요.