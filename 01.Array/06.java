// https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/

class app06 {
    static void rotateByOne(int[] arr) {
        int x = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = x;
    }
}