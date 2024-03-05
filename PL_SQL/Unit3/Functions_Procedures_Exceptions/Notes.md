# Syntax For Function

```
CREATE [OR REPLACE] FUNCTION function_name
(PARAMETER 1 ,PARAMETER 2,...) RETURN datatype
IS
 DECLARE variable,constant ETC.
BEGIN
  Executable Statements
  Return (Return value);
END;
```

# Syntax For Procedure

```
CREATE [OR REPLACE] PROCEDURE procedure_name
(PARAMETER 1,PARAMETER 2,...)
IS
  DECLARE variables,constants
BEGIN
  Executable statements
END procedure_name;
```

# Syntax For Exceptions
```
DECLARE 
   exception_name EXCEPTION; 
BEGIN 
   IF condition THEN 
      RAISE exception_name; 
   END IF; 
EXCEPTION 
   WHEN exception_name THEN 
   statement; 
END; 
```