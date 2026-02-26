-- 코드를 입력하세요
SELECT FLOOR(price/10000)*10000 as PRICE_GROUP, count(product_id) as PRODUCTS
from product
group by floor(price/10000) * 10000
order by price_group asc