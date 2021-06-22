
//https://www.geeksforgeeks.org/print-subsequences-string/
import java.util.ArrayList;
import java.util.List;

class app09 {
    static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        printSubseq("abcd", "");
        System.out.println(list);
    }

    static void printSubseq(String s, String ans) {
        if (s.length() == 0) {
            list.add(ans);
            return;
        }
        printSubseq(s.substring(1), ans + s.charAt(0));
        printSubseq(s.substring(1), ans);
    }
}