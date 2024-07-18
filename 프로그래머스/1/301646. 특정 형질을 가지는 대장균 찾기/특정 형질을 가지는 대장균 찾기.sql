-- 코드를 작성해주세요
SELECT COUNT(*) AS 'COUNT'
    FROM ECOLI_DATA
    WHERE (((GENOTYPE % 8) % 4) DIV 2) = 0 AND
            (   ((GENOTYPE % 8 ) DIV 4) = 1 OR
                (((GENOTYPE % 8) % 4) % 2) = 1  ) ;