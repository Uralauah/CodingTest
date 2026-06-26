select ao.animal_id, ao.name
from animal_outs ao
join animal_ins ai
on ao.animal_id = ai.animal_id
order by datediff(ao.datetime, ai.datetime) desc
limit 2