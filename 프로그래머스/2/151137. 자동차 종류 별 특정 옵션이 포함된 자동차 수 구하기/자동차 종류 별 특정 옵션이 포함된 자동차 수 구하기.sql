-- 코드를 입력하세요
SELECT car_type, count(*) AS cars
FROM car_rental_company_car
WHERE options REGEXP '가죽시트|열선시트|통풍시트'
GROUP BY car_type
ORDER BY car_type ASC;