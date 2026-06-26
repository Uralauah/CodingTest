-- 코드를 입력하세요
SELECT 
    year(s.sales_date) as year, 
    month(s.sales_date) as month, 
    u.gender as gender,
    count(distinct u.user_id) as users
from online_sale s
join user_info u
on s.user_id = u.user_id
where u.gender is not null
group by year,month,gender
order by year asc, month asc, gender asc