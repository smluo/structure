package com.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] array, int l, int r) {
        // ***********l >= r限制作用？？？？？******************
        if (l >= r) {
            return;
        }
        int left = l, right = r;
        int pivot = array[left];
        while (left < right) {
            // *******left<right限制作用？？？？？*************
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = pivot;
        quickSort(array, l, left - 1);
        quickSort(array, left + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        String a = "AbCd";
        char c = a.charAt(0);
        c+=32;
        System.out.println(c);
        System.out.println(a + c);
    }
}
