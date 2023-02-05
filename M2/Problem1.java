package M2;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        //Don't edit anything here
        int[] a1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a2 = new int[]{0, 1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int[] a3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] a4 = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        
        processArray(a1);
        processArray(a2);
        processArray(a3);
        processArray(a4);
    }
    static void processArray(int[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        System.out.println("Odds output:");
        //TODO add/edit code here

        /* mhk42, 2/23/23, the code loops through the array arr and checks if each element is odd or not.
        /* If an element is odd, it is printed to the console. If an element is even, it continues to the next element.
         * The code is also checking if the current iteration index i is not the last index in the array arr. If it is not, a variable j is declared and set to i + 1. 
         * A while loop is then run, where j is incremented until either j reaches the end of the array arr or the current value at arr[j] is even. 
         * If j has not reached the end of the array, a comma is printed. This is to print the odd numbers like an array.
         */
        System.out.print("[");
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 != 0)
            {
                System.out.print(arr[i]);
                if(i != arr.length - 1)
                {
                    int j;
                    j = i + 1;
                    while(j < arr.length && arr[j] % 2 == 0)
                    {
                        j++;
                    }
                    if(j < arr.length)
                    {
                        System.out.print(", ");
                    }
                }
            }
        }
        System.out.print("]");
        //end add/edit section
        System.out.println();
        System.out.println("End process");
    }
    
}