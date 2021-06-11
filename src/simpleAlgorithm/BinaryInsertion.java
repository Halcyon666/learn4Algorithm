package simpleAlgorithm;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/9 22:05
 */
public class BinaryInsertion {
    public static void main(String[] args) {
        int[] arr = {-1, 20, -3, -10, 100, -255};
        int[] ints = binaryInsertion(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : ints)
            sb.append(i).append(" ");
        System.out.println("sb = " + sb);
    }

    public static int[] binaryInsertion(int[] arr) {
        int n = arr.length;
        // 3 -1 2
        for (int i = 1; i < n; i++) {
            int x = arr[i];// 表示要排序的数值
            int left = 0, right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (x > arr[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            // 将从 right+1 到 i-1位置的元素后移一位
            for (int j = i - 1; j >= right + 1; j--)
                arr[j + 1] = arr[j];

            // 退出循环是high+1就是x要插入的位置
            arr[right + 1] = x;
        }
        return arr;
    }
}
