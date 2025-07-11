# -- 코드를 작성해주세요
# select count(*) as count from ecoli_data
# where (genotype&1=1 or genotype&4=4) and genotype&2=0

select count(*) as count
from ecoli_data
where genotype&2=0 and (genotype&1=1 or genotype&4=4)

# 2번 형질이 보유하지 않으면서 1번이나 3번 형질을 보유하고 있는 대장균 개체의 수(COUNT)를 출력하는 SQL 문을 작성해주세요.
# 1번과 3번 형질을 모두 보유하고 있는 경우도 1번이나 3번 형질을 보유하고 있는 경우에 포함합니다.