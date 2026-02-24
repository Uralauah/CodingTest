select id,
    case 
        when per_size <=0.25 then 'CRITICAL'
        when per_size <=0.5 then 'HIGH'
        when per_size <= 0.75 then 'MEDIUM'
        else 'LOW' 
    end as colony_name
from (
    select id, size_of_colony, percent_rank()over(order by size_of_colony desc) as per_size
    from ecoli_data) as percent_table
order by id asc