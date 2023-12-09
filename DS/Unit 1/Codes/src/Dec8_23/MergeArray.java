package Dec8_23;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,90,100};
        int[] arr2 = {6, 7, 8, 9, 10,123};

        int size = arr.length + arr2.length;
        int[] newArray = new int[size];

        int i=0;
        int j=0;
        int k =0;

        //awesome Code as per complexity:
        while(size>0){

            if(i<arr.length){
                newArray[i++] = arr[j++];
            }
            else{
                newArray[i++] = arr2[k++];
            }

            size--;
        }
        System.out.println(Arrays.toString(newArray));

        //not good (complexity wise)
//        for(int j=0;j<arr.length;j++){
//            newArray[i++] = arr[j];
//        }
//        for(int j=0;j<arr2.length;j++){
//            newArray[i++] = arr2[j];
//        }
        
    }


}
