-- 코드를 작성해주세요
WITH RECURSIVE Generation AS (
    -- Base case: 최초의 대장균(1세대)
    SELECT ID, PARENT_ID, 1 AS GenerationLevel
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    -- Recursive case: 자식 대장균(다음 세대)
    SELECT e.ID, e.PARENT_ID, g.GenerationLevel + 1 AS GenerationLevel
        FROM ECOLI_DATA e
            INNER JOIN Generation g
                ON e.PARENT_ID = g.ID
)
-- 최종적으로 3세대 대장균을 선택하고 오름차순 정렬
SELECT ID
    FROM Generation
    WHERE GenerationLevel = 3
    ORDER BY ID ASC;