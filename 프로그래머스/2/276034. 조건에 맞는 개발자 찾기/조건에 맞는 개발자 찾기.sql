select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
WHERE SKILL_CODE &(SELECT CODE
                   FROM SKILLCODES
                   WHERE NAME = 'Python')
                   or SKILL_CODE &(SELECT CODE
                                   FROM SKILLCODES
                                   WHERE NAME = 'C#'
                   )
ORDER BY ID;