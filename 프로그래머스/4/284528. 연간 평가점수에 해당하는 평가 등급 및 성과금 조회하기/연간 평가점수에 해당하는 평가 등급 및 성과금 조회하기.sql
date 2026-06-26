with scores as(
    select 
        e.emp_no, 
        e.emp_name,
        case
            when avg(g.score) >= 96 then 'S'
            when avg(g.score) >= 90 then 'A'
            when avg(g.score) >= 80 then 'B'
            else 'C'
        END as grade,
        e.sal
    from hr_employees e
    join hr_grade g
    on e.emp_no = g.emp_no
    group by e.emp_no, e.emp_name, e.sal
)
select
    emp_no,
    emp_name,
    grade,
    case grade
        when 'S' then sal*0.2
        when 'A' then sal*0.15
        when 'B' then sal*0.1
        else 0
    end as bonus
from scores
order by emp_no asc