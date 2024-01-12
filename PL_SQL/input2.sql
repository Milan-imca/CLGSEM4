set serveroutput ON
DECLARE
name varchar2(10) := '&name';
age number := &age;
BEGIN
dbms_output.put_line('Welcome ' || name || '!');
dbms_output.put_line('Your age is ' || age);
end;
/