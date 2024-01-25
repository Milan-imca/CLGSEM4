set serveroutput on;
declare
num number := &num;
temp number := num;
result number := 0;
digit number;
begin 
  while temp > 0 
  loop
  digit := mod(temp,10);
  result := result + (digit * digit * digit);
  temp := trunc(temp/10);
  end loop;
  
  if result=num then
  dbms_output.put_line('is armstrong!');
  else
    dbms_output.put_line('is not armstrong!');
  end if;
end;
/