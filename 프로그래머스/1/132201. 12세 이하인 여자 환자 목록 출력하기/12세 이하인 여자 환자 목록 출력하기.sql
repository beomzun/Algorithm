# -- 코드를 입력하세요
# SELECT pt_name, pt_no, gend_cd, age, ifnull(tlno, 'NONE') as tlno
# from patient
# where age <= 12 and gend_cd = 'w'
# order by age desc, pt_name asc

select pt_name, pt_no, gend_cd, age, ifnull(tlno, 'NONE') as tlno
from patient
where age<=12 and gend_cd='W'
order by age desc, pt_name asc


# PATIENT 테이블에서
# 12세 이하인 여자환자의 
# 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회하는 SQL문을 작성해주세요. 
# 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고 
# 결과는 나이를 기준으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬해주세요.