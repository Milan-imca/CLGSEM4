DECLARE
no number := &no;
i number;
is_prime boolean := true;
begin
  if no<=1 then
    is_prime := false;
  else
    for i in 2..round(sqrt(no)) loop
        if(mod(no,i) = 0) then
          is_prime := false;
        end if;
    end loop;
  end if;
  if(is_prime) then
  dbms_output.put_line('PRim no');
  else
  dbms_output.put_line('not prime no');
  end if;
end;
/