# -- 코드를 작성해주세요
# select item_id, item_name, rarity from item_info
# where item_id in (
#     select item_id from item_tree
#     where parent_item_id in (
#         select item_id from item_info where rarity="RARE"
#     )
# )
# order by item_id desc
# /*
# 아이템 테이블에서 rare인 id 추출 -> 트리의 parent가 이 id인 아이템id 추출 -> 아이템 테이블에서 결론
# */

select item_id, item_name, rarity
from item_info
where item_id in (
    select item_id
    from item_tree
    where parent_item_id in (
        select item_id from item_info where rarity='RARE'
    )
)
order by item_id desc

# 아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템의
# 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)를 출력하는 SQL 문을 작성해 주세요. 
# 이때 결과는 아이템 ID를 기준으로 내림차순 정렬주세요.

#희귀도가 rare인 아이템의 id를 부모id로 갖고있는 애들의 정보