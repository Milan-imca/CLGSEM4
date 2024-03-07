DECLARE
  age number:= 20;
  age_exception EXCEPTION;
BEGIN 
  IF age<18 THEN
    RAISE age_exception;
  ELSE
    DBMS_OUTPUT.PUT_LINE('You are eligible to vote!');
  END IF;
EXCEPTION
  WHEN age_exception THEN
    DBMS_OUTPUT.PUT_LINE('You are not eligible to vote');
END;
/




