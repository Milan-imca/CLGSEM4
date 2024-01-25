set serveroutput on;
declare 
o_str varchar2(10):= 'Milan';
r_str varchar2(10);
begin
  for i in reverse 1..length(o_str)
  loop
    r_str := r_str || substr(o_str,i,1);
  end loop;
  dbms_output.put_line('Oringal string : ' || o_str);
  dbms_output.put_line('Reverse  string : ' || r_str);
end;
/

insert into stu (stu_id,stu_name,stu_marks) values (1,'milan',99);
insert into stu (stu_id,stu_name,stu_marks) values (2,'ashish',97);


set serveroutput on;
declare
begin
  delete from stu where stu_name='harshil';
end;
/