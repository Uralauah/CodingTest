with history as (
    select 
        c.car_type, 
        h.history_id, 
        c.daily_fee,
        (datediff(h.end_date, h.start_date) + 1) as duration
    from car_rental_company_car c
    join car_rental_company_rental_history h
    on c.car_id = h.car_id
    where c.car_type = '트럭'
),
truck as (
    select duration_type, discount_rate
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where car_type = '트럭'
)

select 
    h.history_id,
    floor(
        h.daily_fee * h.duration * ( 100 -
            case 
                when duration >= 90 then (select discount_rate from truck where duration_type = '90일 이상')
                when duration >= 30 then (select discount_rate from truck where duration_type = '30일 이상')
                when duration >= 7 then (select discount_rate from truck where duration_type = '7일 이상')
                else 0
            end) / 100
    ) as fee
from history h
order by fee desc, h.history_id desc