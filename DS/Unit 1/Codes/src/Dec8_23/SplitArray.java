package Dec8_23;
import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int s = 0;
        int e = arr.length;
        int mid = s + (e-s) / 2;

        System.out.println("Original Array : " + Arrays.toString(arr));
        int size1 = mid; // size of first half array : (ignore the reassignment)
        int size2 = e - mid; // size of second half array

        int[] firstArray = new int[size1];
        int[] secondArray = new int[size2];

        for(int i=0;i<size1;i++){
            firstArray[i] = arr[i];
        }

        System.out.println("First Array : " + Arrays.toString(firstArray));

        for(int i=0;i<size2;i++){
            secondArray[i] = arr[mid + i];
        }
        System.out.println("Second Array : " + Arrays.toString(secondArray));

    }
}
