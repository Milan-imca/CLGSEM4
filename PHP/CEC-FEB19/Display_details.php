<?php
// Include the database configuration file
include 'Database.php';

if (isset($_POST['display'])) {
  $username = $_POST['username'];

  // Display user data from database
  $query = "SELECT * FROM registration_details WHERE name='$username'";
  $result = mysqli_query($conn, $query);
  if (mysqli_num_rows($result) > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
      echo "Name: " . $row['name'] . "<br>";
      echo "Phone No: " . $row['phone_no'] . "<br>";
      echo "Address: " . $row['address'] . "<br>";
    }
  } else {
    echo "No data found!";
  }
}

// Close database connection
mysqli_close($conn);
?>