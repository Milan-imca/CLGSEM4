
//Implementation of DEQUE : (double ended queue)
import java.util.Scanner;

class Double_Ended {
  int front = -1;
  int rear = -1;
  int size = 0;
  int[] arr = new int[5];

  // Inserting value at the rear
  public void insertRear(int value) {
    if (isFull()) {
      System.out.println("Queue is full!!");
      return;
    } else if (isEmpty()) {
      front = rear = 0;
      arr[0] = value;
    } else if (rear < arr.length - 1) {
      arr[++rear] = value;
    } else if (rear == arr.length - 1) {
      rear = 0;
      arr[0] = value;
    }
    size++;
  }

  // Removing element from the front
  public int removeFront() {
    if (isEmpty()) {
      System.out.println("Queue is empty!");
      return -1;
    } else if (front == arr.length - 1) {
      int value = arr[front];
      front = 0;
      size--;
      return value;
    } else {
      int value = arr[front];
      front++;
      size--;
      return value;
    }
  }

  // Inserting value at the front
  public void insertFront(int value) {
    if (isFull()) {
      System.out.println("Queue is full!!");
      return;
    } else if (isEmpty()) {
      front = rear = 0;
      arr[0] = value;
    } else if (front > 0) {
      arr[--front] = value;
    } else if (front == 0) {
      front = arr.length - 1;
      arr[front] = value;
    }
    size++;
  }

  // Removing element from the rear
  public int removeRear() {
    if (isEmpty()) {
      System.out.println("Queue is empty!");
      return -1;
    } else if (rear == 0) {
      int value = arr[rear];
      rear = arr.length - 1;
      size--;
      return value;
    } else {
      int value = arr[rear];
      rear--;
      size--;
      return value;
    }
  }

  // To check if the queue is empty
  public boolean isEmpty() {
    // return size == 0;
    if (size == 0) {
      return true;
    }
    return false;
  }

  // To check if the queue is full
  private boolean isFull() {
    if (size == arr.length) {
      return true;
    }
    return false;
  }

  // To display the queue
  public void display() {
    if (isEmpty()) {
      System.out.println("Queue is empty!!");
      return;
    }

    if (front <= rear) {
      for (int i = front; i <= rear; i++) {
        System.out.print(arr[i] + " ");
      }
    } else {
      for (int i = front; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      for (int i = 0; i <= rear; i++) {
        System.out.print(arr[i] + " ");
      }
    }
  }
}

public class DoubleEnded {
  public static void main(String[] args) {
    Double_Ended c = new Double_Ended();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println(
          "\nEnter the choice :\n1:Insert at Rear\n2:Remove from Front\n3:Insert at Front\n4:Remove from Rear\n5:Exit");
      int ch = sc.nextInt();

      switch (ch) {
        case 1:
          int x;
          System.out.println("Enter the value you want to insert at rear");
          x = sc.nextInt();
          c.insertRear(x);
          c.display();
          break;

        case 2:
          c.removeFront();
          c.display();
          break;

        case 3:
          System.out.println("Enter the value you want to insert at front");
          x = sc.nextInt();
          c.insertFront(x);
          c.display();
          break;

        case 4:
          c.removeRear();
          c.display();
          break;

        case 5:
          System.exit(0);
          break;

        default:
          System.out.println("Invalid selection!!");
          break;
      }
    }
  }
}
