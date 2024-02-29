<?php

if (isset($_COOKIE['username']) && isset($_COOKIE['address'])) {
  echo "Username : " . $_COOKIE['username'] . "<br>";
  echo "Address : " . $_COOKIE['address'] . "<br>";
} else {
  echo "Cookie not found!!";
}
?>