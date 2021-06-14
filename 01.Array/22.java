//https://leetcode.com/problems/maximum-product-subarray/
class app22 {
    public int maxProduct(int[] nums) {
        int maxTillNow = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int storeMax = currMax;
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(storeMax * nums[i], currMin * nums[i]));
            maxTillNow = Math.max(currMax, maxTillNow);
        }

        return maxTillNow;
    }
}