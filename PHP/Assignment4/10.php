<!-- Q.10 Create a class Student which contains roll no, name and marks of three subjects. Calculate percentage and display it. -->
<?php
class Student
{
  public $roll_no;
  public $name;
  public $mark1;
  public $mark2;
  public $mark3;

  public $total = 0;

  public $percentage = 0;


  public function __construct($roll_no, $name, $mark1, $mark2, $mark3)
  {
    $this->roll_no = $roll_no;
    $this->name = $name;
    $this->mark1 = $mark1;
    $this->mark2 = $mark2;
    $this->mark3 = $mark3;
  }

  public function calculate_percentage()
  {
    $this->total = $this->mark1 + $this->mark2 + $this->mark3;
    $this->percentage = $this->total / 3;
  }
  public function display_percentage()
  {
    echo "Roll no : " . $this->roll_no . "<br>";
    echo "Name : " . $this->name . "<br>";
    echo "Percentage :" . $this->percentage . "<br>";
  }

}



$Student1 = new Student(1, "Mira", 90, 90, 90);
$Student1->calculate_percentage();
$Student1->display_percentage();

$Student2 = new Student(2, "Riya", 85, 85, 85);
$Student2->calculate_percentage();
$Student2->display_percentage();

?>