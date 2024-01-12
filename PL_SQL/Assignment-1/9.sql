-- 9. Write a PL/SQL block to accept the cost price and selling price of an item and find the loss or profit.
set serveroutput on;
declare
cost_price NUMBER := &cost_price;
selling_price NUMBER := &selling_price;
loss_profit NUMBER; 
begin
  loss_profit := selling_price - cost_price;
  if (loss_profit > 0) then
    dbms_output.put_line('Profit ' || loss_profit);
  else
    dbms_output.put_line('Loss ' || loss_profit);
  end if;
end;
/