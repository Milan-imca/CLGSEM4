public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = { 10, 11, 90, 3, 34 };
    int target = 31;
    int result = search(arr, target);
    if (result != -1) {
      System.out.println(target + " was found ");
    } else {
      System.out.println(target + "  was not found!");
    }
  }

  public static int search(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    sort(arr);
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

}
