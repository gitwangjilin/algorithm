package com.example.algorithm.elementary_1.code03;

import java.util.Arrays;

public class Code03_PartitionAndQuickSort {

    public static void main(String[] args) {
        int[] arr = {1223, 123, 1, 432, 635, 234};
        quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        quickSort3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort3(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        int[] equalArea = netherlandsFlag(arr, left, right);
        process3(arr, left, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, right);
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, left, right);
        process2(arr, left, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, right);
    }

    //荷兰国旗问题
    public static int[] netherlandsFlag(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        //小于区相等下标
        int lees = left - 1;
        //大于区相等下标
        int more = right;
        int index = left;
        while (index < more) {
            //如果和最后一个相当，只需要移动遍历下标，小于区不用动
            if (arr[index] == arr[right]) {
                index++;
                //如果值小于最右值，则lees移动一位，遍历下标加一
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++lees);
                //如果大于则，遍历坐标不用到，more减一，上面while循环会控制结束
            } else {
                swap(arr, index, --more);
            }
        }
        //因取值是最右边，所有需要把最右边的值放在中间区域的最右边
        swap(arr, more, right);
        return new int[]{lees + 1, more};
    }

    private static void quickSort1(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);

    }

    private static void process1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //将数组中以right为常数做比较，得到小于在左边大于在右边的数据，返回中位数，然后左右遍历
        //总结：一次排序可得可以确定right在数组中的位置
        // 例如：{23, 123, 1, 432, 635, 234}
        // 223  {23, 123, 1, 234, 635, 432} 可以确认234在数组中的位置切不用在变
        int m = partition(arr, left, right);
        process1(arr, left, m - 1);
        process1(arr, m + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        //定义一个数组最左边在减一个值：做临时变量做划分大小的一个坐标位置
        int lees = left - 1;
        int index = left;
        while (index < right) {
            //遍历数组和最右边比较，如果比最右边小，临时变量加+1和当前数进行交换，最终得到小于right的在左边，大于right的右边
            if (arr[index] <= arr[right]) {
                swap(arr, index, ++lees);
            }
            index++;
        }
        //因一直拿最右边做比较，最后需要将最右边值放在less后的一个位置
        swap(arr, ++lees, right);
        return lees;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
