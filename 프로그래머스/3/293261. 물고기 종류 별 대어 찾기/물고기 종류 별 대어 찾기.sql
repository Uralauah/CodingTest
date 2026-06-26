-- 코드를 작성해주세요
select fi.id, fn.fish_name, fi.length
from (
    select id, fish_type, length, rank() over
                                    (partition by fish_type
                                    order by length desc) as rnk
    from fish_info) fi
join fish_name_info fn
on fi.fish_type = fn.fish_type
where fi.rnk = 1
order by fi.id asc;
