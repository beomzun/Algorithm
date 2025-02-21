select count(*) as fish_count, max(length) as max_length, fish_type
from (
    select fish_type,ifnull(length,10) as length
    from fish_info
) as info
group by fish_type
having avg(length)>=33
order by fish_type asc

# SELECT COUNT(ID) AS FISHCOUNT, MAX(LENGTH) AS MAXLENGTH, FISHTYPE
# FROM (
#     SELECT ID, FISHTYPE, IFNULL(LENGTH, 10) AS LENGTH FROM FISHINFO
# ) AS INFO
# GROUP BY FISHTYPE
# HAVING AVG(LENGTH) >= 33
# ORDER BY FISH_TYPE;