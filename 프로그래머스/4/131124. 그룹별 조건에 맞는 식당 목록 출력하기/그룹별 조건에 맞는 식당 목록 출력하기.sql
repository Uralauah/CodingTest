-- 코드를 입력하세요
WITH x as(
    select member_id, RANK() OVER(order by count(member_id) desc) as ranking
    from rest_review
    group by member_id
)

select p.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as review_date
from member_profile p
join x
using (member_id)
join rest_review r
on p.member_id = r.member_id
where x.ranking = 1
order by review_date asc, review_text asc