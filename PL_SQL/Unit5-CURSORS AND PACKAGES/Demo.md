### Package demo:

`Create this table`:

```

CREATE TABLE demo_table (
  ID NUMBER(2),
  NAME VARCHAR2(30),
  AGE NUMBER,
  ADDRESS VARCHAR2(30),
  SALARY NUMBER(10)
);


INSERT INTO demo_table (ID, NAME, AGE, ADDRESS, SALARY) VALUES (1, 'Ramesh', 32, 'Ahmedabad', 3000);
INSERT INTO demo_table (ID, NAME, AGE, ADDRESS, SALARY) VALUES (2, 'Khilan', 25, 'Delhi', 3000);
INSERT INTO demo_table (ID, NAME, AGE, ADDRESS, SALARY) VALUES (3, 'Kaushik', 23, 'Kota', 3000);
INSERT INTO demo_table (ID, NAME, AGE, ADDRESS, SALARY) VALUES (4, 'Chaitali', 25, 'Mumbai', 7500);
INSERT INTO demo_table (ID, NAME, AGE, ADDRESS, SALARY) VALUES (5, 'Hardik', 27, 'Bhopal', 9500);
INSERT INTO demo_table (ID, NAME, AGE, ADDRESS, SALARY) VALUES (6, 'Komal', 22, 'MP', 5500);



+----+----------+-----+-----------+----------+
| ID | NAME     | AGE | ADDRESS   | SALARY   |
+----+----------+-----+-----------+----------+
|  1 | Ramesh   |  32 | Ahmedabad |  3000.00 |
|  2 | Khilan   |  25 | Delhi     |  3000.00 |
|  3 | kaushik  |  23 | Kota      |  3000.00 |
|  4 | Chaitali |  25 | Mumbai    |  7500.00 |
|  5 | Hardik   |  27 | Bhopal    |  9500.00 |
|  6 | Komal    |  22 | MP        |  5500.00 |
+----+----------+-----+-----------+----------+
```

`Creating a procedure/function to display the table content:`

`Package Head`

```sql
CREATE OR REPLACE PACKAGE display_content AS
  FUNCTION disp_details(cid demo_table.id%type) RETURN VARCHAR2;
END display_content;
/
```

`Package Body`

```sql
CREATE OR REPLACE PACKAGE BODY display_content AS
   FUNCTION disp_details(cid demo_table.id%type)  RETURN VARCHAR2 IS
   result_data VARCHAR(1000);
  BEGIN
    SELECT 'ID :' || id || ' | NAME : ' || name || ' | AGE : ' || age
    INTO result_data
    from demo_table
    where demo_table.id=cid;
    return result_data;
  END disp_details;
END display_content;
/
```

`Exectution of the function (display_content)`

```sql
SET SERVEROUTPUT ON;
DECLARE
  result_output VARCHAR(1000);
BEGIN
  result_output := display_content.disp_details(1);
  DBMS_OUTPUT.PUT_LINE(result_output);
END;
/

```

# ✅Terminal result for above plsql blocks:

```sql
SQL> CREATE OR REPLACE PACKAGE display_content AS
  2    FUNCTION disp_details(cid demo_table.id%type) RETURN VARCHAR2;
  3  END display_content;
  4  /

Package created.


SQL> CREATE OR REPLACE PACKAGE BODY display_content AS
  2     FUNCTION disp_details(cid demo_table.id%type)  RETURN VARCHAR2 IS
  3     result_data VARCHAR(1000);
  4    BEGIN
  5      SELECT 'ID :' || id || ' | NAME : ' || name || ' | AGE : ' || age
  6      INTO result_data
  7      from demo_table
  8      where demo_table.id=cid;
  9      return result_data;
 10    END disp_details;
 11  END display_content;
 12  /

Package body created.



SQL> DECLARE
  2    result_output VARCHAR(1000);
  3  BEGIN
  4    result_output := display_content.disp_details(1);
  5    DBMS_OUTPUT.PUT_LINE(result_output);
  6  END;
  7  /

ID :1 | NAME : Ramesh | AGE : 32

PL/SQL procedure successfully completed.



```

### PERFORMING THE ABOVE FUNCTION USING (PROCEDURE)

`Procedure inside package head`

```sql
CREATE OR REPLACE PACKAGE proc_display_content AS
  PROCEDURE display_details(cid demo_table.id%type);
END proc_display_content;
/
```

`Package Body`

```sql
CREATE OR REPLACE PACKAGE BODY proc_display_content AS
  PROCEDURE display_details(cid demo_table.id%type) AS
  BEGIN
    FOR emp_rec in (SELECT id,name,age FROM demo_table WHERE demo_table.id = cid)
    LOOP
      DBMS_OUTPUT.PUT_LINE('ID : '||emp_rec.id );
      DBMS_OUTPUT.PUT_LINE('NAME : '||emp_rec.name );
      DBMS_OUTPUT.PUT_LINE('AGE : '||emp_rec.age || CHR(10));
    END LOOP;
  END display_details;
END proc_display_content;
/
```

`Executing procedure `

```sql
set serveroutput on
declare
  result demo_table.id%type := &id;
  begin
    proc_display_content.display_details(result);
  end;
/
```

# ✅Terminal result for above plsql blocks:

```sql
SQL> CREATE OR REPLACE PACKAGE proc_display_content AS
  2    PROCEDURE display_details(cid demo_table.id%type);
  3  END proc_display_content;
  4  /

Package created.


SQL> CREATE OR REPLACE PACKAGE BODY proc_display_content AS
  2    PROCEDURE display_details(cid demo_table.id%type) AS
  3    BEGIN
  4      FOR emp_rec in (SELECT id,name,age FROM demo_table WHERE demo_table.id = cid)
  5      LOOP
  6        DBMS_OUTPUT.PUT_LINE('ID : '||emp_rec.id );
  7        DBMS_OUTPUT.PUT_LINE('NAME : '||emp_rec.name );
  8        DBMS_OUTPUT.PUT_LINE('AGE : '||emp_rec.age || CHR(10));
  9      END LOOP;
 10    END display_details;
 11  END proc_display_content;
 12  /

Package body created.

SQL> set serveroutput on
SQL> declare
  2    result demo_table.id%type := &id;
  3    begin
  4      proc_display_content.display_details(result);
  5    end;
  6  /
Enter value for id: 3
old   2:   result demo_table.id%type := &id;
new   2:   result demo_table.id%type := 3;
ID : 3
NAME : Kaushik
AGE : 23

```

**Made by Milan** 🧑🏻‍💻🌐🚀
