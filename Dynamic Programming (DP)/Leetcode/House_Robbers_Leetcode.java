package Dynamic_programming;

import java.util.Arrays;

public class House_Robbers_Leetcode {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {2, 7, 9, 3, 1};
        System.out.println(sol.rob(nums));  
    }
}

class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(dp, nums, 0);
    }

    public static int helper(int dp[], int nums[], int idx) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int a = nums[idx] + helper(dp, nums, idx + 2); 
        int b = helper(dp, nums, idx + 1);            

        dp[idx] = Math.max(a, b);
        return dp[idx];
    }
}
