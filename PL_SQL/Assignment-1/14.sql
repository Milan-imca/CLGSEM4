-- 14. Write a PL/SQL block to accept number from user and find addition, subtraction, multiplication and division.
set serveroutput on;
declare
 num1 NUMBER := &num1;
 num2 NUMBER := &num2;
 add NUMBER;
 sub NUMBER;
 mul NUMBER;
 div NUMBER;
begin
  add := num1 + num2;
  sub := num1 - num2;
  mul := num1 * num2;
  div := num1 / num2;
  dbms_output.put_line('Addition :' || add);
  dbms_output.put_line('Subtraction :' || sub);
  dbms_output.put_line('Multiplication :' || mul);
  dbms_output.put_line('Division :' || div);
end;
/