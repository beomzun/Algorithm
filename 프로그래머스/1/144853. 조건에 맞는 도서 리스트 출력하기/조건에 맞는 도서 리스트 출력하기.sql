# -- 코드를 입력하세요
# SELECT book_id, date_format(published_date, '%Y-%m-%d') as published_date from book
# where category = '인문' and year(published_date)= '2021'
# order by published_date asc

select book_id, date_format(published_date,'%Y-%m-%d') as published_date
from book
where year(published_date)='2021' and category = '인문'
order by published_date asc

# BOOK 테이블에서 
# 2021년에 출판된 
# '인문' 카테고리에 속하는 도서 리스트를 찾아서 
# 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력하는 SQL문을 작성해주세요.
# 결과는 출판일을 기준으로 오름차순 정렬해주세요.