package com.search;

/**
 * 二分查找法，需要数组有序，降序升序都可以
 *
 * @author smluo
 * @date 2022/05/25
 */
public class BinarySearch {
    /**
     * @param array:   待查找的数组, 这里按照升序数组处理
     * @param left：左索引
     * @param right:   右索引
     * @param target:  待查找的元素
     * @return
     */
    public static int BinarySearch(int[] array, int left, int right, int target) {
        // 左索引大于索引说明没有在数组找到对应元素，递归出口
        if (left > right) {
            return -1;
        }

        int midIndex = (left + right) / 2;
        if (target > array[midIndex]) {
            return BinarySearch(array, midIndex + 1, right, target);
        } else if (target < array[midIndex]) {
            return BinarySearch(array, left, midIndex - 1, target);
        } else {
            return midIndex;
        }
    }

    public static int find(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        return BinarySearch(array, 0, array.length - 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {-1, 3, 5, 7, 8, 12, 15};
        System.out.println(find(arr, 12));
        System.out.println(find(arr, 40));
    }
}
