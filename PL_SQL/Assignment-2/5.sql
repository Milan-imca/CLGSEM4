-- 5. Write a PL/SQL block that while purchasing certain items,discount of
-- each is as follows
-- i) If qty purchased > 1000 discount is 20%
-- ii) If the qty and price per item are i/p then calculate the expenditure.

set serveroutput on;
declare 
item_quantity number:= &item_quantity;
price number:= &price;
discount number := 0;
expenditure number := 0;
begin
  if (item_quantity > 1000) then
    discount := 0.2;
  end if;
  expenditure := item_quantity * price * (1-discount);
  dbms_output.put_line('Expenditure : ' || expenditure);
end;
/