-- 코드를 입력하세요
SELECT b.title as TITLE,
board_id as BOARD_ID,
reply_id as REPLY_ID,
r.writer_id as WRITER_ID, 
r.contents as CONTENTS,
Date_format(r.created_date, '%Y-%m-%d') as CREATED_DATE
from used_goods_board as b join used_goods_reply as r using (board_id)
where b.created_date between date'2022-10-01' and date'2022-10-31'+1
order by r.created_date asc, title asc