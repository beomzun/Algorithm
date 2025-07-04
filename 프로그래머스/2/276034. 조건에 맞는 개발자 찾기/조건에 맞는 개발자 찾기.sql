# -- 코드를 작성해주세요
# select id,email,first_name,last_name from developers
# where skill_code & (
#     select sum(code) from skillcodes
#     where name in ("Python","C#")
# )
# order by id asc

select id, email, first_name, last_name
from developers
where skill_code & (
    select sum(code)
    from skillcodes
    where name in ('Python', 'C#')
) > 0
order by id asc

# DEVELOPERS 테이블에서
# Python이나 C# 스킬을 가진 개발자의 정보를 조회하려 합니다.
# 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.
# 결과는 ID를 기준으로 오름차순 정렬해 주세요.