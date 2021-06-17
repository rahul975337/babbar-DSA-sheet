//https://leetcode.com/problems/reverse-string/
class app00 {
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low < high) {
            swap(s, low++, high--);
        }
    }

    void swap(char[] arr, int low, int high) {
        char temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}