SELECT 
    c.CAR_ID, 
    c.CAR_TYPE, 
    ROUND(c.DAILY_FEE * 30 * (1 - COALESCE(TO_NUMBER(REPLACE(p.DISCOUNT_RATE, '%', '')), 0) / 100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR c
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p 
    ON c.CAR_TYPE = p.CAR_TYPE 
    AND p.DURATION_TYPE = '30일 이상'
WHERE c.CAR_TYPE IN ('SUV', '세단')
AND c.CAR_ID NOT IN (
    SELECT CAR_ID 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE START_DATE <= TO_DATE('2022/11/30', 'YYYY/MM/DD') 
    AND END_DATE >= TO_DATE('2022/11/01', 'YYYY/MM/DD')
)
AND ROUND(c.DAILY_FEE * 30 * (1 - COALESCE(TO_NUMBER(REPLACE(p.DISCOUNT_RATE, '%', '')), 0) / 100)) 
    BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC;
