package com.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆排序
 */
public class HeapSort {
    /**
     * 方式1：这种方式利用java提供的堆对象PriorityQueue来实现排序
     *
     * @param arr
     */
    public static void heapSort1(int[] arr) {
        //大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        //构建一个k个大小的堆
        for (int i = 0; i < arr.length - 1; i++)
            q.offer(arr[i]);
        for (int i = arr.length - 1; i < arr.length; i++) {
            //较小元素入堆
            if (q.peek() > arr[i]) {
                q.poll();
                q.offer(arr[i]);
            }
        }



    }

    /**
     * 方式2：这种方式相当于手写堆排序，即从源码角度实现
     *
     * @param arr
     */
    public static void heapSort2(int[] arr) {
        // 1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2.将堆顶元素与末尾元素交换，将最大元素沉到数组末端。
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        // k表示第i个节点的左子节点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // k指向了右子节点
            }
            if (arr[k] > temp) { // 如果子节点大于父节点
                arr[i] = arr[k]; // 把两个子节点中较大的值赋值父节点
                i = k; // !!! i指向k,继续循环比较
            } else {
                break;
            }
        }
        // 当for循环结束之后，我们已经将以i为父节点的树的最大值，放在了最顶（局部）
        arr[i] = temp; // 将temp值放到调整后的位置
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, 8, 5, 9, 11, -1, 33};
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
