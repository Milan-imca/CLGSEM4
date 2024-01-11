//circular Queue implementation:

import java.util.Scanner;

class Circular_Queue {
  int front = -1;
  int rear = -1;
  int size = 0;
  int[] arr = new int[5];

  // inserting value algorithm:
  public void insert(int value) {
    // if size is full
    if (size == arr.length) {
      System.out.println("Queue is full!!");
      return;
    }
    // if size is 0 i.e. queue is empty..
    else if (size == 0) {
      front = rear = 0;
      arr[0] = value;
    }

    // normal insert i.e. there is already an element in the queue:
    else if (rear < arr.length - 1) {
      arr[++rear] = value;
    }

    // when the rear reaches the end of array...
    else if (rear == arr.length - 1) {
      rear = 0;
      arr[0] = value;
    }

    size++;
  }

  // To remove the element from the queue:
  public int remove() {
    if (size == 0) {
      System.out.println("Queue is empty!");
      return -1;
    }

    else if (front == arr.length - 1) {
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

  // To display the queue:
  public void display() {
    // if size is zero... means stack is empty
    if (size == 0) {
      System.out.println("Stack is empty!!");
    }

    // if rear has not gone back of front
    else if (front <= rear) {

      for (int i = front; i <= rear; i++) {
        System.out.print(arr[i] + " ");
      }
    }

    // if rear is now behind the front;
    else if (rear <= front) {
      // printing first half from front -> end of array
      for (int i = front; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      // printing second half from 0 -> rear
      for (int i = 0; i <= rear; i++) {
        System.out.print(arr[i] + " ");
      }

    }
  }

}

public class CircularQueue {
  public static void main(String[] args) {
    Circular_Queue c = new Circular_Queue();
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("\nEnter the choice :\n1:Insert element\n2:Remove element\n3:Exit");
      int ch = sc.nextInt();

      switch (ch) {
        case 1:
          int x;
          System.out.println("Enter the value you want to insert");
          x = sc.nextInt();
          c.insert(x);
          c.display();
          break;

        case 2:
          c.remove();
          c.display();
          break;

        case 3:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid selection!!");
          break;
      }

    }
  }
}