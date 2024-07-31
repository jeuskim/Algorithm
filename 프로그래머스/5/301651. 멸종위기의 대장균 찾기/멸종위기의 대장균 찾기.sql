-- 코드를 작성해주세요
WITH RECURSIVE GenerationTree AS (
    -- 최초 세대(부모가 없는 개체들)를 설정합니다.
    SELECT  ID,
            PARENT_ID,
            1 AS GENERATION
        FROM    ECOLI_DATA
        WHERE   PARENT_ID IS NULL
    
    UNION ALL
    
    -- 재귀적으로 각 개체의 세대를 계산합니다.
    SELECT  e.ID,
            e.PARENT_ID,
            gt.GENERATION + 1 AS GENERATION
        FROM    ECOLI_DATA e
            JOIN    GenerationTree gt ON e.PARENT_ID = gt.ID
),
LeafNodes AS (
    -- 각 세대별 자식이 없는 개체를 식별합니다.
    SELECT  gt.ID,
            gt.GENERATION
        FROM    GenerationTree gt
            LEFT JOIN   ECOLI_DATA e
                ON gt.ID = e.PARENT_ID
        WHERE   e.ID IS NULL
)
-- 세대별 자식이 없는 개체의 수를 집계하고 결과를 출력합니다.
SELECT  COUNT(*) AS COUNT,
        GENERATION
    FROM    LeafNodes
    GROUP BY    GENERATION
    ORDER BY    GENERATION;
