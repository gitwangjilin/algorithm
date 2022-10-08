package com.example.algorithm.elementary_1.code_1;

public class Code04_EvenTimesOddTimes {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        doubleSwap(a, b);
        int[] arr1 = new int[]{11, 11, 14, 14, 15};
        printOddTimesNum1(arr1);
        int[] arr2 = new int[]{11, 11, 14, 14, 15, 16};
        printOddTimesNum2(arr2);

    }

    /**
     * 数组中有两种数，出现奇数次
     *
     * @param arr
     */
    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        // 0110010000
        // 0000010000
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOn
            // e=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 数组中只有一种数，出现奇数次
     *
     * @param arr1
     */
    private static void printOddTimesNum1(int[] arr1) {
        int number = 0;
        for (int i = 0; i < arr1.length; i++) {
            number ^= arr1[i];
        }
        System.out.println(number);
    }

    /**
     * 两数交换
     *
     * @param a
     * @param b
     */
    private static void doubleSwap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
