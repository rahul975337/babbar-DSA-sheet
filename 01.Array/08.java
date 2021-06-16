//https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
class app08 {
    public static void main(String[] args) {
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

        alternatePosNeg(arr);
        System.out.print("[ ");

        for (int i : arr) {
            System.out.print(i);
            if (i < arr.length - 1)
                System.out.print(",");
        }
        System.out.print(" ]");
    }

    static void alternatePosNeg(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        // modifying the array to all the positives first and then all the negatives
        while (low <= high) {
            if (arr[low] >= 0 && arr[high] >= 0) {// low + & high +
                low++;
            } else if (arr[low] >= 0 && arr[high] < 0) {// low + & high -
                low++;
                high--;
            } else if (arr[low] < 0 && arr[high] >= 0) {// low - & high +
                swap(arr, low++, high--);
            } else // low - & high -
                high--;
        }
        // now putting alternate positives and negatives
        // now low is at first negative num
        // we take two variables p(positive) starts at 0th index that is first pos ele
        // and n(negative) starts at low'th index that is first neg ele
        int p = 0;
        int n = low;

        while (n < arr.length && p < arr.length) {
            swap(arr, p + 1, n);
            p += 2;
            n += 1;
        }

    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}