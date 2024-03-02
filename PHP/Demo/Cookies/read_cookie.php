<?php
if (isset($_COOKIE['user_name'])) {
  echo "welcome " . $_COOKIE['user_name'];
} else {
  echo "Welcome guest!";
}

?>