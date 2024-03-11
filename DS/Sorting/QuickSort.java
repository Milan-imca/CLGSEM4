import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int arr[] = { 6, 5, 4, 3, 2, 1 };
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr, int startIdx, int endIdx) {
    if (startIdx >= endIdx) {
      return;
    }
    int start = startIdx;
    int end = endIdx;
    int mid = start + (end - start) / 2;
    int pivot = arr[mid];
    while (start <= end) {
      while (arr[start] < pivot) {
        start++;
      }
      while (arr[end] > pivot) {
        end--;
      }
      if (start <= end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
      }
    }
    sort(arr, startIdx, end - 1);
    sort(arr, start, endIdx);
  }
}