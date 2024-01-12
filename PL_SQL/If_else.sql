-- DECLARE
-- char VARCHAR2(1);
-- BEGIN
--   char := '&char';
--   IF (char = 'a') THEN
--     dbms_output.put_line('user entered A');
--   ELSIF (char ='b') THEN
--     dbms_output.put_line('use entered B');
--   END IF;
-- END;
-- /


DECLARE
age NUMBER := &age;
BEGIN
  if(age > 18) THEN
  dbms_output.put_line('You can vote!');
  else
  dbms_output.put_line('You cannot vote!');
  end if;
END;
/