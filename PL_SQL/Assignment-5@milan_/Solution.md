## SOLUTION: (use emp table previously created!)

### 1. Create an explicit cursor to store the employee data who is working in‘IT’ department into department table.

```sql
DECLARE
    e_eno emp.eno%TYPE;
    e_ename emp.ename%TYPE;
    e_department emp.department%TYPE;
    e_salary emp.salary%TYPE;
  CURSOR it_employees IS
    SELECT * from emp
    WHERE department='IT';
BEGIN
 OPEN it_employees ;
 LOOP
  FETCH it_employees INTO e_eno,e_ename,e_department,e_salary;
  EXIT WHEN it_employees%NOTFOUND;
  INSERT INTO dep_it VALUES (e_eno,e_ename,e_department,e_salary);
 END LOOP;
 CLOSE it_employees;
 COMMIT;
END;
/
```

### 2. Create an explicit cursor to display data in sorted order salary wise in descending form.

```sql
DECLARE
  CURSOR desc_order IS
    SELECT * FROM emp ORDER BY salary DESC;
    e_eno emp.eno%TYPE;
    e_ename emp.ename%TYPE;
    e_department emp.department%TYPE;
    e_salary emp.salary%TYPE;
BEGIN
  OPEN desc_order;
  LOOP
    FETCH desc_order INTO e_eno,e_ename,e_department,e_salary;
    EXIT WHEN desc_order%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Employee No: ' || e_eno || ', Employee Name: ' || e_ename || ', Department: ' || e_department || ', Salary: ' || e_salary || CHR(10));
  END LOOP;
  CLOSE desc_order;
END;
/
```

### 3. Create an explicit cursor to increase salary by 3% who is working in ‘finance’ department.

```sql
DECLARE
    CURSOR c_employees IS
        SELECT eno, ename, department, salary
        FROM emp
        WHERE department = 'Finance'
        FOR UPDATE;

    e_eno emp.eno%TYPE;
    e_ename emp.ename%TYPE;
    e_department emp.department%TYPE;
    e_salary emp.salary%TYPE;
BEGIN
    OPEN c_employees;
    LOOP
        FETCH c_employees INTO e_eno, e_ename, e_department, e_salary;
        EXIT WHEN c_employees%NOTFOUND;

        UPDATE emp
        SET salary = 1000*1.03
        WHERE CURRENT OF c_employees;

        DBMS_OUTPUT.PUT_LINE('Salary updated for employee: ' || e_eno || ', Name: ' || e_ename);
    END LOOP;
    CLOSE c_employees;

    COMMIT;
END;
/

```

### 4. Create an explicit cursor to delete a record who is working in ‘management’ department.

```sql
  DECLARE
  /* Define a cursor to hold the employee data */
  CURSOR emp_cursor IS
  SELECT eno -- Replace with actual column names
  FROM emp
  WHERE department = 'management';

  /* Define a record variable to hold fetched data */
  emp_record emp_cursor%ROWTYPE;

  /* Variable to store the number of rows deleted */
  num_deleted INTEGER := 0;
BEGIN
  /* Open the cursor to prepare for fetching data */
  OPEN emp_cursor;

  /* Loop through each record in the cursor */
  LOOP
    /* Fetch the next row into the record variable */
    FETCH emp_cursor INTO emp_record;

    /* Exit the loop if no more rows to fetch */
    EXIT WHEN emp_cursor%NOTFOUND;

    /* Delete the employee record using the employee ID */
    DELETE FROM emp
    WHERE eno = emp_record.eno;

    /* Increment the counter for deleted rows */
    num_deleted := num_deleted + 1;

    /* Commit the deletion after each row (optional for smaller datasets) */
    COMMIT;
  END LOOP;

  /* Close the cursor to release resources */
  CLOSE emp_cursor;

  /* Print the number of deleted records (optional) */
  DBMS_OUTPUT.PUT_LINE('Number of employees deleted: ' || num_deleted);

END;
/

```

### 5. Write a code to create a package which will include two procedures for insert a record into a table and delete a record from the table.

```sql
CREATE OR REPLACE PACKAGE insert_delete_operation AS
  PROCEDURE insert_record(no in emp.eno%type,name in emp.ename%type,department in emp.department%type,salary in emp.salary%type);
  PROCEDURE delete_record(no in emp.eno%type);
END insert_delete_operation;
/
```

