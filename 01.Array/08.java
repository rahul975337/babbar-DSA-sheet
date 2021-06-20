
//https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1#
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class app08 {
    class Pair {
        private int value;
        private int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }

    }

    int getMinDiff(int[] arr, int n, int k) {

        ArrayList<Pair> possibleHeights = new ArrayList<>();
        int[] visited = new int[n];
        // adding arr[i]-k and arr[i]+k to the list along with the arr[i] index
        for (int i = 0; i < arr.length; i++) {
            // arr[i]-k to the list
            if (arr[i] - k >= 0)
                possibleHeights.add(new Pair(arr[i] - k, i));
            // arr[i]+k to the list
            possibleHeights.add(new Pair(arr[i] + k, i));
            visited[i] = 0;
        }
        // sorting the list based on the values
        Collections.sort(possibleHeights, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return (p1.getValue() - p2.getValue());
            }
        });
        // sliding the window and taking the window such that there are all the indexes
        // present in that window
        // this we will know if the visited[] is fully marked with 1
        // left and right are the pointers to the window
        // ele is the count of distinct indexes in the window
        int ele = 0;
        int left = 0;
        int right = 0;
        int size = possibleHeights.size();
        while (ele < n && right < size) {
            // if the index is not visited we do ele++
            if (visited[possibleHeights.get(right).getIndex()] == 0)
                ele++;
            // add the element everytime to increase the window until all n indees are
            // visited
            visited[possibleHeights.get(right).getIndex()]++;
            right++;
        }
        // current ans i.e.; the min height after first window
        int ans = possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue();
        // now sliding the window one by one by removing the firstt ele and adding the
        // last ele
        while (right < size) {
            // remove leftmost ele from window
            if (visited[possibleHeights.get(left).getIndex()] == 1)
                ele--;
            visited[possibleHeights.get(left).getIndex()]--;
            left++;

            // add the elements to the new window untill all n indexes are visited
            while (ele < n && right < size) {
                if (visited[possibleHeights.get(right).getIndex()] == 0)
                    ele++;
                visited[possibleHeights.get(right).getIndex()]++;
                right++;
            }
            // with every window we caluclate the min of new minimized height and the old
            // one
            if (ele == n)
                ans = Math.min(ans, possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue());
            // if in the window we couldn't find all n indexes visited and the right reached
            // size , it is not possible to get the min anymore
            // so we get out of all the loops and return the value of ans whatever we have
            // till now
            else
                break;
        }

        return ans;

    }
}