-- 13. Write a PL/SQL block to calculate the sum of 5 subject and find the percentage.
set serveroutput on;
declare
subject1_marks  NUMBER:= &subject1_marks;
subject2_marks NUMBER := &subject2_marks;
subject3_marks  NUMBER:= &subject3_marks;
subject4_marks  NUMBER:= &subject4_marks;
subject5_marks  NUMBER:= &subject5_marks;
total NUMBER ;
percentage NUMBER ;
begin
  total := subject1_marks + subject2_marks + subject3_marks + subject4_marks + subject5_marks;
  percentage := total / 5;
  dbms_output.put_line('TOTAL MARKS : ' || total);
  dbms_output.put_line('PERCENTAGE : ' || percentage);
end;
/
