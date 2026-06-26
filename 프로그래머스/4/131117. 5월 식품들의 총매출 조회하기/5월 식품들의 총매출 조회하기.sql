select p.product_id, p.product_name, sum(p.price * o.amount) as total_sales
from food_product p
join food_order o
on p.product_id = o.product_id
where o.produce_date >= '2022-05-01' and o.produce_date < '2022-06-01'
group by p.product_id
order by total_sales desc, product_id asc