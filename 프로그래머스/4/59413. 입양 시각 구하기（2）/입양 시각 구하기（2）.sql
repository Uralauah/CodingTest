with recursive hours as(
    select 0 as hr
    union all
    select hr + 1 from hours where hr < 23
)
select h.hr as hour, count(a.datetime) as count
from hours h
left join animal_outs a
on h.hr = hour(a.datetime)
group by h.hr
order by h.hr asc