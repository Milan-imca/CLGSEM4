-- 11. Write a PL/SQL block to accept the empno and update the employee
-- row on the following
-- If sal < 2600 then sal=sal+10% of sal make the changes in the emp
-- table:
set serveroutput on;
declare
empno number := &empno;
sal number;
begin 
  select salary into sal
  from employee
  where emp_no = empno;
  if sal < 2600 then
    sal := sal + (sal * 0.1);
    update employee
    set salary = sal
    where emp_no = empno;
    dbms_output.put_line('Update  Succcess!!');
  else
    dbms_output.put_line('Update unsuccessfull!!');
  end if;
end;
/