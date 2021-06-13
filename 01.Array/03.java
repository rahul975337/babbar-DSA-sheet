//https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;// for 0
        int mid = 0;// for 1
        int high = nums.length - 1;// for 2

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high--);
            }
        }
    }

    void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

    }
}