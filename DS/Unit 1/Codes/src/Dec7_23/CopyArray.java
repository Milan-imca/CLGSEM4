package Dec7_23;

public class CopyArray {
    static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[arr1.length];

        for(int i=0;i<arr1.length;i++){
            arr2[i] = arr1[i];
        }
        System.out.println("First Array : ");
        printArray(arr1);
        System.out.println("\nSecond Array : ");
        printArray(arr2);
    }
}
