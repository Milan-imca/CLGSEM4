public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = { 4, 7, 11, 17, 19, 20, };
    int target = 20;
    int result = search(arr, target);
    if (result != -1) {
      System.out.println(target + " was found in " + result + " position");
    } else {
      System.out.println(target + " was element was not found!");
    }
  }

  public static int search(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

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

}
