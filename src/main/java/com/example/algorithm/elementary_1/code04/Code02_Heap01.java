package com.example.algorithm.elementary_1.code04;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code02_Heap01
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/11/10   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code02_Heap01 {
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            //如果大于总大小就报以满
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            //默认直接在数组中添加进去
            heap[heapSize] = value;
            //heapSize维护下个坐标拿最后一个进行循环向上找父类
            heapInsert(heap, heapSize++);
        }

        private void heapInsert(int[] arr, int index) {
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

        // 用户此时，让你返回最大值，并且在大根堆中，把最大值删掉
        // 剩下的数，依然保持大根堆组织
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        // 从index位置，往下看，不断的下沉，
        // 停：我的孩子都不再比我大；已经没孩子了
        private void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                //判断堆的左右那个孩子大，以最大的为堆顶继续下走
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                //判断最大堆的值和父堆值是否相同，如果相同则可以判断是大顶堆
                largest = arr[largest] > arr[index] ? largest : index;
                //父堆比子堆大或者相等结束
                if (largest == index) {
                    break;
                }
                //一层一层的比较，将父和子堆进行交换
                swap(arr, largest, index);
                //将下级堆大的坐标给index为下次循环准备条件
                index = largest;
                //准备堆的下级
                left = index * 2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int curLimit = 9;
        MyMaxHeap my = new MyMaxHeap(curLimit);
        my.push(1);
        my.push(2);
        my.push(3);
        my.push(4);
        my.push(5);
        my.pop();
        my.push(6);
    }
}
