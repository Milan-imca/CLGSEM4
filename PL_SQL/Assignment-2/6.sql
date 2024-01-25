-- 6. Write a PL/SQL block to accept a string and print in the following format
-- O
-- OR
-- ORA
-- ORAC
-- ORACL
-- ORACLE
set serveroutput on;
declare
word VARCHAR2(10) := 'HARSHIL';
word_length NUMBER ;
i NUMBER;
begin
  word_length := length(word);
  for i in 1..word_length loop
    dbms_output.put_line(substr(word,1,i));
  end loop;
end;
/