<!DOCTYPE html>
<html>

<head>
    <title>Registration Form</title>
</head>

<body>
    <h2>Registration Form</h2>
    <form method="post" action="process.php">
        <label>Name:</label>
        <input type="text" name="name" required><br><br>

        <label>Phone No:</label>
        <input type="text" name="phone_no" required><br><br>

        <label>Address:</label>
        <input type="text" name="address" required><br><br>

        <button type="submit" name="submit">Submit</button>
        <button type="submit" name="update">Update</button>
        <button type="submit" name="delete">Delete</button>
    </form>

    <h2>Display User Data</h2>
    <form method="post" action="Display_details.php">
        <label>Enter Name:</label>
        <input type="text" name="username" required>
        <button type="submit" name="display">Display</button>
    </form>
</body> 

</html> 