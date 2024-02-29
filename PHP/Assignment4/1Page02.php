<?php
session_start();

if (isset($_SESSION["username"]) && isset($_SESSION["address"])) {
  echo "Username : " . $_SESSION["username"] . "<br>";
  echo "Address : " . $_SESSION["address"] . "<br>";
}
?>