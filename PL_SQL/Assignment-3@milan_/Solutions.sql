1.Write a procedure to display employee details whose department is 'it' and designation is 'manager'.


CREATE OR REPLACE PROCEDURE emp_it_manager AS
BEGIN
    FOR emp IN (SELECT * FROM EMPLOYEE WHERE department='it' AND designation='manager') 
    LOOP
        DBMS_OUTPUT.PUT_LINE('Employee Number: ' || emp.eno );
        DBMS_OUTPUT.PUT_LINE('Employee Name: ' || emp.ename);
        DBMS_OUTPUT.PUT_LINE('Department: ' || emp.department );
        DBMS_OUTPUT.PUT_LINE('Designation: ' || emp.designation );
        DBMS_OUTPUT.PUT_LINE('Salary: ' || emp.salary );
    END LOOP;
END;
/

2.Write a procedure to update the salary of the employee whose name starts with 'a'.

CREATE OR REPLACE PROCEDURE update_salary_a AS 
BEGIN 
    UPDATE EMPLOYEE SET salary=45000 WHERE ename LIKE 'a%';
END;
/

3.Write a procedure to delete the record from employee whose department is finance.

CREATE OR REPLACE PROCEDURE delete_record_dep_finance AS 
BEGIN 
    DELETE FROM EMPLOYEE where department='finance';
END;
/

4.Write a function to display data from person table who is oldest. 🧓

CREATE OR REPLACE FUNCTION display_whos_old RETURN VARCHAR2
IS 
    details VARCHAR2(1000);
BEGIN 
    SELECT 'pid : '|| pid || '| pname : ' || pname || '| age: ' || age || '| height: '||height || '| weight: '||weight ||
    '| bloodgroup: '||bloodgroup
    INTO details 
    FROM person
    WHERE age = (SELECT MAX(age) FROM person);
    RETURN details;
END;
/



DECLARE
    old_person_details VARCHAR2(1000);
BEGIN 
    old_person_details := display_whos_old;
    DBMS_OUTPUT.PUT_LINE(old_person_details);
END;
/

5. Write a function to display total heights of all persons. 📏

CREATE OR REPLACE FUNCTION total_heights RETURN NUMBER 
IS
    result_data NUMBER;
BEGIN 
    SELECT SUM(age) INTO result_data FROM person;
    RETURN result_data;
END;
/

DECLARE
    total_heights_of_persons NUMBER;
BEGIN 
    total_heights_of_persons := total_heights;
    DBMS_OUTPUT.PUT_LINE('Total height of persons is : ' || total_heights_of_persons);
END;
/

6. Write a function to display average weight of the persons. ⚖️

create or replace function avg_weight return number 
is 
    average_weight number;
begin
  select AVG(weight)
    into average_weight
    from person;

    return average_weight;
end;
/

declare 
    average_weight_result number;
begin
    average_weight_result := avg_weight;
    dbms_output.put_line('The average of person in the table is : ' || average_weight_result);
end;
/



7. Write a function to display minimum salary of employee. 💰

create or replace function minimums_salary_emp return number 
is 
    min_salary number;
begin
  select MIN(salary) into min_salary from employee;
  return min_salary;
end;
/

declare 
    min_salary number;
begin
  min_salary := minimums_salary_emp;
  dbms_output.put_line('The minimum salary of a employee is :  ' || min_salary);
end;
/

8. Write PL/SQL block to fetch the details of employee whose eid is 3 and check that salary is above 50000 or not. If salary is above 50000, then display data; otherwise, raise an exception and print proper message.

declare 
emp_salary number;
salary_not_found EXCEPTION;
begin
    select salary
    into emp_salary
    from employee
    where eno=3;

    if(emp_salary > 50000) then
        dbms_output.put_line('Employee with eid:3 has salary above 50000');
    else
        raise salary_not_found;
    end if;
exception 
    when salary_not_found then 
        dbms_output.put_line('Employee with eid:3 do not have salary above 50000');
end;
/




9. Write a procedure to display person’s details whose age is 20.

create or replace procedure display_details_age20 as
begin
    for p in (select * from person where age=20)
    loop
      dbms_output.put_line('p id : ' ||p.pid);
      dbms_output.put_line('pname : ' ||p.pname);
      dbms_output.put_line('age : ' ||p.age);
      dbms_output.put_line('height : ' ||p.height);
      dbms_output.put_line('weight : ' ||p.weight);
      dbms_output.put_line('bloodgroup : ' ||p.bloodgroup || CHR(10));
    end loop;
end;
/


10. Write PL/SQL block to fetch the data of person whose pid is 4. Check the age is above 18 or not. If age is above 18, then print 'you are eligible for voting'; else, print 'not eligible'.

declare 
person_age number;
age_exception exception;
begin
    select age into person_age from person where pid=4;

    if(person_age>18)then
        dbms_output.put_line('You are eligible to vote');
    else
        raise age_exception;
    end if;
exception
    when age_exception then
        dbms_output.put_line('Oops you are not eligible to vote!!');
end;
/