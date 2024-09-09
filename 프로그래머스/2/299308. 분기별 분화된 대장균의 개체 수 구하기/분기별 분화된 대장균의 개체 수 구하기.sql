SELECT CONCAT(CEIL(MONTH(DIFFERENTIATION_DATE) / 3), "Q") AS QUARTER, COUNT(ID) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER