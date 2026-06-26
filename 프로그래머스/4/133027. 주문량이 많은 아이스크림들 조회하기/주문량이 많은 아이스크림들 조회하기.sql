with sales as(
    select 
        f.shipment_id, 
        f.flavor, 
        (f.total_order+ sum(j.total_order)) as total_order,
        row_number() over (order by (f.total_order+ sum(j.total_order)) desc) as rnk
    from first_half f
    join july j
    on f.flavor = j.flavor
    group by f.shipment_id, f.flavor
)

select flavor
from sales
where rnk <=3
order by rnk asc
