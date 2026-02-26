-- 코드를 작성해주세요
select sum(g.score) as score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e
join hr_grade g
on e.emp_no = g.emp_no
where g.year = 2022
group by e.emp_no
having sum(g.score) = (
    select max(total_score)
    from (
        select sum(score) as total_score
        from hr_grade
        group by emp_no
    ) t
)