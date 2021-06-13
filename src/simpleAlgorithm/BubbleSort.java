package simpleAlgorithm;

import java.util.Arrays;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/12 23:22
 * 算法思维：第一层for循环控制趟数，第二层for循环从j=0和j=1开始比较
 * 如果发现前面比后面大则互换位置
 * 优化：当第一趟下来 没有元素交换，说明该数组已经有序了不需要排序
 */
public class BubbleSort {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {-1111, 20, -3, -10, 100, -255};
        bubble(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 冒泡排序
    private static void bubble(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean f = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    f = true;
                }
            }
            if (!f) return;
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
