SET SERVEROUTPUT ON
BEGIN
  FOR i IN 1..5 
    LOOP 
      DBMS_OUTPUT.PUT_LINE('Milan');
    END LOOP;
END;
/


--PRINTING TABLE:

set serveroutput on
declare 
n NUMBER;
result NUMBER;
begin
  n := 2;
  for i in 1..10 
  loop 
    result := n * i;
    dbms_output.put_line(n || ' * ' || i || ' = ' || result);
  end loop;
end; 
/


--USER INPUT TABLE

declare
n NUMBER;
result NUMBER;
begin
  dbms_output.put_line('Enter the number for the table : ');
  n := &n;
  for i in 1..10 loop 
    result := n * i;
    dbms_output.put_line(n || ' * ' || i ||  ' = ' || result);
  end loop;
end;
/


declare 
result number := 0;
begin
  for i in 1..4 loop 
    result := i + result;
  end loop;
  dbms_output.put_line(result);
end;
/