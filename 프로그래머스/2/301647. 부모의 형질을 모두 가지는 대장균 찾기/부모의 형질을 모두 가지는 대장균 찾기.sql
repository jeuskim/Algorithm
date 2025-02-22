-- 코드를 작성해주세요
SELECT CH.ID, CH.GENOTYPE, PA.GENOTYPE AS PARENT_GENOTYPE
    FROM ECOLI_DATA AS CH
        INNER JOIN ECOLI_DATA AS PA
            ON CH.PARENT_ID = PA.ID
    WHERE PA.GENOTYPE & CH.GENOTYPE = PA.GENOTYPE
    ORDER BY ID ASC;