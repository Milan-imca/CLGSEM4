<?php
//String functions
$str = "Milan Poria";
$str2 = "gls university";
echo "Lower Case - " . strtolower($str) . "<br>";
echo "Upper Case -" . strtoupper($str) . "<br>";
echo "Upper Case first character - -" . ucfirst($str) . "<br>";
echo "Lower Case first character - -" . lcfirst($str) . "<br>";
echo "First letter uppercase of words : " . ucwords($str2) . "<br>";
echo "Length of str : " . strlen($str) . "<br>";
echo "Reverse of str : " . strrev($str) . "<br>";
echo strpos($str, "Poria") . "<br>";
$search = "Milan";
if (strpos($str, $search) !== false) {
  echo "{$search} found! <br>";
} else {
  echo "{$search} not found <br>";
}

$str3 = "This is a Book";
$newstr3 = str_replace("Book", "Laptop", $str3);
echo "{$str3} <br>";
echo "{$newstr3} <br>";

$arr = array("ff", "bgmi", "apex legend");
print_r(str_replace("ff", "FF", $arr, $i));
echo " Replacement : {$i}  <br>";


print_r(str_split($str)); //by default 1 split
echo "<br>";
print_r(str_split($str, 2)); //by default 1 split
echo "<br>";

$str_words = str_word_count($str);
echo "There are {$str_words} words  in {$str} <br>";
print_r(str_word_count($str));
echo "<br>";
print_r(str_word_count($str, 2));
echo "<br>";

$str_comp = strcmp("Ashish", "Milan");
echo "{$str_comp} <br>";

echo substr($str, 2) . "<br>";
echo substr($str, -1) . "<br>";
echo substr($str, 0, 5) . "<br>";
echo substr($str, 6, 10) . "<br>";


$string = "Hello, world! This is a test.";
$token = strtok($string, " ");
while ($token !== false) {
  echo "$token<br>";
  $token = strtok(" ");
}
echo str_repeat("M ", 13) . "<br>";

echo substr_count("Hello Milan,Hello there!", "Hello") . "<br>";
?>