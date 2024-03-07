## SOLUTION: (use emp table previously created!)

### 1. Create an explicit cursor to store the employee data who is working in‘IT’ department into department table.

```sql
DECLARE
  CURSOR it_employees IS
    SELECT * from emp
    WHERE department='IT';
BEGIN
  FOR e in it_employees
    LOOP
      INSERT INTO dep_it VALUES (e.eno,e.ename,e.department,e.salary);
    END LOOP;
END;
/
```

### 2. Create an explicit cursor to display data in sorted order salary wise in descending form.
```sql
DECLARE
  CURSOR display_details_desc IS
  SELECT * from emp
  ORDER BY salary DESC;
BEGIN
  FOR e in display_details_desc
  LOOP
    DBMS_OUTPUT.PUT_LINE(
      ' ENO : ' || e.eno ||
      ' ENAME : ' || e.ename ||
      ' DEPARTMENT : ' || e.department ||
      ' SALARY : ' || e.salary || CHR(10)
      );
  END LOOP;
END;
/
```

### 3. Create an explicit cursor to increase salary by 3% who is working in ‘finance’ department.
```sql
DECLARE 
  CURSOR emp_finance IS
    SELECT * FROM emp
      WHERE department='Finance';
  BEGIN
    FOR emp_rec IN emp_finance
    LOOP
      UPDATE emp set salary=salary*1.03
      WHERE emp.department='Finance';
    END LOOP;
    COMMIT;
  END;
  /
```

### 4. Create an explicit cursor to delete a record who is working in ‘management’ department.
```sql
DECLARE
  CURSOR del_manage IS
    SELECT * FROM emp WHERE department='Management';
  BEGIN
    FOR emp_rec IN del_manage 
    LOOP
        DELETE FROM emp where emp.department='Management';
    END LOOP;
  END;
  /
```


- other question adding soon🔜....


**Made by Milan** 🧑🏻‍💻🌐🚀