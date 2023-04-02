import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

class SolutionForce {
    public int[] twoSum(int[] nums, int target) {
        int[] res = { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            int mid = target - nums[i];
            res[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == mid) {
                    res[1] = j;
                    break;
                }
            }
            if (res[1] != -1)
                break;
        }
        return res;
    }
}

// @lc code=start
/**
 * 暴力求解的方式会带来更多的时间开销
 * 在第二层循环中，找 target - nums[i] 的时间可以用空间省略
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(nums[i]))
                return new int[] { i, hashTable.get(nums[i]) };
            hashTable.put(target - nums[i], i);
        }
        return null;
    }
}
// @lc code=end