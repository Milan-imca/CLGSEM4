-- 1. Write a PL/SQL block to accept marks of 3 subject as i/p and calculate
-- the total marks and division of a student
-- i) If totmark>=60 then division is First
-- ii) If totmark <60 and totmark>=50 then division is second
-- iii) If totmark< 50 and >=35 then division is third
-- iv) If totmark< 35 then fail. 

SET SERVEROUTPUT ON;
DECLARE
    mark1 NUMBER := &mark1;
    mark2 NUMBER := &mark2;
    mark3 NUMBER := &mark3; 
    total_marks NUMBER;
BEGIN
    total_marks := mark1 + mark2 + mark3;
    IF(total_marks >= 60) THEN
      DBMS_OUTPUT.PUT_LINE('First Division');
    ELSIF(total_marks < 60 AND total_marks >= 50) THEN
      DBMS_OUTPUT.PUT_LINE('Second Division');
    ELSIF(total_marks < 50 AND total_marks >= 35) THEN
      DBMS_OUTPUT.PUT_LINE('Third Division');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Fail'); 
    END IF;
END;  
/