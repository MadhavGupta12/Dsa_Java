public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(countSubsequences(s, t, 0, 0)); 
    }

    public static int countSubsequences(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        int inc = 0, exc = 0;
        if (s.charAt(i) == t.charAt(j)) {
            inc = countSubsequences(s, t, i + 1, j + 1); 
        }
        exc = countSubsequences(s, t, i + 1, j); 

        return inc + exc;
    }
}
