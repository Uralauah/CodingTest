-- 코드를 입력하세요
with recursive hour as(
    select 9 as h
    union all
    select h + 1 from hour
    where h < 19
)
select hr.h, count(ao.animal_id) as count
from hour hr
left join animal_outs ao
on hr.h = hour(ao.datetime)
group by hr.h
order by hr.h