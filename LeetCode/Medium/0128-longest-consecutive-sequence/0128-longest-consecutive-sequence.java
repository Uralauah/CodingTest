import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int ans = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}