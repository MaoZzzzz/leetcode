
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2242 👎 0

package Temp.leetcode.editor.cn;

//java:在排序数组中查找元素的第一个和最后一个位置
class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 两种模板的联系和使用场景
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0) return new int[]{-1,-1};

            int left = 0;
            int right = nums.length - 1;
            int mid = 0;

            // 模板一：要求的是找到最小的值，那么右边界需要变小，对应的等号就是模板一
            while (left < right) {
                mid = (left + right) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (nums[right] != target) {
                return new int[]{-1, -1};
            }
            int resLeft = right;
            left = 0;
            right = nums.length - 1;
            // 模板二：要求找到最大值，左边界需要变大，对应等号是模板二
            while (left < right) {
                mid = (left + right + 1) / 2;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return new int[]{resLeft, right};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}