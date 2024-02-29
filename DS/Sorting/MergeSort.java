import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = { 16, 41, 67, 54, 52, 74 };
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
    int size = endIdx - startIdx + 1;
    int mergedArr[] = new int[size];
    int idx1 = startIdx;
    int idx2 = mid + 1;
    int x = 0;

    while (idx1 <= mid && idx2 <= endIdx) {
      if (arr[idx1] <= arr[idx2]) {
        mergedArr[x++] = arr[idx1++];
      } else {
        mergedArr[x++] = arr[idx2++];
      }
    }

    while (idx1 <= mid) {
      mergedArr[x++] = arr[idx1++];
    }
    while (idx2 <= endIdx) {
      mergedArr[x++] = arr[idx2++];
    }

    int j = startIdx;
    int i = 0;
    while (i < mergedArr.length) {
      arr[j++] = mergedArr[i++];
    }

  }
}
