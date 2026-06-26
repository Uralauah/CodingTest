with recursive generations as (
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
select id
from generations
where generation = 3
order by id asc