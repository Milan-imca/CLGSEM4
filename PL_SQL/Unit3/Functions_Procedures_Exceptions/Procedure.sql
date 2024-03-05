--Printing hello using procedure
create or replace procedure hello_world is 
begin
  dbms_output.put_line('hello world');
end;
/

--TO execute the above code use 
-- execute hello_world or exec hello_world (in terminal and then hit enter)


-- Creating add_numbers PROCEDURE with parameters
CREATE OR REPLACE PROCEDURE add_numbers(
  num1 IN NUMBER,
  num2 IN NUMBER,
  result OUT NUMBER
)
IS
BEGIN
  result := num1+num2;
END;
/

-- Creating another block to execute the procedure add_numbers above ☝🏻
DECLARE
a NUMBER := '&a'; 
b NUMBER := '&b'; 
sum_result NUMBER; 
BEGIN 
  add_numbers(a,b,sum_result);
  DBMS_OUTPUT.PUT_LINE('The sum of ' || a || ' and ' || b || ' is ' || sum_result);
END;
/
