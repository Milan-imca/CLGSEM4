## 📝ASSIGNMENT 4 SOLUTION 

## Creating emp table (eno, ename, department, salary)

```sql
CREATE TABLE emp(
  eno NUMBER,
  ename VARCHAR2(30),
  department VARCHAR2(15),
  salary NUMBER
);
```

### Inserting 5 records:

```sql
INSERT INTO emp VALUES (1,'Milan','IT',50000);
INSERT INTO emp VALUES (2,'Harshil','IT',60000);
INSERT INTO emp VALUES (3,'Shrey','IT',70000);
INSERT INTO emp VALUES (4,'Aayush','Finance',60000);
INSERT INTO emp VALUES (5,'Sid','Product Design',90000);
```

```sql
--output of table:
       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   50000
         2 Harshil                        IT                   60000
         3 Shrey                          IT                   70000
         4 Aayush                         Finance              60000
         5 Sid                            Product Design       90000
```

# Answers

### 1. Write a database trigger store the deleted data of EMP table in EMPDEL table.

```sql
CREATE TABLE empdel(
  eno NUMBER,
  ename VARCHAR2(30),
  department VARCHAR2(15),
  salary NUMBER
);
```

```sql
CREATE OR REPLACE TRIGGER deleted_data
AFTER
DELETE ON emp
FOR EACH ROW
BEGIN
  --CREATE empdel TABLE WITH SAME CONSTRAINTS OF emp
  INSERT INTO empdel VALUES (
    :OLD.eno,
    :OLD.ename,
    :OLD.department,
    :OLD.salary
    );
END;
/
```

### RESULT ON TERMINAL

```sql
SQL> CREATE OR REPLACE TRIGGER deleted_data
  2  AFTER
  3  DELETE ON emp
  4  FOR EACH ROW
  5  BEGIN
  6    --CREATE empdel TABLE WITH SAME CONSTRAINTS OF emp
  7    INSERT INTO empdel VALUES (
  8      :OLD.eno,
  9      :OLD.ename,
 10      :OLD.department,
 11      :OLD.salary
 12      );
 13  END;
 14  /

Trigger created.

--checking that empdel is empty

SQL> select * from empdel;

no rows selected

--performing delete operation
SQL> delete from emp where department='Finance';

1 row deleted.

--record stored in empdel table:
SQL> select * from EMPDEL;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         4 Aayush                         Finance              60000


```

### 2. Write a database trigger to update salary in employee table and it shows salary difference before updating data.

```sql
CREATE OR REPLACE TRIGGER update_salary_trigger
BEFORE
UPDATE ON emp
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('The Previous Salary was : ' || :OLD.salary);
  DBMS_OUTPUT.PUT_LINE('The New Salary is : ' || :NEW.salary);
  DBMS_OUTPUT.PUT_LINE('The Salary difference  is : ' ||( :NEW.salary - :OLD.salary));
END;
/
```

### RESULT ON TERMINAL

```sql
SQL> CREATE OR REPLACE TRIGGER update_salary_trigger
  2  BEFORE
  3  UPDATE ON emp
  4  FOR EACH ROW
  5  BEGIN
  6    DBMS_OUTPUT.PUT_LINE('The Previous Salary was : ' || :OLD.salary);
  7    DBMS_OUTPUT.PUT_LINE('The New Salary is : ' || :NEW.salary);
  8    DBMS_OUTPUT.PUT_LINE('The Salary difference  is : ' ||( :NEW.salary - :OLD.salary));
  9  END;
 10  /

Trigger created.


--before updating table:
SQL> set serveroutput on;
SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   50000
         2 Harshil                        IT                   70000
         3 Shrey                          IT                   70000
         5 Sid                            Product Design       90000


--update query :
SQL> update emp set salary=70000 where ename='Harshil';
The Previous Salary was : 60000
The New Salary is : 70000
The Salary difference  is : 10000

1 row updated.


--after updating table:

SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   50000
         2 Harshil                        IT                   70000
         3 Shrey                          IT                   70000
         5 Sid                            Product Design       90000
```

### 3. Write a trigger to store eid,department,salary to new table before inserting a new record into emp table.

```sql
--creating new_emp_table
CREATE TABLE new_emp_table(
  eno NUMBER,
  department VARCHAR2(15),
  salary NUMBER
);
```

```sql
CREATE OR REPLACE TRIGGER insert_into_new_emp_table
BEFORE
INSERT ON emp
FOR EACH ROW
BEGIN
  INSERT INTO new_emp_table (eno,department,salary) VALUES (:NEW.eno,:NEW.department,:NEW.salary);
END;
/
```

