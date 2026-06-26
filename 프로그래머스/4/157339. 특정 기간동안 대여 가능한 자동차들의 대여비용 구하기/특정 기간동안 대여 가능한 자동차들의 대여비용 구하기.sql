with unavailable_date as (
    select car_id
    from car_rental_company_rental_history
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
),
available as(
    select car_id, car_type, daily_fee
    from car_rental_company_car
    where car_id not in (select car_id from unavailable_date) and car_type in ('SUV', '세단')
),
discount_fee as(
    select 
        a.car_id, 
        a.car_type, 
        floor(a.daily_fee * 30 * (100-p.discount_rate) / 100) as fee
    from available a
    join car_rental_company_discount_plan p
    on a.car_type = p.car_type
    where p.duration_type = '30일 이상'
)

select car_id, car_type, fee
from discount_fee
where fee >= 500000 and fee < 2000000
order by fee desc, car_type asc, car_id desc