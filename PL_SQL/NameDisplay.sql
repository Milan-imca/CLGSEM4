SET SERVEOUTPUT ON
DECLARE
name VARCHAR2(50);
BEGIN
name:='Milan';
dbms_output.put_line('My name is : ' || name);
END;
/
