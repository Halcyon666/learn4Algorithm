package leetcode.simple;

import java.util.HashMap;

/**
 * 第一题
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TwoSum {
    public static void main(String[] args) {

        int nums[] = new int[] {-1,-2,-3,-4,-5};
        int target = -8;
        int[] rt= twoSum1(nums,target);
        for (int i : rt) {
            System.out.println("i = " + i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {

                for (int j = 0; j < nums.length; j++) {
                    if (i<j&& target == nums[i]+nums[j])
                        return new int[]{i,j};

            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
       HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i]))
                return new int[]{hashMap.get(target-nums[i]), i};
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }

}