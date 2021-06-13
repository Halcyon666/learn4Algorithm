package simpleAlgorithm;


import java.util.Arrays;

/**
 * @Author: WhaleFall541
 * @Date: 2021/4/4 16:08
 * 算法思维：从`0`到`n-1`每次取一个为`i`， 和i后面的元素进行比较
 * 令`int k = i;`如果发现比`i`位置上的还小，则将该位置的角标赋值给k。
 * 最后交换i 和 k的位置；每一趟都能排好一个最小的值。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {-1111, 20, -3, -10, 100, -255};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //选择排序
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;// i是要排序的数下标
            // 跟i下标后面的每个元素比较记录下来arr[k]最小的k值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j])
                    k = j;
            }

            // 最小的arr[k] 和 当前排序位置arr[i]互换
            swap(arr, i, k);
        }
    }


    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
