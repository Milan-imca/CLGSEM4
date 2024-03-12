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

  public void insert(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
      newNode.next = null;
    } else {
      tail.next = newNode;
      newNode.next = null;
      tail = newNode;
    }
  }

  public void remove() {
    Node temp = head;
    if (temp == null) {
      System.out.println("Linked List is empty!");
    } else if (temp.next == null) {
      System.out.println("Removed element : " + head.value);
      head = null;
      return;
    } else {
      System.out.println("Removed element : " + head.value);
      head = temp.next;
    }
  }

  public void display() {
    Node temp = head;
    if (temp == null) {
      System.out.println("Linked List is empty!");
    } else {
      while (temp != null) {
        System.out.print(temp.value + " -> ");
        temp = temp.next;
      }
      System.out.print("null");
    }
    System.out.println();
  }
}

public class QueueImplementation {
  public static void main(String[] args) {
    LL l = new LL();
    l.display();
    l.insert(1);
    l.insert(2);
    l.insert(3);
    l.display();
    l.remove();
    l.display();
    l.remove();
    l.display();
  }
}
