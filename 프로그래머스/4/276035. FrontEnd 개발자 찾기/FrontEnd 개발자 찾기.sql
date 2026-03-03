-- 코드를 작성해주세요
with f as(
    select s.code
    from skillcodes s
    where s.category = 'Front End'
)

select distinct d.id, d.email, d.first_name, d.last_name
from developers d
join f
on d.skill_code & f.code > 0
order by d.id asc