-- 16. Write a Program to Check Whether a Number is Prime or Not

DECLARE
    num_to_check NUMBER := &num_input;
    is_prime BOOLEAN := TRUE;
    i NUMBER;
BEGIN
    IF num_to_check <= 1 THEN
        is_prime := FALSE;
    ELSE
        FOR i IN 2..ROUND(SQRT(num_to_check)) LOOP
            IF MOD(num_to_check, i) = 0 THEN
                is_prime := FALSE; 
                EXIT; 
            END IF;
        END LOOP;
    END IF;

    IF is_prime THEN
        DBMS_OUTPUT.PUT_LINE(num_to_check || ' is a prime number.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(num_to_check || ' is not a prime number.');
    END IF;
END;
