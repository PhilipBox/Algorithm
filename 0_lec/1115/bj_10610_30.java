package _1115;

import java.util.*;
public class bj_10610_30 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        int[] arr = new int[numStr.length()];
        int sum = 0;
        for(int i = 0 ; i < numStr.length(); i++) {
            sum += Integer.parseInt(numStr.charAt(i)+"");
            arr[i] = Integer.parseInt(numStr.charAt(i)+"");
        }

        if(numStr.contains("0") && sum % 3 == 0) {
            Arrays.sort(arr);
            reverseArrayInt(arr);
            for(int i : arr)
                System.out.print(i);
            }
        else System.out.println("-1");

    }
     public static void reverseArrayInt(int[] array) {
            int temp;

            for (int i = 0; i < array.length / 2; i++) {
              temp = array[i];
              array[i] = array[(array.length - 1) - i];
              array[(array.length - 1) - i] = temp;
            }
          }

}