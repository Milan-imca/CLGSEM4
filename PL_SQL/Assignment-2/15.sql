-- 15. Write a PL/SQL block to Find the Sum of first 50 Natural Numbers using For Loop.
set serverouput on;
declare
result number := 0;
begin
  for i in 1..50 loop 
    result := result + i;
  end loop;
  dbms_output.put_line('Sum of 50 natural numbers is ' || result);
end;
/