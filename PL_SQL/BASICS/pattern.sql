-- declare
-- row NUMBER := 5;
-- i NUMBER := 1;
-- j NUMBER := 1;
-- begin
--   for i in 1..row loop 
--     for j in 1..i loop 
--       dbms_output.put('*');
--     end loop;
--     dbms_output.put_line('');
--   end loop;
-- end;
-- /


-- 1
-- 12
-- 123
-- 1234
-- 12345


declare
row number := 5;
i number;
j number;
begin
  for i in 1..row loop 
    for j in 1..i loop
      dbms_output.put(i || ' ');
    end loop;
    dbms_output.put_line('');
  end loop;
end;
/

-- MILAN
-- M
-- MI
-- MIL
-- MILA 
-- MILAN
declare
  word VARCHAR2(6) := 'MILAN';
  i NUMBER;
  j NUMBER;
begin
  for i in 1..length(word) loop
    for j in 1..i loop
      dbms_output.put(substr(word,j,1));
    end loop;
    dbms_output.put_line('');
  end loop;
end;
/

