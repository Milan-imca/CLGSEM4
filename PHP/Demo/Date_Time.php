<?php
// date function:
$curr_date = date('d/m/y'); //using variable to store date
echo "Today is : " . $curr_date . "<br>";

echo "Today is : " . date('D/M/Y') . "<br>";
echo "Today is : " . date('l') . "<br>";
echo "Today is : " . date("d F Y") . "<br>";
echo "Today is : " . date("d/m/y") . "<br>";
echo "Today is : " . date("d/F/y") . "<br>";
echo "March  is  having : " . date("t") . "days" . "<br>";


//time function:
date_default_timezone_set("Asia/Kolkata");
echo "Time is : " . date("h:i:s") . "<br>";
echo "Time is : " . date("H:i:s") . "<br>";
echo "Time is : " . date("H:i:s a") . "<br>";
echo "Time is : " . date("H:i:s A") . "<br>";

//mktime(hour,minute,second,month,day,year) 
$d = mktime(7, 7, 7, 11, 20, 2003);
echo "Created Date is : " . date("Y-m-d", $d) . "<br>";


//date_create() function:
$date = date_create("2003-11-20");
echo date_format($date, "d/F/Y") . "<br>";

$date = date_create("2003-11-20 4:5:00");
echo date_format($date, "d/F/Y H:i:s") . "<br>";


// strtotime function:
// $str = strtotime("20 November 2003");
$str = strtotime("now");
// echo "Date : ".date("d/F/Y H:i:s",$str)."<br>";

//getting 10 days later:
$custom_date = $str + (10 * 24 * 60 * 60);
echo "Custom date : " . date("d/m/y", $custom_date) . "<br>";

$next_monday = strtotime("next Monday");
$next_monday_1 = strtotime("last Monday");
echo "Next monday date : " . date('d/m/y', $next_monday) . "<br>";
echo "Last monday date : " . date('d/m/y', $next_monday_1) . "<br>";


$three_months = strtotime("+3 months", $str);
echo "Three months later : " . date('d/m/y', $three_months) . "<br>";

//dates difference
$date1 = new DateTime("2024-03-01");
$date2 = new DateTime("2024-03-10");
$diff = $date1->diff($date2);
echo "Difference : " . $diff->format('%R%a days') . "<br>";


//date_modify(object,modify)
$dt = date_create("2024-03-10");
date_modify($dt, "+1 day");
echo "Using date_modify function : " . date_format($dt, "Y-m-d") . "<br>";

//date_parse(date);
echo (date_parse("2024-03-10"));
?>

<?php
$date1 = date_create("2024-03-10");
$date2 = date_create("2024-03-11");
$diff = date_diff($date1, $date2);
echo "Difference : " . $diff->format("%R%a days")
  ?>