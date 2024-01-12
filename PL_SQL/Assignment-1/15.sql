-- 15. Write a program to calculate the area of a triangle by accepting the sides.
set serveroutput on;
declare
    side1 NUMBER := &side1_input;
    side2 NUMBER := &side2_input;
    side3 NUMBER := &side3_input;
    s NUMBER;
    area NUMBER;
begin
    s := (side1 + side2 + side3) / 2;
    area := SQRT(s * (s - side1) * (s - side2) * (s - side3));
    dbms_output.put_line('Area of the triangle: ' || area);
end;
/