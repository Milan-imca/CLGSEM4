package Dec8_23;
import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int s = 0;
        int e = arr.length;
        int mid = s + (e-s) / 2;

        System.out.println("Original Array : " + Arrays.toString(arr));
        int size1 = mid; // size of first half array : (ignore the reassignment)
        int size2 = e - mid; // size of second half array
        int arraySize = arr.length;
        int[] firstArray = new int[size1];
        int[] secondArray = new int[size2];

        int i=0;
        int j=0;
        int k=0;
        
        while(arraySize>0){
            if(arraySize<=size1){
                firstArray[j++] = arr[i++];
            }
            else{
                secondArray[k++] = arr[mid++];
            }
            arraySize--;
        }

        System.out.println( "First Half Array : " + Arrays.toString(firstArray));
        System.out.println( "Second Half Array : " + Arrays.toString(secondArray));

    }
}
