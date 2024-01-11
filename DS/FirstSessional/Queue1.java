//implementation of Simple Queue using array:
class Queue {
  int front = -1;
  int rear = -1;
  int size = 0;
  int[] arr = new int[5];

  public void insert(int value) {
    if (size == arr.length) {
      System.out.println("Queue is full!!");
    } else if (size == 0) {
      rear = front = 0;
      arr[rear] = value;
      size++;
    } else {
      arr[++rear] = value; // rear++ => arr[rear] =value;
      size++;
    }
  }

  public int remove() {
    if (size == 0) {
      System.out.println("Queue is empty");
      return -1;
    } else {
      int value = arr[front];
      arr[front] = 0;
      front++;
      size--;
      return value;
    }
  }

  public void display() {
    if (size == 0) {
      System.out.println("Queue is empty!!");
    } else {
      for (int i = front; i <= rear; i++) {
        System.out.print(arr[i] + " ");
      }
    }
  }
}

public class Queue1 {
  public static void main(String[] args) {
    Queue q = new Queue();
    q.insert(1);
    q.insert(2);
    q.insert(3); 
    q.insert(4);
    q.insert(5);
    // q.insert(6);
    q.remove();
    q.display();
    // q.remove();
    // q.display();
  }
}
