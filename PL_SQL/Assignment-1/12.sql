-- 12. Write a PL/SQL block to convert length in feet to centimetre.
set serveroutput on;
declare
feet NUMBER := &feet;
centimetre NUMBER;
begin
  centimetre := feet * 30.48;
  dbms_output.put_line('Length in centimeter : ' || centimetre);
end; 
/