with recursive hours as(
    select 0 as h
    union all
    select h + 1 from hours
    where h < 23
)
select hr.h, count(ao.animal_id) as count
from hours hr
left join animal_outs ao
on hr.h = hour(ao.datetime)
group by hr.h
order by hr.h