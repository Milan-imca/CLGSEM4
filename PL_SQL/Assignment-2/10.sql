-- 10. Write a PL/SQL block to accept the mgr and find how many emps are working under that mgr.
set serveroutput on;
declare
mgr_id number:= &mrg_id;
emp_count number;
begin 
  select count(*) into emp_count 
  from employee 
  where manager_id = mgr_id;
  dbms_output.put_line('Number of employees working under the manager are ' || emp_count);
end;
/

