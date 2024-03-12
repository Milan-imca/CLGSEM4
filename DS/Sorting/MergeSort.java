import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1 };
    divide(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));

  }

  public static void divide(int[] arr, int startIdx, int endIdx) {
    if (startIdx >= endIdx) {
      return;
    }
    int mid = startIdx + (endIdx - startIdx) / 2;
    divide(arr, startIdx, mid);
    divide(arr, mid + 1, endIdx);

    merge(arr, startIdx, mid, endIdx);
  }

  public static void merge(int[] arr, int startIdx, int mid, int endIdx) {
    int[] mergedArr = new int[endIdx - startIdx + 1];
    int i = startIdx;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= endIdx) {
      if (arr[i] <= arr[j]) {
        mergedArr[k++] = arr[i++];
      } else {
        mergedArr[k++] = arr[j++];
      }
    }

    while (i <= mid) {
      mergedArr[k++] = arr[i++];
    }
    while (j <= endIdx) {
      mergedArr[k++] = arr[j++];
    }

    for (int l = 0; l < mergedArr.length; l++) {
      arr[startIdx++] = mergedArr[l];
    }
  }

}
