//https://leetcode.com/problems/maximum-subarray/
class app12 {
    public int maxSubArray(int[] nums) {
        int maxTillNow = nums[0];
        int currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxTillNow = Math.max(currMax, maxTillNow);
        }

        return maxTillNow;
    }
}