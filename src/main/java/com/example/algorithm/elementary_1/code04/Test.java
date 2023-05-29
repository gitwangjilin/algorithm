package com.example.algorithm.elementary_1.code04;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2023 shangzhao.com
 * - File Name: Test
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2023/3/29   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {
    public static class Heap {
        private int[] heap;
        private int limit;
        private int heapSize;

        public Heap(int limit) {
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public void push(int num) {
            if (heapSize == limit) {
                throw new RuntimeException("数组已满");
            }
            heap[heapSize] = num;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            int max = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return max;
        }

        /**
         * 删除大根堆继续向下排序
         *
         * @param heap
         * @param index
         * @param heapSize
         */
        public void heapify(int[] heap, int index, int heapSize) {
            //找下个孩子位置
            int left = index * 2 + 1;
            //下个孩子位置不能超过总长度
            while (left < heapSize) {
                /**
                 * left + 1 < heapSize：判断有没有右孩子
                 *  heap[left + 1] > heap[left] ? left + 1 : left 左右两个孩子比较大小返回大的下标
                 */
                int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                //父节点和子节点比较大小，返回大的下标
                largest = heap[largest] > heap[index] ? largest : index;
                //如果父节点和子节点位置相同跳出循环
                if (largest == index) {
                    break;
                }
                //父子节点交换位置
                swap(heap, largest, index);
                //大的下标给index
                index = largest;
                //继续找下个坐标
                left = index * 2 + 1;
            }
        }

        //按照大根堆插入
        public void heapInsert(int[] heap, int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.push(8);
        heap.push(6);
        heap.push(3);
        heap.push(7);
        heap.push(4);
        heap.push(5);
        heap.push(2);
        System.out.println(Arrays.toString(heap.heap));
    }

}

