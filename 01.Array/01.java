//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
class GFG {
    class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;

        }
    }

    Pair res = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

    Pair getMinMax(int[] arr, int arr_size) {

        for (int i = 0; i < arr_size; i++) {
            res.min = Math.min(res.min, arr[i]);
            res.max = Math.max(res.max, arr[i]);

        }
        return res;
    }

    public static void main(String args[]) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = 6;
        GFG gfg = new GFG();

        Pair minmax = gfg.getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }

}
