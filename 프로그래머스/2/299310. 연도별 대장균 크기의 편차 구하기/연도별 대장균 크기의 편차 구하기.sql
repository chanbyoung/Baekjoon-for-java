WITH MAX_COLONY AS(
    SELECT MAX(SIZE_OF_COLONY) AS MAX_SIZE, YEAR(DIFFERENTIATION_DATE) AS YEAR
    FROM ECOLI_DATA
    GROUP BY YEAR
)

SELECT MS.YEAR AS YEAR, (MS.MAX_SIZE - ED.SIZE_OF_COLONY) AS YEAR_DEV, ED.ID AS ID
FROM MAX_COLONY AS MS, ECOLI_DATA AS ED
WHERE YEAR(DIFFERENTIATION_DATE) = MS.YEAR
ORDER BY MS.YEAR, YEAR_DEV