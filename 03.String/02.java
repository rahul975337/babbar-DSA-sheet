
//https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
import java.util.HashMap;
import java.util.Map;

class app02a {
    public static void main(String[] args) {
        String s = "GeeksForGeeks";
        removeDups(s);
    }

    static void removeDups(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;
        for (int i = 0; i < 256; i++)
            if (count[i] > 1)
                System.out.println((char) i + "    " + count[i]);
    }
}

class app02b {
    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        printDups(str);
    }

   static void printDups(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        /*
         * Store duplicates present in the passed string
         */
        for (int i = 0; i < str.length(); i++) {
            if (!count.containsKey(str.charAt(i)))
                count.put(str.charAt(i), 1);
            else
                count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
        }

        /* Print duplicates in sorted order */
        for (Map.Entry mapElement : count.entrySet()) {
            char key = (char) mapElement.getKey();
            int value = ((int) mapElement.getValue());

            if (value > 1)
                System.out.println(key + ", count = " + value);
        }
    }
}