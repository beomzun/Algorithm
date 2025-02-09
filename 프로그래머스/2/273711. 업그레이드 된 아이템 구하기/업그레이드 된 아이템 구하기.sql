-- 코드를 작성해주세요
select item_id, item_name, rarity from item_info
where item_id in (
    select item_id from item_tree
    where parent_item_id in (
        select item_id from item_info where rarity="RARE"
    )
)
order by item_id desc
/*
아이템 테이블에서 rare인 id 추출 -> 트리의 parent가 이 id인 아이템id 추출 -> 아이템 테이블에서 결론
*/