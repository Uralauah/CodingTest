with books as (
    select 
        b.category as category, 
        (b.price * bs.sales) as price,
        b.author_id as author_id
    from book b
    join book_sales bs
    on b.book_id = bs.book_id
    where bs.sales_date >= '2022-01-01' and bs.sales_date < '2022-02-01'
)
SELECT 
    a.author_id as author_id,
    a.author_name as author_name,
    b.category as category,
    sum(b.price) as total_sales
from author a
join books b
on a.author_id = b.author_id
group by author_id, category
order by author_id asc, category desc