### RESULT ON TERMINAL

```SQL
  SQL> CREATE OR REPLACE TRIGGER insert_into_new_emp_table
  2  BEFORE
  3  INSERT ON emp
  4  FOR EACH ROW
  5  BEGIN
  6    INSERT INTO new_emp_table (eno,department,salary) VALUES (:NEW.eno,:NEW.department,:NEW.salary);
  7  END;
  8  /

Trigger created.

--inserting a record to check the trigger:
SQL> INSERT INTO emp VALUES (6,'Aayush','Finance',60000);

1 row created.

--record inerted in emp table
SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   50000
         2 Harshil                        IT                   70000
         3 Shrey                          IT                   70000
         5 Sid                            Product Design       90000
         6 Aayush                         Finance              60000


--record inerted in new_emp_table
SQL> select * from new_emp_table;

       ENO DEPARTMENT          SALARY
---------- --------------- ----------
         6 Finance              60000

```

### 4. Write a trigger to store employee details into new table who is working in ‘IT’ department.

```sql
--creating it_emp_table
CREATE TABLE it_emp_table(
  eno NUMBER,
  ename VARCHAR2(30),
  department VARCHAR2(15),
  salary NUMBER
);
```

```sql
CREATE OR REPLACE TRIGGER it_dep_emp_trigger
AFTER
INSERT ON emp
FOR EACH ROW
BEGIN
  IF :NEW.department='IT' THEN
    INSERT INTO it_emp_table VALUES (
      :NEW.eno,
      :NEW.ename,
      :NEW.department,
      :NEW.salary
      );
  END IF;
END;
/
```

### RESULT ON TERMINAL

```sql
--creating trigger:
SQL> CREATE OR REPLACE TRIGGER it_dep_emp_trigger
  2  AFTER
  3  INSERT ON emp
  4  FOR EACH ROW
  5  BEGIN
  6    IF :NEW.department='IT' THEN
  7      INSERT INTO it_emp_table VALUES (
  8        :NEW.eno,
  9        :NEW.ename,
 10        :NEW.department,
 11        :NEW.salary
 12        );
 13    END IF;
 14  END;
 15  /

Trigger created.


--inserting non-IT department person:(this record will not be inserted in it_emp_table)
SQL> INSERT INTO emp VALUES (7,'Rose','HR',70000);

--check in it_emp_table:
SQL> select * from it_emp_table;

no rows selected


--inserting an IT department person: (this record will be inserted in it_emp_table)
SQL> INSERT INTO emp VALUES (8,'UJ','IT',80000);

1 row created.

--we can see the record inside the table : it_emp_table
SQL> select * from it_emp_table;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         8 UJ                             IT                   80000
```

### 5. Write a trigger which will store eno,old_salary,new_salary into new_emp table before update the salary in emp table.

```sql
  CREATE TABLE new_emp (
    eno NUMBER,
    old_salary NUMBER,
    new_salary NUMBER
  );
```

```sql
  CREATE OR REPLACE TRIGGER salary_trigger
  BEFORE
  UPDATE ON emp
  FOR EACH ROW
  BEGIN
    INSERT INTO new_emp VALUES (:OLD.eno,:OLD.salary,:NEW.salary);
  END;
  /
```

### RESULT ON TERMINAL

```sql
--creating trigger:
SQL>   CREATE OR REPLACE TRIGGER salary_trigger
  2    BEFORE
  3    UPDATE ON emp
  4    FOR EACH ROW
  5    BEGIN
  6      INSERT INTO new_emp VALUES (:OLD.eno,:OLD.salary,:NEW.salary);
  7    END;
  8    /

Trigger created.

--displaying emp table before any update:
SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   50000
         2 Harshil                        IT                   70000
         3 Shrey                          IT                   70000
         7 Rose                           HR                   70000
         5 Sid                            Product Design       90000
         6 Aayush                         Finance              60000
         8 UJ                             IT                   80000

7 rows selected.

--updating the salary where ename is 'Shrey'
SQL> update emp set salary=90000 where ename='Shrey';
The Previous Salary was : 70000
The New Salary is : 90000
The Salary difference  is : 20000

1 row updated.

--data from emp table after update:
SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   50000
         2 Harshil                        IT                   70000
         3 Shrey                          IT                   90000
         7 Rose                           HR                   70000
         5 Sid                            Product Design       90000
         6 Aayush                         Finance              60000
         8 UJ                             IT                   80000

7 rows selected.

--data got inserted into new_emp as expected:
SQL> select * from new_emp;

       ENO OLD_SALARY NEW_SALARY
---------- ---------- ----------
         3      70000      90000
```
