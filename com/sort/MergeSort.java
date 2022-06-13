package com.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }


    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        mid = (left + right) / 2;
        while (i <= mid && j <= right) {
            if (array[i] > array[j]) {
                temp[t] = array[j];
                t++;
                j++;
            } else {
                temp[t] = array[i];
                t++;
                i++;
            }
        }

        while (i <= mid) {
            temp[t] = array[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = array[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
