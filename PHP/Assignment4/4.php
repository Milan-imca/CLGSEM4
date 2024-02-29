<!DOCTYPE html>
<html>

<head>
  <title>Upload Image</title>
</head>

<body>
  <h1>Upload Image</h1>
  <form action="" method="post" enctype="multipart/form-data">
    <!-- <input type="file" name="image" accept=".jpg, .jpeg">  '😎 A cheat hack directly use accept'-->
    <input type="file" name="image">
    <input type="submit" name="submit" value="Upload">
  </form>

  <?php
  if (isset($_POST['submit'])) {
    $file_name = $_FILES['image']['name'];
    $file_size = $_FILES['image']['size'];
    $file_tmp = $_FILES['image']['tmp_name'];
    $file_type = $_FILES['image']['type'];

    // Check if file type is jpg or jpeg
    if ($file_type == 'image/jpeg' || $file_type == 'image/jpg') {
      // Move the uploaded file to the desired location
      move_uploaded_file($file_tmp, "images/" . $file_name);
      // Redirect to a success page
      header("Location: 4Success.php");
      exit();
    } else {
      echo "Only JPEG and JPG files are allowed.";
    }
  }
  ?>
</body>

</html>