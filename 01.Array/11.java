//https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

//NAIVE O(NLogN)
class app11 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, idx = 0; i < m + n; i++)
            nums1[i] = nums2[idx++];
        Arrays.sort(nums1);
    }
}

// EFFICIENT O(n)
class app110 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;

        while (p2 >= 0 && p1 >= 0)// comparing and adding the elements of nums1 and nums2 in sorted way
        {
            if (nums1[p1] > nums2[p2])
                nums1[p3] = nums1[p1--];
            else
                nums1[p3] = nums2[p2--];
            p3--;
        }

        while (p2 >= 0) // Adding the left over elements of nums2 that may be greater than the elements
                        // of num1;
        {
            nums1[p3--] = nums2[p2--];
        }
    }
}