-- 17. Write a PL/SQL block to calculate the sum of digits of a number entered through keyboard.

DECLARE
  num NUMBER := &num;
  digit NUMBER;
  sum_of_digits NUMBER := 0;

BEGIN
  WHILE num > 0 LOOP
    digit := MOD(num, 10);  -- Extract the last digit
    sum_of_digits := sum_of_digits + digit;
    num := trunc(num / 10);  -- Remove the last digit
  END LOOP;

  DBMS_OUTPUT.PUT_LINE('Sum of digits = ' || sum_of_digits);
END;
/