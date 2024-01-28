import java.util.Scanner;

class Node {
  int value;
  Node prev;
  Node next;

  Node(int value) {
    this.value = value;
  }
}

class DoublyLinkedList {
  Node head = null;
  Node tail = null;

  // => Insert at First
  public void insertAtFirst(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  // => Insert at Last
  public void insertAtLast(int value) {
    Node newNode = new Node(value);
    if (tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }

  // => Insert at Particular Location
  public void inserAtLocation(int value, int index) {
    Node newNode = new Node(value);
    Node temp = head;

    if (index == 1) {
      insertAtFirst(value);
    } else {
      for (int i = 1; i < index - 1 && temp != null; i++) {
        temp = temp.next;
      }

      if (temp == null) {
        System.out.println("Invalid location!!");
      } else {
        newNode.next = temp.next;

        if (temp.next != null) {
          temp.next.prev = newNode;
        }

        newNode.prev = temp;
        temp.next = newNode;

        if (newNode.next == null) {
          tail = newNode; // Update tail if the new node is inserted at the end
        }
      }
    }
  }

  // => delete first node:
  public void deleteFirstNode() {
    if (head == null) {
      System.out.println("Linked List empty!!");
    } else {
      System.out.println("First Deleted Element was : " + head.value);
      if (head.next != null) {
        head = head.next;
        head.prev = null;
      } else {
        head = null;
        tail = null;
      }
    }
  }

  // delete the last node
  public void deleteLastNode() {
    if (tail == null) {
      System.out.println("Linked List Empty!!");
    } else {
      System.out.println("Last Deleted Element was : " + tail.value);
      if (tail.prev != null) {
        tail = tail.prev;
        tail.next = null;
      } else {
        tail = null;
        head = null;
      }
    }
  }

  // delete the node from particular location
  public void deleteAtIndex(int index) {
    Node temp = head;
    if (temp == null) {
      System.out.println("linked list is empty!!");
    } else if (index == 1) {
      deleteFirstNode();
    } else {
      for (int i = 1; i < index - 1 && temp != null; i++) {
        temp = temp.next;
      }

      if (temp == null || temp.next == null) {
        System.out.println("Invalid index!!");
      } else {
        System.out.println("Deleted Element was : " + temp.next.value);
        temp.next = temp.next.next;

        if (temp.next != null) {
          temp.next.prev = temp;
        } else {
          // If the deleted node was the last node, update the tail
          tail = temp;
        }
      }
    }
  }

  // => Display Method
  public void display() {

    if (head == null) {
      System.out.println("Linked List empty");
    } else {
      Node temp = head;
      while (temp != null) {
        System.out.print(temp.value + " -> ");
        temp = temp.next;
      }
      System.out.print("null");
    }
    System.out.println();
  }
}

public class DoublyLL {
  public static void main(String[] args) {
    DoublyLinkedList l = new DoublyLinkedList();
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
          l.deleteAtIndex(index);
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
