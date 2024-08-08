-- 코드를 입력하세요
SELECT  b.CATEGORY,
        SUM(bs.SALES) AS TOTAL_SALES
    FROM BOOK_SALES bs
        JOIN BOOK b
            ON bs.BOOK_ID = b.BOOK_ID
    WHERE   bs.SALES_DATE >= '2022-01-01' AND
            bs.SALES_DATE <= '2022-01-31'
    GROUP BY b.CATEGORY
    ORDER BY b.CATEGORY;
