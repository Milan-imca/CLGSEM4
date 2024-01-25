set serveroutput on;
declare
num number := &num;
temp number := num;
result number := 0 ;
digit number;
begin
  while temp > 0 
  loop
    digit := mod(temp,10);
    result :=  result * 10 + digit;
    temp := trunc(temp/10);
  end loop;
  dbms_output.put_line('Reverse of ' || num  || ' is ' || result);

  if result=num then
  dbms_output.put_line('palindrome!');
  else
  dbms_output.put_line('not palindrome!');
  end if;
end;
/

set serveroutput on;
declare 
year number :='&year';
begin
if(mod(year,4)=0) then
dbms_output.put_line('leap year');
else
dbms_output.put_line('not leap');
end if;
end;
/