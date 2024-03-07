# CURSORS IN PLSQL

### What is Cursor?

In simple terms, a cursor in PL/SQL is like a pointer or a handle that allows you to retrieve and process rows from the result set of a SQL query, one row at a time. It enables you to perform operations on each row individually, such as reading values, updating data, or inserting new records. Cursors are particularly useful when you need to work with a set of data row by row, rather than all at once.

## There are two types of cursors −

- ### Implicit cursors

  Implicit cursors are automatically created by Oracle whenever an SQL statement is executed, when there is no explicit cursor for the statement.

- ### Explicit cursors

  Explicit cursors are programmer-defined cursors for gaining more control over the context area. An explicit cursor should be defined in the declaration section of the PL/SQL Block. It is created on a SELECT Statement which returns more than one row.

### Working with an explicit cursor includes the following steps −

- `Declaring` the cursor for initializing the memory.

  ```sql
    CURSOR c_customers IS
      SELECT id, name, address FROM customers;
  ```

- `Opening` the cursor for allocating the memory.

  ```sql
    OPEN c_customers;
  ```

- `Fetching` the cursor for retrieving the data.

  ```sql
  FETCH c_customers INTO c_id, c_name, c_addr;
  ```

- `Closing` the cursor to release the allocated memory.

  ```sql
  CLOSE c_customers;
  ```

## Example to understand Cursor:


```sql
--table for example
Select * from customers;  

+----+----------+-----+-----------+----------+ 
| ID | NAME     | AGE | ADDRESS   | SALARY   | 
+----+----------+-----+-----------+----------+ 
|  1 | Ramesh   |  32 | Ahmedabad |  2000.00 | 
|  2 | Khilan   |  25 | Delhi     |  1500.00 | 
|  3 | kaushik  |  23 | Kota      |  2000.00 | 
|  4 | Chaitali |  25 | Mumbai    |  6500.00 | 
|  5 | Hardik   |  27 | Bhopal    |  8500.00 | 
|  6 | Komal    |  22 | MP        |  4500.00 | 
+----+----------+-----+-----------+----------+
```

```sql
DECLARE 
   c_id customers.id%type; 
   c_name customers.name%type; 
   c_addr customers.address%type; 
   CURSOR c_customers is 
      SELECT id, name, address FROM customers; 
BEGIN 
   OPEN c_customers; 
   LOOP 
   FETCH c_customers into c_id, c_name, c_addr; 
      EXIT WHEN c_customers%notfound; 
      dbms_output.put_line(c_id || ' ' || c_name || ' ' || c_addr); 
   END LOOP; 
   CLOSE c_customers; 
END; 
/
```

```sql
--output:
1 Ramesh Ahmedabad  
2 Khilan Delhi  
3 kaushik Kota     
4 Chaitali Mumbai  
5 Hardik Bhopal   
6 Komal MP  
  
PL/SQL procedure successfully completed. 
```



**Made by Milan** 🧑🏻‍💻🌐🚀
## Credits and References 😉

- Reference: [tutorialspoint.com](https://www.tutorialspoint.com/plsql/plsql_cursors.htm)