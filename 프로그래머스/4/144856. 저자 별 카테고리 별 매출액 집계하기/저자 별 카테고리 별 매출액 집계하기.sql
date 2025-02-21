select author_id, author_name, category, total_sales
from author right join (
    select book_id,category,author_id, sum(price*sales) as total_sales from book left join (
        select book_id, sum(sales) as sales from book_sales
        where sales_date between "2022-01-01" and "2022-01-31"
        group by book_id
    ) as sale_info using(book_id)
    group by author_id,category
) as total_info using(author_id)
order by author_id asc, category desc
/*
판매집계 -> 북id로 카테고리 확인 -> 작가id로 이름확인
*/