```sql
CREATE OR REPLACE PACKAGE BODY insert_delete_operation AS

  PROCEDURE insert_record(no in emp.eno%type,name in emp.ename%type,department in emp.department%type,salary in emp.salary%type) AS
  BEGIN
    INSERT INTO emp VALUES (no,name,department,salary);
    DBMS_OUTPUT.PUT_LINE('data inserted!');
  END insert_record;


  PROCEDURE delete_record(no in emp.eno%type) AS
  BEGIN
    DELETE from emp WHERE emp.eno = no;
    DBMS_OUTPUT.PUT_LINE('data deleted!');
  END delete_record;

END insert_delete_operation;
/
```

```sql
BEGIN
  -- insert_delete_operation.insert_record(9,'Anamika','Advt.',70000);
  insert_delete_operation.delete_record(8);
  COMMIT;
END;
/
```

```sql
BEGIN
  insert_delete_operation.insert_record(10,'Uvi','Manager',60000);
   insert_delete_operation.delete_record(7);
  COMMIT;
END;
/
```

### Terminal output of the code above : ✅

```sql
  SQL> CREATE OR REPLACE PACKAGE insert_delete_operation AS
  2    PROCEDURE insert_record(no in emp.eno%type,name in emp.ename%type,department in emp.department%type,salary in emp.salary%type);
  3    PROCEDURE delete_record(no in emp.eno%type);
  4  END insert_delete_operation;
  5  /

Package created.



SQL> CREATE OR REPLACE PACKAGE BODY insert_delete_operation AS
  2
  3    PROCEDURE insert_record(no in emp.eno%type,name in emp.ename%type,department in emp.department%type,salary in emp.salary%type) AS
  4    BEGIN
  5      INSERT INTO emp VALUES (no,name,department,salary);
  6      DBMS_OUTPUT.PUT_LINE('data inserted!');
  7    END insert_record;
  8
  9
 10    PROCEDURE delete_record(no in emp.eno%type) AS
 11    BEGIN
 12      DELETE from emp WHERE emp.eno = no;
 13      DBMS_OUTPUT.PUT_LINE('data deleted!');
 14    END delete_record;
 15
 16  END insert_delete_operation;
 17  /

Package body created.

SQL> BEGIN
  2    insert_delete_operation.insert_record(9,'Anamika','Advt.',70000);
  3    COMMIT;
  4  END;
  5  /
data inserted!

PL/SQL procedure successfully completed.

SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   53045
         2 Harshil                        IT                   74263
         3 Shrey                          IT                   74263
         7 Rose                           HR                   72100
         5 Sid                            Product Design       92700
         6 Aayush                         Finance         80634.9828
         8 UJ                             IT                   84872
         9 Anamika                        Advt.                70000

8 rows selected.

SQL> BEGIN
  2    -- insert_delete_operation.insert_record(9,'Anamika','Advt.',70000);
  3    insert_delete_operation.delete_record(7);
  4    COMMIT;
  5  END;
  6  /
data deleted!

PL/SQL procedure successfully completed.

SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   53045
         2 Harshil                        IT                   74263
         3 Shrey                          IT                   74263
         5 Sid                            Product Design       92700
         6 Aayush                         Finance         80634.9828
         8 UJ                             IT                   84872
         9 Anamika                        Advt.                70000

7 rows selected.




SQL> BEGIN
  2    insert_delete_operation.insert_record(10,'Uvi','Manager',60000);
  3    insert_delete_operation.delete_record(8);
  4    COMMIT;
  5  END;
  6  /
data inserted!
data deleted!

PL/SQL procedure successfully completed.

SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   53045
         2 Harshil                        IT                   74263
         3 Shrey                          IT                   74263
         5 Sid                            Product Design       92700
         6 Aayush                         Finance         80634.9828
        10 Uvi                            Manager              60000
         9 Anamika                        Advt.                70000

7 rows selected.

SQL>
```

### 6. Write a code to create a package which will include a procedure to update salary with 1000 rs.

```sql
CREATE OR REPLACE PACKAGE update_salary AS
  PROCEDURE increase_1000(emp_no in emp.eno%type);
END update_salary;
/
```

```sql
CREATE OR REPLACE PACKAGE BODY update_salary AS
  PROCEDURE increase_1000(emp_no in emp.eno%type) AS
  BEGIN
    UPDATE emp SET salary=salary+1000 WHERE emp.eno=emp_no;
  END increase_1000;
END update_salary;
/
```

```sql
DECLARE
 emp_no emp.eno%type := &emp_no;
BEGIN
  update_salary.increase_1000(emp_no);
END;
/

```

### Terminal output of the code above : ✅

