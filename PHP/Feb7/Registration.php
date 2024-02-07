<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Form</title>
</head>

<body>
  <h2>Registration Form</h2>
  <form action="Login.php" action="get">
    <label for="firstname">First name : </label>
    <input type="text" name="firstname" pattern="[A-Za-z]{3,8}" required>
    <br>

    <label for="lastname">Last name : </label>
    <input type="text" name="lastname" pattern="[A-Za-z]+" required>
    <br>

    <label for="phone">Phone Number : </label>
    <input type="text" name="phone" pattern="\d{10}" required>
    <br>

    <label for="gender">Gender</label>
    <input type="radio" name="gender" value="male" required>
    <label for="male">Male</label>
    <input type="radio" name="gender" value="female" required>
    <label for="female">Female</label>
    <br>

    <label for="hobbies">Hobbies : </label><br>
    <input type="checkbox" name="hobbies[]" value="hobby1">
    <label for="hobby1">Drawing</label>
    <input type="checkbox" name="hobbies[]" value="hobby2">
    <label for="hobby2">Music</label>
    <input type="checkbox" name="hobbies[]" value="hobby3">
    <label for="hobby3">Playing Games</label>
    <br>

    <input type="submit" value="Submit">


  </form>
</body>

</html>