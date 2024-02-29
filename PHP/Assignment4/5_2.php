<?php
session_start();
if (isset($_POST['submit'])) {
  $_SESSION['uname'] = $_POST['uname'];
  $_SESSION['password'] = $_POST['password'];

  echo "Username : " . $_SESSION['uname'] . "<br>";
  echo "Password : " . $_SESSION['password'] . "<br>";
  echo "Your will redirected to home page within 20 Seconds!";

  header("refresh:20;url=5_1.php");
} else {
  echo "Data not found!!";
}

?>