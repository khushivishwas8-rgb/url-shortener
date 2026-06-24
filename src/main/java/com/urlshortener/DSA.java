package com.urlshortener;

import java.util.HashMap;
import java.util.Map;

public class DSA {
    public static int countNumber(int[] arr1, int target) {
        //time = o(1)
        //space = o(1)
        int count = 0;
        for (int num : arr1) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static int linearSearch(int[] num, int target) {
        //time =o(n)---> not sure maybe be because it grows exactly with size of input
        //space = o(1)
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //pallindrome
    public static boolean isPalindrome(int[] arr7) { // method

        int i = 0;
        int j = arr7.length - 1;

        while (i < j) {
            if (arr7[i] != arr7[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    // binary search

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
        //time complexity:o(log n)
        //space complexity:
    }

    public static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

            // converting back to string


        }
        return new String(arr);
        //time complexity = o(n)
        //space complexity =
    }





    public static void main(String[] args) {
// find the largest number in the given block
        // time= o(n)--> as it start from [0] but nested loop is also there and linear time -> because it check every
        //   element .
        //space=o(1)
        int[] number1 = {3, 7, 1, 9, 4};
        int largest1 = number1[0];

        for (int nums : number1) {
            if (nums > largest1) {
                largest1 = nums;

            }
        }

        System.out.println("The largest number is:" + largest1);

        int[] number2 = {15, 2, 8, 15, 6};
        int largest2 = number2[0];
        for (int num : number2) {
            if (num > largest2) {
                largest2 = num;
            }
        }

        System.out.println("Largest number is " + largest2);


        //sum
        //time =o(1)
        //space = o(1)
        int[] number = {1, 2, 3, 4, 5};
        int sum = 0;  // start sum from 0
        for (int num : number) {
            sum = sum + num;
        }
        System.out.println("sum is" + sum);


        //find the smallest thing:

        int[] number3 = {3, 7, 1, 9, 4}; // list of numbers
        int smallest = number3[0]; // considering the 1st number as the smallest number
        for (int num : number3) {  // looking at each number if the current number is smaller than 1st number
            if (num < smallest) {   // take the current number.
                smallest = num; // update the smallest number
            }
        }
        System.out.println("Smallest number is " + smallest);


        //reverse the array

        int[] arr = {1, 2, 3, 4, 5};
        int i = 0; //start with 0 index
        int j = arr.length - 1;// last index of the array


        while (i < j) {// to swap 1st with the last until we reach at the middle
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            --j;
        }
        //print reversed array;
        for (int num : arr) {
            System.out.print(num + " ");
        }


        // loop and counting
        //time =
        //space = 0(1)
        int[] arr2 = {1, 2, 1, 3, 1, 4};
        int result = countNumber(arr2, 2);
        System.out.println("count " + result);

        int[] arr4 = {22, 35, 22, 78, 22};
        result = countNumber(arr4, 22);
        System.out.println("count " + result);


        //LinerSearch

        int[] arr0 = {10, 20, 30, 40};
        result = (linearSearch(arr0, 30));
        System.out.println("Index " + result);

        int[] arr5 = {10, 20, 30, 40};
        result = (linearSearch(arr5, 90));
        System.out.println("Index " + result);

        int[] arr6 = {5, 15, 25};
        result = (linearSearch(arr6, 30));
        System.out.println("Index " + result);

        //palindrome
        int[] array = {1, 2, 3, 2, 1};
        boolean check = isPalindrome(array);
        System.out.println("Is palindrome: " + check);

        //binarySearch
        int[] arr8 = {10, 20, 30, 40, 50};
        int searchResult = binarySearch(arr8, 30);
        System.out.println("Index " + searchResult);

        //String
        //reverse the string

        String word1 = "Hello";
        System.out.println(reverseString(word1));

        String word2 = "Khushi";
        System.out.println(reverseString(word2));
    }

    // two sum --->bruteforce approach
//    // Input:  {2, 7, 11, 15}, target = 9
//    int[] nums = {2, 7, 11, 15};
//
//    // i am checking each pair
//    for(
//    int i = 0;
//    i<nums.length;i++)
//
//    {
//        for (int j = i + 1; j < nums.length; j++) {
//            //check the sum of each pair
//            if (nums[i] + nums[j] == target) {
//                return new int[]{i, j};
//
//            }
//        }
//    }
//    return new int[]
//
//    {
//    }

    ;// if no pair found
    // time complexity =0(n square)--> we use nested loop
    //space complexity = 0(1) ---> we use fixed number of variable

}
