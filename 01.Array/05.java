//https://leetcode.com/problems/intersection-of-two-arrays/

//USING SETS
import java.util.HashSet;
import java.util.Set;

class app05 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int num : nums1)
            set1.add(num);

        for (int i = 0; i < nums2.length; i++)
            if (set1.contains(nums2[i]))
                res.add(nums2[i]);

        int ans[] = new int[res.size()];
        int idx = 0;
        for (int i : res)
            ans[idx++] = i;

        return ans;
    }
}

// USING SET INTERSECTION METHOD
class app050 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (Integer n : nums1)
            set1.add(n);
        Set<Integer> set2 = new HashSet<>();
        for (Integer n : nums2)
            set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1)
            output[idx++] = s;
        return output;
    }
}

//