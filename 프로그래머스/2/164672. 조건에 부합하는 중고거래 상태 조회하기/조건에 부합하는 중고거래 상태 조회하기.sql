-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, case
    when status = 'DONE' then '거래완료'
    when status = 'RESERVED' then '예약중'
    when status = 'SALE' then '판매중'
    end status
from used_goods_board
where created_date >= '2022-10-05' and created_date < '2022-10-06'
order by board_id desc