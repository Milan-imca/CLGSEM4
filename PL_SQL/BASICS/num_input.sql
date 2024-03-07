SET SERVEROUTPUT ON
DECLARE
num NUMBER;
BEGIN
  num:='&number_input';
  dbms_output.put_line('You entered : ' || num);
END;
/