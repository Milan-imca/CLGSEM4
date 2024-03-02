<?php
session_start();

$db_host = 'localhost';
$db_username = 'root';
$db_password = '';
$db_name = 'registeration';

$conn = mysqli_connect($db_host, $db_username, $db_password, $db_name);

if (!$conn) {
  echo ("Connection failed: ");
}

if (isset($_POST['username']) && isset($_POST['password'])) {
  $username = $_POST['username'];
  $password = $_POST['password'];

  $sql = "INSERT INTO user_details (email, password) VALUES ('$username', '$password')";
  if (mysqli_query($conn, $sql) === TRUE) {
    echo "Registration successful. <a href='index.php'>Login here</a>";
  } else {
    echo "Error: " . $sql . "<br>";
  }
}
?>

<!DOCTYPE html>
<html>

<head>
  <title>Registration Form</title>
</head>

<body>
  <h2>Registration Form</h2>
  <form action="register.php" method="post">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Register">
  </form>
</body>

</html>