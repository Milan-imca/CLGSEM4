declare
n NUMBER := 1;
begin
  while (n<=5) loop 
    dbms_output.put_line(n);
    n := n + 1;
  end loop;
end;
/

