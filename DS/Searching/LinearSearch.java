public class LinearSearch {
  public static void main(String[] args) {
    int[] arr = { 10, 20, 30, 40, 50 };
    int target = 900;
    int result = search(arr, target);
    if (result == -1) {
      System.out.println(target + " was not found in the array");
    } else {
      System.out.println(target + " was found in the array in " + result + "th position");
    }
  }

  public static int search(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
}