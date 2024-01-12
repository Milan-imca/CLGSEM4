-- 10. Write a PL/SQL block to find volume of cube.
set serveroutput on;
declare
side NUMBER;
volume NUMBER;
begin
  dbms_output.put_line('Enter side of a square :');
  side := &side;
  volume := side * side * side;
  dbms_output.put_line('Volume of square is : ' || volume);
end;
/