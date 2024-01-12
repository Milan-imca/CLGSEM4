-- 3. Write a PL/SQL block to accept a char and check it is vowel or consonant.
SET SERVEROUTPUT ON;
DECLARE
ch VARCHAR2(1);
BEGIN 
  dbms_output.put_line('Enter a character ');
  ch := '&ch';
  if ( ch = 'a' or ch = 'e' or ch = 'i' or ch = 'o' or ch = 'u') then
  dbms_output.put_line('Vowel');
  else 
  dbms_output.put_line('Consonant');
  end if;
END;
/
