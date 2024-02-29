<!-- Q:1 Write a PHP script to create session and store username and address in it and print it in next page. -->

<?php

session_start();

if (isset($_POST['submit'])) {
  $_SESSION["username"] = $_POST['username'];
  $_SESSION["address"] = $_POST['address'];

  header('Location:1Page02.php');
  exit;
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>page 1</title>
</head>

<body>
  <form action="" method="post">
    <label for="">Username : </label>
    <input type="text" placeholder="username" name="username"><br>
    <label for="">Address : </label>
    <input type="text" placeholder="address" name="address"><br>
    <button type="submit" name="submit">Submit</button>
  </form>
</body>

</html>