<?php
if (isset($_POST['name'])) {
  // Set a cookie with the user's name
  $name = $_POST['name'];
  setcookie('user_name', $name, time() + 10); // expire in 10 secs
  echo "Cookie set successfully!";
  header("Location: read_cookie.php");
}
?>