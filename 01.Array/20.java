
//Link -> https://leetcode.com/problems/subarray-sum-equals-k/
//Explaination -> https://www.youtube.com/watch?v=20v8zSo2v18
import java.util.HashMap;

class app20 {
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();// (sum,frequency)
        map.put(0, 1);// for sum = 0,freq = 1

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int complement = sum - k;
            if (map.containsKey(complement))
                count += map.get(complement);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // if sum is already present in map,increase its frequency otherwise create the
            // element with 0 frequency and add 1 freq to it

        }
        return count;
    }
}
