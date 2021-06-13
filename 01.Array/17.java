//https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

//NAIVE O(n^2)
class app17 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if ((i != j) && (nums[i] + nums[j] == target)) {
                    res[0] = i;
                    res[1] = j;
                }

            }
        }
        return res;
    }
}

// EFFICIENT

class app170 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement) && map.get(complement) != i) {
                res[0] = i;
                res[1] = map.get(complement);
            }
            map.put(nums[i], i);

        }

        return res;
    }
}