-- 코드를 입력하세요
SELECT category, sum(s.sales) as total_sales
from book b
join book_sales s
on b.book_id = s.book_id
where year(s.sales_date) = 2022
and month(s.sales_date) = 1
group by category
order by category asc