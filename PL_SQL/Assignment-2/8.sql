-- 8. Write a PL/SQL block Write a program to print the following series;
--  *
--  * *
--  * * *
--  * * * *
--  * * * * *
--  * * * * * *
set serveroutput on;
declare
row number := 6;
begin
  for i in 1..row loop 
    for j in 1..i loop 
      dbms_output.put('*' || ' ');
    end loop;
    dbms_output.put_line('');
  end loop;
end;
/