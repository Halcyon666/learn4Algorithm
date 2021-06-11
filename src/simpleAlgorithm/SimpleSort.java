package simpleAlgorithm;


/**
 * @Author: WhaleFall541
 * @Date: 2021/4/4 16:08
 */
public class SimpleSort {

    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {-1, 20, -3, -10, 100, -255};
        int[] arr = {-1111, 20, -3, -10, 100, -255};
//        selectSort(arr);
        bubble1(arr);
//        insertSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");
        System.out.println("sb = " + sb);

    }

    // 插入排序
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 需要将i插入到前面子序列
            if (arr[i] < arr[i - 1]) {
                int k = arr[i], j;
                // i为要插入的元素,j为i往前的元素
                // 如果arr[j]比k大 则把arr[j]元素往后挪
                // 如果arr[j]比k小则直接插入元素在空位上
                for (j = i - 1; j >= 0 && arr[j] > k; j--)
                    arr[j + 1] = arr[j];
                // 将元素放到比k小的后面
                arr[j + 1] = k;
            }
        }
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

    // 冒泡排序
    private static void bubble1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean f = false;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j-1, j);
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
