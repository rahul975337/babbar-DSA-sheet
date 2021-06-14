
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

// EFFICIENT => Boyre Moore Voting Algorithm
class app240 {
    public List<Integer> majorityElement(int[] nums) {
        // there can be max 2 numbers with freq > n/3 in an array let them be nums1 and
        // nums2
        int nums1 = -1;
        int count1 = 0;
        int nums2 = -1;
        int count2 = 0;
        int len = nums.length;
        // we find the 2 elements that have highest priority in that array
        for (int ele : nums) {
            if (nums1 == ele) // if we have already taken that num we incr count
                count1++;
            else if (nums2 == ele) // if we have already taken that num we incr count
                count2++;
            else if (count1 == 0) { // if the count of num1 is 0 that is either it has not been occupied or its
                                    // occurrences have been cancelled then we put the current ele in nums1 and make
                                    // its count equal to 1
                nums1 = ele;
                count1 = 1;
            } else if (count2 == 0) {// if the count of num2 is 0 that is either it has not been occupied or its
                                     // occurrences have been cancelled then we put the current ele in nums2 and make
                                     // its count equal to 1
                nums2 = ele;
                count2 = 1;
            } else { // if we don't have any of the above conditions then we just decrement the
                     // counts which results in cancellation of all the occurrences at some point of
                     // time
                count1--;
                count2--;
            }
        }
        // now we have found the most prior 2 elements now we see if any of them has
        // occurrences > n/3
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == nums1)
                count1++;
            else if (i == nums2)
                count2++;
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > len / 3)
            res.add(nums1);
        if (count2 > len / 3)
            res.add(nums2);
        return res;
    }
}