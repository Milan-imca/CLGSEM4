-- 4. Write a PL/SQL block to accept a year and check whether it is leap year or not .
set serveroutput on;
DECLARE
year number:= &year;
begin
  if ((mod(year,4)) = 0) then
    dbms_output.put_line('Leap year');
  else
    dbms_output.put_line('Not a leap year!');
  end if;
end;
/