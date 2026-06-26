with recursive generations as(
    select
        id,
        parent_id,
        1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select
        e.id,
        e.parent_id,
        g.generation + 1 as generation
    from ecoli_data e
    join generations g
    on e.parent_id = g.id
)
select count(g.id) as count, g.generation
from generations g
left join ecoli_data e
on g.id = e.parent_id
where e.parent_id is null
group by g.generation
order by generation