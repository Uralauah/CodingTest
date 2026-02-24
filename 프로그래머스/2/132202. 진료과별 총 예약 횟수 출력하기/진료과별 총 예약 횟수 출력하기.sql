SELECT mcdp_cd as '진료과 코드', count(*) as '5월예약건수'
from appointment
where year(APNT_YMD) = 2022 and month(APNT_YMD) = 5
group by mcdp_cd
order by count(*) asc, mcdp_cd asc