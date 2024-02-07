
//Circular Linked List (Singly)
import java.util.Scanner;

class Node {
  int value;
  Node next;

  Node(int value) {
    this.value = value;
  }
}

class CircularLinkedList {
  Node head = null;
  Node tail = null;

  // to insert the node at first :
  public void insertAtFirst(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
      newNode.next = head;
    } else {
      newNode.next = head;
      head = newNode;
      tail.next = head; // Update the next pointer for circularity
    }
  }

  // to insert the node at last :
  public void insertAtLast(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
      newNode.next = tail;
      return;
    }
    tail.next = newNode;
    newNode.next = head;
    tail = newNode;
  }

  // insert node at particular location 
  public void inserAtLocation(int value, int index) {
    Node newNode = new Node(value);

    if (index < 1) {
      System.out.println("Invalid index!Index should be atleast 1.");
      return;
    }

    if (index == 1 || head == null) {
      insertAtFirst(value);
      return;
    }

    Node temp = head;
    for (int i = 1; i < index - 1; i++) {
      if (temp == tail) {
        System.out.println("Index out of bound . Cannot be inserted at index " + index);
        return;
      }
      temp = temp.next;
    }

    newNode.next = temp.next;
    temp.next = newNode;

    if (temp == tail) {
      tail = newNode;
    }

  }

  // delete first node :
  public void deleteFirstNode() {
    if (head == null) {
      System.out.println("List is empty. Cannot delete.");
      return;
    }
    System.out.println("First Element Deleted : " + head.value);
    if (head.next == head) {
      // Only one node in the list
      head = null;
    } else {
      Node temp = head;
      while (temp.next != head) {
        temp = temp.next;
      }
      temp.next = head.next;
      head = head.next;
    }

  }

  // delete last node:
  public void deleteLastNode() {
    if (tail == null) {
      System.out.println("Linked List is empty!!");
      return;
    }

    System.out.println("Last Element Deleted: " + tail.value);

    if (tail == head) {
      tail = head = null;
    } else {
      Node temp = head;
      while (temp.next != tail) {
        temp = temp.next;
      }
      temp.next = head; // Remove the reference to the tail node
      tail = temp;
    }
  }

  // delete from the paritcular location
  public void deleteFromLocation(int index) {
    if (head == null) {
      System.out.println("Linked List empty ! Cannot Delete");
      return;
    }
    if (index == 1) {
      deleteFirstNode();
    } else {
      Node temp = head;
      for (int i = 1; i < index - 1; i++) {
        temp = temp.next;
      }
      System.out.println("Element Deleted : " + temp.next.value);
      temp.next = temp.next.next;

    }
  }

  // display function
  public void display() {

    Node temp = head;
    if (head == null) {
      System.out.println("Linked List is Empty!");
      return;
    }
    if (temp != null) {
      do {
        System.out.print(temp.value + " -> ");
        temp = temp.next;
      } while (temp != head);
    }
    System.out.println();
  }
}

public class CircularLL {
  public static void main(String[] args) {
    CircularLinkedList l = new CircularLinkedList();

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Press 1 : Insert At First");
      System.out.println("Press 2 : Insert At Last");
      System.out.println("Press 3 : Insert At Particular Location");
      System.out.println("Press 4 : Delete First Node");
      System.out.println("Press 5 : Delete Last Node");
      System.out.println("Press 6 : Delete From Particular Location ");
      System.out.println("Press 7 : Exit");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Insert At First");
          System.out.println("Enter the value for Node : ");
          int firstValue = sc.nextInt();
          l.insertAtFirst(firstValue);
          l.display();
          break;

        case 2:
          System.out.println("Insert At Last");
          System.out.println("Enter the value for Node : ");
          int lastValue = sc.nextInt();
          l.insertAtLast(lastValue);
          l.display();
          break;

        case 3:
          System.out.println("Insert At Particular Location");
          System.out.println("Enter the value for Node : ");
          int value = sc.nextInt();
          System.out.println("Enter the index/ Location in linked list : ");
          int location = sc.nextInt();
          l.inserAtLocation(value, location);
          l.display();
          break;

        case 4:
          System.out.println("Delete First Node");
          l.deleteFirstNode();
          l.display();
          break;

        case 5:
          System.out.println("Delete Last Node");
          l.deleteLastNode();
          l.display();
          break;

        case 6:
          System.out.println("Delete At Particular Location");
          System.out.println("Enter the index/ Location in linked list to delete the Node : ");
          int index = sc.nextInt();
          l.deleteFromLocation(index);
          l.display();
          break;

        case 7:
          System.exit(0);
          break;

        default:
          break;
      }

    }
  }
}
