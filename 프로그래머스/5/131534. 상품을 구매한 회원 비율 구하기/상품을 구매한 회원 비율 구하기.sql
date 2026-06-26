with joined as (
    select user_id
    from user_info
    where year(joined) = '2021'
),
sales as(
    select count(distinct user_id) as purchased_users, year(sales_date) as year, month(sales_date) as month
    from online_sale
    where user_id in (
        select user_id
        from joined
    )
    group by year, month
)

select year, month, purchased_users, round(purchased_users/(select count(*) from joined), 1) as purchased_ratio
from sales
