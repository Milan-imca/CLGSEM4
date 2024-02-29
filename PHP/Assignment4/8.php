<!-- Q.8 Create a class Employee which contains eid, ename, basic salary. Calculate net salary and display it. -->
<!-- Net salary = Basic + HRA + DA – PF in php -->
<?php 
  class Employee{
    public $eid;
    public $ename;
    public $BASIC;
    public $hraPercentage=0.1;
    public $daPercentage=0.2;
    public $pfPercentage=0.05;

    public function __construct($eid,$ename,$BASIC){
      $this->eid = $eid;
      $this->ename = $ename;
      $this->BASIC = $BASIC;
    }


    public function displayNetSalary(){
      $HRA = $this->BASIC * $this->hraPercentage;
      $DA = $this->BASIC * $this->daPercentage;
      $PF = $this->BASIC * $this->pfPercentage;

      $Net_salary = $this->BASIC + $HRA + $DA - $PF;

      echo "Employee id :".$this->eid."<br>";
      echo "Employee name :".$this->ename."<br>";
      echo "Net Salary : ".$Net_salary;
    }
  }


  $emp1 = new Employee("1","Ash",50000);
  $emp1->displayNetSalary();
?>