-- 7. Write a PL/SQL block tWrite a program to print the following series
--  1
--  1 2
--  1 2 3
--  1 2 3 4
--  1 2 3 4 5

set serveroutput on;
declare
row number := 5;
begin 
  for i in 1..row loop 
    for j in 1..i loop 
      dbms_output.put(j || ' ');
    end loop;
    dbms_output.put_line('');
  end loop;
end;
/