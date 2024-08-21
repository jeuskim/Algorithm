-- 코드를 작성해주세요
SELECT 
    SUM(HG.SCORE) AS SCORE,
    HE.EMP_NO,
    HE.EMP_NAME,
    HE.POSITION,
    HE.EMAIL
FROM 
    HR_EMPLOYEES HE
JOIN 
    HR_GRADE HG 
ON 
    HE.EMP_NO = HG.EMP_NO
WHERE 
    HG.YEAR = 2022
GROUP BY 
    HE.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
HAVING 
    SUM(HG.SCORE) = (
        SELECT 
            MAX(TOTAL_SCORE)
        FROM 
            (SELECT 
                SUM(SCORE) AS TOTAL_SCORE
             FROM 
                HR_GRADE
             WHERE 
                YEAR = 2022
             GROUP BY 
                EMP_NO) AS TOTAL_SCORES
    )
ORDER BY 
    HE.EMP_NO;
