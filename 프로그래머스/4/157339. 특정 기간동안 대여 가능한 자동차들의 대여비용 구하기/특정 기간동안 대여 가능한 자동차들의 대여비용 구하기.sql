/*
CAR_RENTAL_COMPANY_CAR - 회사 소유 차량
CAR_RENTAL_COMPANY_RENTAL_HISTORY - 그동안의 렌트정보
CAR_RENTAL_COMPANY_DISCOUNT_PLAN - 렌트 시 가격 기준표

렌트정보에서 기간제외한 애들 중 -> 30일간의 대여요금이 맞는 애들
*/
select c.car_id, c.car_type, round(daily_fee*30*(100-p.discount_rate)/100*1) as fee
from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on c.car_type=p.car_type and p.duration_type="30일 이상"
where c.car_id not in (
    select h.car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.start_date between "2022-11-01" and "2022-11-30"
    or h.end_date between "2022-11-01" and "2022-11-30"
    or h.start_date<"2022-11-01" and h.end_date>"2022-11-30"
) and round(daily_fee*30*(100-p.discount_rate)/100*1) between 500000 and 1999999
# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY