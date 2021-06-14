
//https://leetcode.com/problems/majority-element-ii/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//NAIVE
class app24 {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3)
                res.add(entry.getKey());
        }

        return res;
    }
}

//EFFICIENT
