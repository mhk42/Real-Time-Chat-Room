package M2;

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        //Don't edit anything here
        Integer[] a1 = new Integer[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        Integer[] a2 = new Integer[]{-1, 1, -2, 2, 3, -3, -4, 5};
        Double[] a3 = new Double[]{-0.01, -0.0001, -.15};
        String[] a4 = new String[]{"-1", "2", "-3", "4", "-5", "5", "-6", "6", "-7", "7"};
        
        bePositive(a1);
        bePositive(a2);
        bePositive(a3);
        bePositive(a4);
    }
    static <T> void bePositive(T[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        //your code should set the indexes of this array
        Object[] output = new Object[arr.length];

        //TODO convert each value to positive
        //set the result to the proper index of the output array
        //hint: don't forget to handle the data types properly

        /* mhk42, 2/3/23, the code loops through each element in the input array.
         * It checks the type of the current element, checks if its less than 0
         * and performs a type-specific operation to convert it to a positive value
         * using Math.abs() and adds it to output.
         * For string elements, it converts the string to an integer.
         * 
         * 
         */
        for(int i=0; i < arr.length; i++)
        {
        if(arr[i] instanceof Integer)
         {
            int x = (int) arr[i];
                if(x < 0)
                {
                    x = Math.abs(x);
                }   
            output[i] = x;
        }
        else if(arr[i] instanceof Double)
        {
            double x = (double) arr[i];
                if(x < 0)
                {
                    x = Math.abs(x);
                }
            output[i] = x;
        }
        else if(arr[i] instanceof String)
        {
            int x = Integer.parseInt((String) arr[i]);
                if(x < 0)
                {
                    x = Math.abs(x);
                }
            output[i] = x;
        }
}

        //end edit section

        StringBuilder sb = new StringBuilder();
        for(Object i : output){
            if(sb.length() > 0){
                sb.append(",");
            }
            sb.append(String.format("%s (%s)", i, i.getClass().getSimpleName().substring(0,1)));
        }
        System.out.println("Result: " + sb.toString());
    }
}