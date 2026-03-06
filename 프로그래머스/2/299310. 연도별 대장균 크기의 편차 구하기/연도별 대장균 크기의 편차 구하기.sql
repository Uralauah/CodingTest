-- 코드를 작성해주세요
with maxSize as (
    select year(differentiation_date) as year,max(size_of_colony) as size
    from ecoli_data
    group by year
)

select year(e.differentiation_date) as year, (m.size - e.size_of_colony) as year_dev, e.id
from ecoli_data e
join maxSize m
on year(e.differentiation_date) = m.year
order by year asc, year_dev asc