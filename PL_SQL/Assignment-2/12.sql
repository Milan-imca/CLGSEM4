-- 12. Write a PL/SQL block to accept the empno and print all the details of emp,dept and salgrade.
set serveroutput on;
declare
empno number := &empno;
id number;
name varchar2(50);
m_id number;
begin
  select emp_no,e_name,manager_id into id,name,m_id 
  from employee
  where emp_no = empno;

  dbms_output.put_line('Emp no :' || id);
  dbms_output.put_line('Emp name :' || name);
  dbms_output.put_line('Manager id  :' || m_id);
end;
/
