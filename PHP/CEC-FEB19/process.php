<?php
// Include the database configuration file
include 'Database.php';

if (isset($_POST['submit'])) {
  $name = $_POST['name'];
  $phone_no = $_POST['phone_no'];
  $address = $_POST['address'];

  // Insert data into database
  $query = "INSERT INTO registration_details (name, phone_no, address) VALUES ('$name', '$phone_no', '$address')";
  $result = mysqli_query($conn, $query);
  if ($result) {
    echo "Data inserted successfully!";
  } else {
    echo "Error inserting data: " . mysqli_error($conn);
  }
}

if (isset($_POST['update'])) {
  $name = $_POST['name'];
  $phone_no = $_POST['phone_no'];
  $address = $_POST['address'];

  // Update data in database
  $query = "UPDATE registration_details SET phone_no='$phone_no', address='$address' WHERE name='$name'";
  $result = mysqli_query($conn, $query);
  if ($result) {
    echo "Data updated successfully!";
  } else {
    echo "Error updating data: " . mysqli_error($conn);
  }
}

if (isset($_POST['delete'])) {
  $name = $_POST['name'];

  // Delete data from database
  $query = "DELETE FROM registration_details WHERE name='$name'";
  $result = mysqli_query($conn, $query);
  if ($result) {
    echo "Data deleted successfully!";
  } else {
    echo "Error deleting data: " . mysqli_error($conn);
  }
}

// Close database connection
mysqli_close($conn);
?>