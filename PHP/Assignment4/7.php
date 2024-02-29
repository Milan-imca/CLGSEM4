<!-- Q:7 Write a PHP script to send email to any email address. -->
<!-- ⚠️ its not working -->
<?php
$to_email = "milanporia99@gmail.com";
$subject = "Test Email";
$body = "This is a test email sent from PHP.";
$headers = "From: milan.imca22@gmail.com";

// Send email
if (mail($to_email, $subject, $body, $headers)) {
  echo "Email sent successfully to $to_email";
} else {
  echo "Email sending failed...";
}
?>

