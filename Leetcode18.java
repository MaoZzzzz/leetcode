import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public static void main(String[] args) {
        int[] test = new int[]{1000000000, 1000000000, 1000000000, 1000000000};

        System.out.println(fourSum(test, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[left] + (long) nums[right] + (long) nums[i] + (long) nums[j];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[left], nums[right], nums[i], nums[j]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