```sql
SQL> CREATE OR REPLACE PACKAGE update_salary AS
  2    PROCEDURE increase_1000(emp_no in emp.eno%type);
  3  END update_salary;
  4  /

Package created.


SQL> CREATE OR REPLACE PACKAGE BODY update_salary AS
  2    PROCEDURE increase_1000(emp_no in emp.eno%type) AS
  3    BEGIN
  4      UPDATE emp SET salary=salary+1000 WHERE emp.eno=emp_no;
  5    END increase_1000;
  6  END update_salary;
  7  /

Package body created.



SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   55045
         2 Harshil                        IT                   76263
         3 Shrey                          IT                   76263
         5 Sid                            Product Design       94700
         6 Aayush                         Finance         82634.9828
        10 Uvi                            Manager              63000
         9 Anamika                        Advt.                73000

7 rows selected.

SQL> DECLARE
  2   emp_no emp.eno%type := &emp_no;
  3  BEGIN
  4    update_salary.increase_1000(emp_no);
  5  END;
  6  /
Enter value for emp_no: 9
old   2:  emp_no emp.eno%type := &emp_no;
new   2:  emp_no emp.eno%type := 9;
The Previous Salary was : 73000
The New Salary is : 74000
The Salary difference  is : 1000

PL/SQL procedure successfully completed.

SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   55045
         2 Harshil                        IT                   76263
         3 Shrey                          IT                   76263
         5 Sid                            Product Design       94700
         6 Aayush                         Finance         82634.9828
        10 Uvi                            Manager              63000
         9 Anamika                        Advt.                74000

7 rows selected.

SQL>

```

### 7. Write a code to create a package which will include two procedures for set a record into a table and getting a record from the table.

```sql
CREATE OR REPLACE PACKAGE set_get_record AS
  PROCEDURE set_record(
    id in emp.eno%type,
    name in emp.ename%type,
    dep in emp.department%type,
    sal in emp.salary%type
    );

  PROCEDURE get_record(
    emp_id in emp.eno%type
  );
END  set_get_record;
/
```

```sql
CREATE OR REPLACE PACKAGE BODY set_get_record AS
  PROCEDURE set_record(
    id in emp.eno%type,
    name in emp.ename%type,
    dep in emp.department%type,
    sal in emp.salary%type
    ) AS
    BEGIN
      INSERT INTO emp VALUES (id,name,dep,sal);
      DBMS_OUTPUT.PUT_LINE('Data set!!');
    END set_record;

  PROCEDURE get_record(
    emp_id in emp.eno%type
  ) AS
  BEGIN
   FOR emp_rec IN (SELECT * from emp WHERE eno=emp_id)
   LOOP
      DBMS_OUTPUT.PUT_LINE('ENO : ' || emp_rec.eno);
      DBMS_OUTPUT.PUT_LINE('ENAME : ' || emp_rec.ename);
      DBMS_OUTPUT.PUT_LINE('DEPARTMENT : ' || emp_rec.department);
      DBMS_OUTPUT.PUT_LINE('SALARY : ' || emp_rec.salary || CHR(10));
   END LOOP;
  END get_record;
END  set_get_record;
/
```

```SQL
BEGIN
  set_get_record.set_record(11,'Gargi','HouseKeeping',25000);
  set_get_record.get_record(11);
END;
/
```

### Terminal output of the code above : ✅

```SQL
SQL> CREATE OR REPLACE PACKAGE set_get_record AS
  2    PROCEDURE set_record(
  3      id in emp.eno%type,
  4      name in emp.ename%type,
  5      dep in emp.department%type,
  6      sal in emp.salary%type
  7      );
  8
  9    PROCEDURE get_record(
 10      emp_id in emp.eno%type
 11    );
 12  END  set_get_record;
 13  /

Package created.

SQL> CREATE OR REPLACE PACKAGE BODY set_get_record AS
  2    PROCEDURE set_record(
  3      id in emp.eno%type,
  4      name in emp.ename%type,
  5      dep in emp.department%type,
  6      sal in emp.salary%type
  7      ) AS
  8      BEGIN
  9        INSERT INTO emp VALUES (id,name,dep,sal);
 10        DBMS_OUTPUT.PUT_LINE('Data set!!');
 11      END set_record;
 12
 13    PROCEDURE get_record(
 14      emp_id in emp.eno%type
 15    ) AS
 16    BEGIN
 17     FOR emp_rec IN (SELECT * from emp WHERE eno=emp_id)
 18     LOOP
 19        DBMS_OUTPUT.PUT_LINE('ENO : ' || emp_rec.eno);
 20        DBMS_OUTPUT.PUT_LINE('ENAME : ' || emp_rec.ename);
 21        DBMS_OUTPUT.PUT_LINE('DEPARTMENT : ' || emp_rec.department);
 22        DBMS_OUTPUT.PUT_LINE('SALARY : ' || emp_rec.salary || CHR(10));
 23     END LOOP;
 24    END get_record;
 25  END  set_get_record;
 26  /

Package body created.

SQL> BEGIN
  2    set_get_record.set_record(11,'Gargi','HouseKeeping',25000);
  3    set_get_record.get_record(11);
  4  END;
  5  /
Data set!!
ENO : 11
ENAME : Gargi
DEPARTMENT : HouseKeeping
SALARY : 25000

PL/SQL procedure successfully completed.
```

