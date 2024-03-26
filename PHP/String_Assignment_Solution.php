<?php 
  //  1. Write a PHP script to remove comma(s) from the following numeric string.
  //  Sample String : '2,543.12'
  //  Expected Output : 2543.12

  // $string = '2,543.12';
  // $numeric_string = str_replace(',', '', $string);
  // echo $numeric_string."<br>";

 //   2. Write a PHP script to select first 5 words from the following string.
 // Sample String : 'The quick brown fox jumps over the lazy dog'
 // Expected Output : 'The quick brown fox jumps'

  // $string = 'The quick brown fox jumps over the lazy dog';
  // $string_arr = str_word_count($string,1);

  // for($i=0;$i<5;$i++){
  //   echo $string_arr[$i]." ";
  // }

 // 3. Write a PHP script to get the first word of a sentence.
 // Original String : 'The quick brown fox'
 // Expected Output : 'The'


 // $string = 'The quick brown fox';
 // $string_arr = str_word_count($string,1);
 // echo $string_arr[0];


 //  4. Write a PHP script to insert a string at the specified position in a given string.
 // Original String : 'The brown fox'
 // Insert 'quick' between 'The' and 'brown'.
 // Expected Output : 'The quick brown fox'

  // $str = 'The brown fox';
  // $before = substr($str, 0,4);
  // $after = substr($str,4);
  // // echo $before."<br>";
  // // echo $after;
  // $insert_str = 'quick';
  // echo "Actual string : ".$str."<br>";
  // $result =  $before." ".$insert_str." ".$after."<br>";
  // echo "Result String : ".$result;


// 5. Write a PHP script to extract the user name from the following email ID.
// Sample String : 'rayy@example.com'
// Expected Output : 'rayy

// $str = 'rayy@example.com';sfsf
// $arr = str_split($str);
// // print_r($arr);
// $i=0;
// while($arr[$i] != '@'){
//   echo $arr[$i];
//   $i++;
// }



/*6. Write a PHP script to :
a) transform a string all uppercase letters.
b) transform a string all lowercase letters.
c) make a string's first character uppercase.
d) make a string's first character of all the words uppercase.*/

// $str = 'milan poria';
// echo 'Uppercase All letters : '.strtoupper($str)."<br>";

// $str2 = 'MILAN';
// echo 'Lowercase All letters : '.strtolower($str2)."<br>";

// echo 'First Character Uppercase :'.ucfirst($str)."<br>";

// echo 'Uppercase to all first Character of word : '.ucwords($str)."<br>";




// 7. Write a PHP script to split the following string.
// Sample string : '082307'
// Expected Output : 08:23:07

// $str = '082307';
// $arr = str_split($str,2);
// $result_string = implode(':',$arr);
// echo $result_string;


/*8. Write a PHP script to check if a string contains a specific string?
Sample string : 'The quick brown fox jumps over the lazy dog.'
Check whether the said string contains the string 'jumps'.*/


// $str = 'The quick brown fox jumps over the lazy dog.';
// $search_str = 'jumps';
// $result = strpos($str, $search_str);
// if($result!== false ){
//   echo "Found!";
// }
// else{
//   echo 'not found!';
// }

// 9. Write a PHP script to extract the file name from the following string.
// Sample String : 'www.example.com/public_html/index.php'
// Expected Output : 'index.php'

// $str = 'www.example.com/public_html/index.php';
// $last_slash = strrpos($str, '/');
// $file_name = substr($str, $last_slash+1);
// echo "file name : ".$file_name;



// 10. Write a PHP script to change following cases of the string.
// a) Uppercase
// b) Lowercase
// c) First word of string to uppercase
// d) First character of string to uppercase


// (same as Question 6)

?>
