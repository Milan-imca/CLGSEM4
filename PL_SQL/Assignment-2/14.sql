-- 14. Write a PL/SQL block to check whether the blood donor is eligible or
-- not for donating blood. The conditions laid down are as under.
-- Use if statement.
-- a) Age should be above 18 yrs. but not more than 55 yrs.
-- b) Weight should be more than 45kgs.
set serverouput on;
declare
age number := &age;
weight number := &weight;
begin
  if age > 18 and age < 55 and weight > 45 then
    dbms_output.put_line('Eligible to donate blood!!');
  else
    dbms_output.put_line('Not Eligible to vote!!');
  end if;
end;
/