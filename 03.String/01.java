//https://practice.geeksforgeeks.org/problems/palindrome-string0817/1#

//Method 1 - Iterative
class app01a {
    int isPlaindrome(String S) {
        // code here
        int len = S.length();
        int low = 0;
        int high = len - 1;

        while (low < high) {
            if (S.charAt(low++) != S.charAt(high--))
                return 0;

        }
        return 1;
    }
}

// Method 2 - Recursive
class app01b {

    boolean checkPalindrome(String str, int s, int e) {
        if (s == e)
            return true;

        if ((str.charAt(s)) != (str.charAt(e)))
            return false;

        if (s < e + 1)
            return checkPalindrome(str, s + 1, e - 1);
        return true;
    }

    boolean isPalindrome(String str) {
        int n = str.length();

        if (n == 0)
            return true;
        return checkPalindrome(str, 0, n - 1);
    }

}

// Method 3 - Recursive
class app01c {
    int isPlaindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return 1;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPlaindrome(s.substring(1, s.length() - 1));
        return 0;
    }
}
