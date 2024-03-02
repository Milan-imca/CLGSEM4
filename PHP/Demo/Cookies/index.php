<!DOCTYPE html>
<html>

<head>
  <title>Set Cookie</title>
</head>

<body>
  <h1>Set Cookie</h1>
  <form action="index.php" method="post">
    <label for="name">Enter your name:</label>
    <input type="text" id="name" name="name" required>
    <button type="submit">Set Cookie</button>
  </form>
</body>

</html>


<?php
if (isset($_POST['name'])) {
  // Set a cookie with the user's name
  $name = $_POST['name'];
  setcookie('user_name', $name, time() + 10); // expire in 10 secs
  echo "Cookie set successfully!";
  header("Location: read_cookie.php");
}
?>


<!-- <?php
if (isset($_COOKIE['user_name'])) {
  echo "welcome " . $_COOKIE['user_name'];
} else {
  echo "Welcome guest!";
}

?> -->