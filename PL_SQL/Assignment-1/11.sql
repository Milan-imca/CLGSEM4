-- 11. Write a PL/SQL block to convert temperature from Fahrenheit to Degree Celsius.
set serveroutput on;
declare
temp NUMBER;
celcius NUMBER;
begin
  dbms_output.put_line('Enter the temperature in Fahrenheit : ');
  temp := &temp;
  celcius := (temp - 32) * 5/9;
  dbms_output.put_line('Temperature : ' || celcius || ' Celcius');
end;
/