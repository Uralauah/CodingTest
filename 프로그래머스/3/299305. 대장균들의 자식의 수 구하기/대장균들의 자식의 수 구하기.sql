select e.id, count(d.id) as child_count
from ecoli_data e left join ecoli_data d
on e.id = d.parent_id
group by e.id
order by e.id asc
