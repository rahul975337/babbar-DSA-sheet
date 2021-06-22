//https://leetcode.com/problems/rotate-string/solution/
class app04 {
    public boolean rotateString(String A, String B) {
        String temp = A + A;
        return A.length() == B.length() && (temp).contains(B);
    }
}