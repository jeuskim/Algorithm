-- 코드를 입력하세요
WITH CarRentalCounts AS (
    -- Step 1: Identify cars with total rentals >= 5 within the specified period
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
),
MonthlyRentalCounts AS (
    -- Step 2: Calculate monthly rental counts for each car that meets the criteria
    SELECT
        EXTRACT(MONTH FROM START_DATE) AS MONTH,
        CAR_ID,
        COUNT(*) AS RECORDS
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE CAR_ID IN (SELECT CAR_ID FROM CarRentalCounts)
      AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY EXTRACT(MONTH FROM START_DATE), CAR_ID
)
-- Step 3: Final query to select and sort the results
SELECT
    MONTH,
    CAR_ID,
    RECORDS
FROM MonthlyRentalCounts
ORDER BY MONTH ASC, CAR_ID DESC;
