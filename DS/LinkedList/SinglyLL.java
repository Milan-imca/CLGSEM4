import java.util.Scanner;

// Node class!
class Node {
  int value;
  Node next;

  Node(int value) {
    this.value = value;
  }
}

// Single Linked List class!
class Sl {
  // variables needed!
  Node head = null;
  Node tail = null;
  int size = 0;

  public void insertAtFirst(int value) {
    Node newNode = new Node(value);

    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }

    size++;
  }

  public void insertAtIndex(int value, int index) {
    Node newNode = new Node(value);
    Node temp = head;
    if (index == 1) {
      insertAtFirst(value);
    } else {
      for (int i = 2; i <= index - 1; i++) {
        temp = temp.next;
      }
      if (temp == null) {
        System.out.println("Location invalid");
      } else {
        newNode.next = temp.next;
        temp.next = newNode;
      }

    }
  }

  public void insertAtLast(int value) {
    Node newNode = new Node(value);
    Node temp = head;
    if (tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.next = null;
    }

  }

  public void deleteFirstNode() {
    Node temp = head;
    if (head == null) {
      System.out.println("Linked list is empty!!");
    } else {
      temp = temp.next;
      System.out.println("Element deleted - " + head.value);
      head = temp;
    }
  }

  public void deleteLastNode() {
    Node temp = head;
    if (tail == null) {
      System.out.println("Linked list is empty!!");
    } else if (temp.next == null) {
      System.out.println("Element deleted : " + tail.value);
      tail = null;
      head = null;
      return;
    } else {
      while (temp.next.next != null) {
        temp = temp.next;
      }
      System.out.println("Element Deleted : " + temp.next.value);
      temp.next = null;
      tail = temp;
    }
  }

  public void deleteAtIndex(int index) {
    Node temp = head;
    if (head == null) {
      System.out.println("Linked List is Empty");
    } else if (index == 1) {
      deleteFirstNode();
    } else {
      for (int i = 2; i <= index - 1; i++) {
        temp = temp.next;
      }

      if (temp == null) {
        System.out.println("Invalid location to delete the Node!");
      } else {
        System.out.println("Element Delete is : " + temp.next.value);
        temp.next = temp.next.next;
      }
    }
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }
}

public class SinglyLL {

  public static void main(String[] args) {
    Sl l = new Sl();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Press 1 : To insert at First.");
      System.out.println("Press 2 : To insert at Last.");
      System.out.println("Press 3 : To insert at your desired index.");
      System.out.println("Press 4 : To Delete from First.");
      System.out.println("Press 5 : To Delete from Last.");
      System.out.println("Press 6 : To Delete from desired index");
      System.out.println("Press 7 : To Exit.");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Insert at First");
          System.out.println("Enter the value to insert : ");
          int firstVal = sc.nextInt();
          l.insertAtFirst(firstVal);
          l.display();
          break;

        case 2:
          System.out.println("Insert at Last");
          System.out.println("Enter the value to insert : ");
          int lastVal = sc.nextInt();
          l.insertAtLast(lastVal);
          l.display();
          break;

        case 3:
          System.out.println("Insert at Desired Index.");
          System.out.println("Enter the value to insert : ");
          int value = sc.nextInt();
          System.out.println("Enter the index :");
          int index = sc.nextInt();
          l.insertAtIndex(value, index);
          l.display();
          break;

        case 4:
          System.out.println("Delete from first");
          l.deleteFirstNode();
          l.display();

          break;
        case 5:
          System.out.println("Delete from last ");
          l.deleteLastNode();
          l.display();
          break;

        case 6:
          System.out.println("Delete from the desired index:");
          System.out.println("Enter the index for deleting the Node : ");
          int location = sc.nextInt();
          l.deleteAtIndex(location);
          l.display();

          break;
        case 7:
          System.exit(0);
          break;

        default:
          System.out.println("Invalid selection!!");
          break;
      }
    }

  }
}
