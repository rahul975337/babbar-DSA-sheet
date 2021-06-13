// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.*;

//NAIVE
class naive02 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

//BETTER
class app02 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a - b);
        // array to heap
        for (int num : nums) {
            heap.add(num);
        }

        // kth largest element pops
        int result = -1;
        for (int i = 0; i < nums.length - k + 1; i++) {
            result = heap.poll();
        }
        return result;
    }
}

// BEST
//TODO: QUICK SELECT METHOD