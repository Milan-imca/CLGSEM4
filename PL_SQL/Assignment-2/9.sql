-- 9. Write a PL/SQL block to display "GOOD MORNING" or "GOOD AFTERNOON" or "GOOD NIGHT" depending upon the current time:
set serveroutput on;
declare
curr_time number;
begin 
  curr_time := TO_NUMBER(TO_CHAR(SYSDATE,'HH24'));
  if curr_time >= 6 and curr_time < 12 then
   dbms_output.put_line('GOOD MORNING!');
  elsif curr_time >=12 and curr_time < 18 then
    dbms_output.put_line('GOOD EVENING!');
  else 
    dbms_output.put_line('GOOD NIGHT!');
  end if;
end;
/