### 8. Write a code to create a package to which will include one procedure and a function. Procedure will insert a record into table and function will give maximum salary from the table.

```SQL
CREATE OR REPLACE PACKAGE emp_package AS
  PROCEDURE insert_record(emp_no IN emp.eno%TYPE, emp_name IN emp.ename%TYPE, emp_dep IN emp.department%TYPE, emp_salary IN emp.salary%TYPE);
  FUNCTION get_max_salary RETURN NUMBER;
END emp_package;
/

```

```sql
CREATE OR REPLACE PACKAGE BODY emp_package AS
  PROCEDURE insert_record(emp_no IN emp.eno%TYPE, emp_name IN emp.ename%TYPE, emp_dep IN emp.department%TYPE, emp_salary IN emp.salary%TYPE) AS
  BEGIN
    INSERT INTO emp (eno, ename, department, salary) VALUES (emp_no, emp_name, emp_dep, emp_salary);
  END insert_record;

  FUNCTION get_max_salary RETURN NUMBER IS
    max_sal NUMBER;
  BEGIN
    SELECT MAX(salary) INTO max_sal FROM emp;
    RETURN max_sal;
  END get_max_salary;
END emp_package;
/
```

```sql
DECLARE
maximum_salary NUMBER;
BEGIN
  emp_package.insert_record(12,'Vishal','Cloud',60000);
  maximum_salary := emp_package.get_max_salary;
  DBMS_OUTPUT.PUT_LINE('maximum salary is : ' || maximum_salary );
END;
/
```

### Terminal output of the code above : ✅

```sql

SQL> CREATE OR REPLACE PACKAGE emp_package AS
  2    PROCEDURE insert_record(emp_no IN emp.eno%TYPE, emp_name IN emp.ename%TYPE, emp_dep IN emp.department%TYPE, emp_salary IN emp.salary%TYPE);

  3    FUNCTION get_max_salary RETURN NUMBER;
  4  END emp_package;
  5  /

Package created.


SQL> CREATE OR REPLACE PACKAGE BODY emp_package AS
  2    PROCEDURE insert_record(emp_no IN emp.eno%TYPE, emp_name IN emp.ename%TYPE, emp_dep IN emp.department%TYPE, emp_salary IN emp.salary%TYPE) AS
  3    BEGIN
  4      INSERT INTO emp (eno, ename, department, salary) VALUES (emp_no, emp_name, emp_dep, emp_salary);
  5    END insert_record;
  6
  7    FUNCTION get_max_salary RETURN NUMBER IS
  8      max_sal NUMBER;
  9    BEGIN
 10      SELECT MAX(salary) INTO max_sal FROM emp;
 11      RETURN max_sal;
 12    END get_max_salary;
 13  END emp_package;
 14  /

Package body created.

SQL> select * from emp;

       ENO ENAME                          DEPARTMENT          SALARY
---------- ------------------------------ --------------- ----------
         1 Milan                          IT                   55045
         2 Harshil                        IT                   76263
         3 Shrey                          IT                   76263
        11 Gargi                          HouseKeeping         25000
         5 Sid                            Product Design       94700
         6 Aayush                         Finance         82634.9828
        12 Vishal                         Cloud                60000
        10 Uvi                            Manager              63000
         9 Anamika                        Advt.                74000

9 rows selected.

SQL> DECLARE
  2  maximum_salary NUMBER;
  3  BEGIN
  4    emp_package.insert_record(12,'Vishal','Cloud',60000);
  5    maximum_salary := emp_package.get_max_salary;
  6    DBMS_OUTPUT.PUT_LINE('maximum salary is : ' || maximum_salary );
  7  END;
  8  /
maximum salary is : 94700

PL/SQL procedure successfully completed.

```

**Made by Milan** 🧑🏻‍💻🌐🚀
