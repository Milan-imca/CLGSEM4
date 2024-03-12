//STACK IMPLEMENTAION USING LINKED LIST:

class Node {
  int value;
  Node next;

  Node(int value) {
    this.value = value;
  }
}

class LL {
  Node head = null;
  Node tail = null;

  public void push(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.next = null;
      tail = newNode;
    }
  }

  public void peek() {
    if (tail == null) {
      System.out.println("Linked List is empty!");

    } else {
      System.out.println("Peek element is : " + tail.value);
    }
  }

  public void pop() {
    Node temp = head;
    if (temp == null) {
      System.out.println("Linked List is emty");
    } else if (temp.next == null) {
      System.out.println("Popped Element was : " + tail.value);
      tail = null;
      head = null;
      return;
    } else {
      System.out.println("Popped Element was : " + tail.value);
      while (temp.next.next != null) {
        temp = temp.next;
      }
      temp.next = null;
      tail = temp;
    }
  }

  public void display(){
    Node temp = head;
    if(temp == null){
      System.out.println("Linked List is empty!");
    }
    else{
      while(temp != null)
      {
        System.out.print(temp.value + " -> ");
        temp=temp.next;
      }
      System.out.print("null");
    }
    System.out.println();
  }
  
}

public class StackImplementation {
  public static void main(String[] args) {
    LL l = new LL();
    l.push(1);
    l.push(12);
    l.push(13);
    l.push(14);
    l.display();
    l.pop();
    l.pop();
    l.peek();
    l.display();

  }
}
