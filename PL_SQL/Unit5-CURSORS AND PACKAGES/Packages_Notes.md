# PACKAGES IN PLSQL

- Packages are schema objects that groups logically related PL/SQL types, variables, and subprograms.

### A package will have two mandatory parts −

- Package specification
- Package body or definition

## Package Syntax:

`Package specification`

```sql

CREATE OR REPLACE PACKAGE my_package AS
  FUNCTION add_numbers(a NUMBER, b NUMBER) RETURN NUMBER;
END my_package;
/

```

`Package body`

```sql
CREATE OR REPLACE PACKAGE BODY my_package AS
  FUNCTION add_numbers(a NUMBER, b NUMBER) RETURN NUMBER IS
    result NUMBER;
  BEGIN
    result := a + b;
    RETURN result;
  END add_numbers;
END my_package;
/

```

`Executing function inside package:`

```sql
DECLARE
  result NUMBER;
BEGIN
  result := my_package.add_numbers(10, 20);
  DBMS_OUTPUT.PUT_LINE('Result: ' || result);
END;
/
```

### 📝Note : In the same way you can create a procedure inside a package and execute it.

### Example to execute Package in PLSQL: -

`Table used`

```sql
The following program provides a more complete package. We will use the CUSTOMERS table stored in our database with the following records −

Select * from customers;

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

`Pakage head (Declaring the procedure inside package)`

```sql
CREATE PACKAGE cust_sal AS
   PROCEDURE find_sal(c_id customers.id%type);
END cust_sal;
/
```

`Package Body (The body of procedure in plsql block)`

```sql
CREATE OR REPLACE PACKAGE BODY cust_sal AS
   PROCEDURE find_sal(c_id customers.id%TYPE) IS
   c_sal customers.salary%TYPE;
   BEGIN
      SELECT salary INTO c_sal
      FROM customers
      WHERE id = c_id;
      dbms_output.put_line('Salary: '|| c_sal);
   END find_sal;
END cust_sal;
/
```

## How to use package elements in the plsql block:

The package elements (variables, procedures or functions) are accessed with the following syntax −

```sql
package_name.element_name;
```

`Using the Procedure inside Package to execute it`

```sql
  DECLARE
   code customers.id%type := &cc_id;
BEGIN
   cust_sal.find_sal(code);
END;
/
```

`Output:`
When the above code is executed at the SQL prompt, it prompts to enter the customer ID and when you enter an ID, it displays the corresponding salary as follows −
```
Enter value for cc_id: 1 
Salary: 3000 

PL/SQL procedure successfully completed. 
```

**Made by Milan** 🧑🏻‍💻🌐🚀

## Credits and References 😉

Reference: [tutorialspoint.com](https://www.tutorialspoint.com/plsql/plsql_packages.htm)
