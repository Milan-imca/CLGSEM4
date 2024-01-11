//Implementation of Stack using array:
class Stack {
  int i = 0;
  int size = 0;
  int[] arr = new int[5];

  public void push(int value) {
    if (size == arr.length) {
      System.out.println("\nStack is full!!");
    } else {
      arr[i++] = value;
      size++;
    }
  }

  public int pop() {
    if (size == 0) {
      System.out.println("Stack is empty");
      return -1;
    } else {
      int peek = arr[i - 1];
      arr[i - 1] = 0;
      i--;
      size--;
      return peek;
    }
  }

  public int peek() {
    if (size == 0) {
      System.out.println("Stack is empty");
      return -1;
    } else {
      return arr[i - 1];
    }
  }

  public void display() {
    if (size == 0) {
      System.out.println("stack is empty!!");
    } else {
      for (int idx = 0; idx < i; idx++) {
        System.out.print(arr[idx] + " ");
      }
    }
  }
}

public class StackDemo {
  public static void main(String[] args) {
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.display();
    s.push(6); // stack is full
    s.pop();
    s.display(); // 5 will be popped bcoz its the peek element in the stack
    s.pop();
    System.out.println( "\nPeek element is : " + s.peek());
  }
}