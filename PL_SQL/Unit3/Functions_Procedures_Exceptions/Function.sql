-- Creating a simple function--
create or replace function hello(name varchar2) return varchar2 is 
begin 
  return 'hello ' || name;
end;
/

-- => to execute function : 
begin
  dbms_output.put_line(hello('Milan'));
end;
/



-- creating a addition function
create or replace function addition(a number,b number) return number is 
sum_result number;
begin 
  sum_result := a+b;
  return sum_result;
end;
/ 


--executing function:
declare
a number := '&a';
b number := '&b';
ans number;
begin
  ans := addition(a,b);
  dbms_output.put_line(a || ' + ' || b || ' = ' || ans);
end;
/