## Syntax For Triggers

```sql
CREATE OR REPLACE TRIGGER trigger_name
BEFORE|AFTER
INSERT|UPDATE|DELETE ON table_name
FOR EACH ROW
DECLARE
  --declaring statements
BEGIN
  --Executing statements
EXCEPTION
  --exception handling statements
END;
```

## 🔖Note

```sql
--(use BEFORE when operation is about to happen)
--(use AFTER when operation has happened)
```

## Example

### Creating Student Table with Roll no,Name

```sql
CREATE TABLE STUDENT(
  roll_no NUMBER,
  name VARCHAR2(20)
);
```

### Creating Trigger on Student Table when there's any insertion.

```sql
CREATE OR REPLACE TRIGGER student_insertion
AFTER
INSERT ON STUDENT
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('1 Record Inserted!');
END;
/
```

```sql
INSERT INTO STUDENT VALUES (1,'Milan');
--after succesfully insertion you will find a message "1 Record Inserted" after every insertion
```

```sql
CREATE OR REPLACE TRIGGER student_insertion_details
AFTER
INSERT ON STUDENT
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Roll no:' || :NEW.roll_no);
    DBMS_OUTPUT.PUT_LINE('Name:' || :NEW.name);
END;
/
```

### Creating Trigger on Student Table when there's any updation.

```sql
CREATE OR REPLACE TRIGGER student_update_details
BEFORE
UPDATE ON STUDENT
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Old values' || CHR(10) ||'Roll no - '||:OLD.roll_no ||CHR(10) || 'Name - ' || :OLD.name);
    DBMS_OUTPUT.PUT_LINE('Updated values' || CHR(10) ||'Roll no - '||:NEW.roll_no ||CHR(10) || 'Name - ' || :NEW.name);
END;
/
```

### Creating Trigger on Student Table when there's any deletion.(LETS STORE THE DELETED DATA IN NEW TABLE FOR A RECORD)

```sql
CREATE OR REPLACE TRIGGER student_delete_details
BEFORE
DELETE ON STUDENT
FOR EACH ROW
BEGIN
-- create STU_DEL_DETAILS to store the deleted record;
-- CREATE TABLE STU_DEL_DETAILS(roll_no NUMBER,name VARCHAR(20));
  INSERT INTO STU_DEL_DETAILS VALUES (:OLD.roll_no,:OLD.name);
END;
/
```
