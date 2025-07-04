-- 코드를 작성해주세요
select p.item_id, item_name, rarity
from item_info as p left join item_tree as c on p.item_id=c.parent_item_id
where c.item_id is null
order by p.item_id desc

# 더 이상 업그레이드할 수 없는 아이템의 = 내가 부모가 아닌
# 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 
# 이때 결과는 아이템 ID를 기준으로 내림차순 정렬해 주세요.