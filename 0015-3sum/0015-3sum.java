import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to easily skip duplicates and use two pointers

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // The sum of the other two numbers should be the negative of the current number

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for the second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate elements for the third number
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results;
    }
}