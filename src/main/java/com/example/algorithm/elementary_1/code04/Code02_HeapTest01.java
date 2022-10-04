package com.example.algorithm.elementary_1.code04;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code02_HeapTest01
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/26   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code02_HeapTest01 {
    public static void main(String[] args) {
        int[] arrs = {3, 45, 12, 45, 75, 0};
        MyMaxHeap myMaxHeap = new MyMaxHeap(arrs.length);
        for (int i = 0; i < arrs.length; i++) {
            myMaxHeap.put(arrs[i]);
        }
        int ans = myMaxHeap.pop();
    }
}

class MyMaxHeap {
    private int[] heap;
    private final int limit;
    private int heapSize;

    public MyMaxHeap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public void put(int arr) {
        if (heapSize == limit) {
            throw new RuntimeException("已满");
        }
        heap[heapSize] = arr;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapify(heap, 0, heapSize);
        return ans;
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}