-- 코드를 작성해주세요
with Q as(
    select case 
        when month(differentiation_date) >= 1 and month(differentiation_date) <4 then '1Q'
        when month(differentiation_date) >= 4 and month(differentiation_date) <7 then '2Q'
        when month(differentiation_date) >= 7 and month(differentiation_date) <10 then '3Q'
        else '4Q'
        end as quarter,
        id
    from ecoli_data
)

select q.quarter, count(q.quarter) as ecoli_count
from ecoli_data e
join Q q
on e.id = q.id
group by q.quarter
order by q.quarter asc