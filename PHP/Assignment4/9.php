<!-- Q.9 Create a class Product which contains product id, product name, price and quantity. Use constructor and destructor. -->
<?php
class Product
{
  public $product_id;
  public $product_name;
  public $price;
  public $quantity;



  public function __construct($product_id, $product_name, $price, $quantity)
  {
    $this->product_id = $product_id;
    $this->product_name = $product_name;
    $this->price = $price;
    $this->quantity = $quantity;


    echo "Product id :" . $this->product_id . "<br>";
    echo "Product name :" . $this->product_name . "<br>";
    echo "Product price :" . $this->price . "<br>";
    echo "Product quantity :" . $this->quantity . "<br>";
  }


  public function __destruct()
  {
    echo "Product id : " . $this->product_id . " destructed <br>";
  }
}


$Laptop = new Product(1, "MacBook", 250000, 1);
$iPad = new Product(2, "Ipad", 60000, 1);
?>