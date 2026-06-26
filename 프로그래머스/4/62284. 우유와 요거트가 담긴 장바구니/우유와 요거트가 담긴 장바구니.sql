select cart_id
from cart_products
group by cart_id
having 
    sum(case when name = 'Milk' then 1 else 0 end) > 0 and
    sum(case when name = 'Yogurt' then 1 else 0 end) > 0
order by cart_id