-- 2. Write a PL/SQL block to accept a number and print its multiplication table :
SET SERVEROUTPUT ON;
DECLARE
n NUMBER;
result NUMBER;
BEGIN
  dbms_output.put_line('Enter the number for the table printing :');
  n := &n;
  for i in 1..10 loop 
    result := i*n;
    dbms_output.put_line(n || ' * ' || i || ' = ' || result);
  end loop;
END;
/