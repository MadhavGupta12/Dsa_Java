public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return bottom(nums1, nums2);
    }
    int rec(int [] nums1, int [] nums2, int n, int m){
        if(n < 0 || m < 0) return 0;

        int ans = 0;
        if(nums1[n] == nums2[m]){
            ans = 1 + rec(nums1, nums2, n-1, m-1);
        }else{
            int a = rec(nums1, nums2, n-1, m);
            int b = rec(nums1, nums2, n, m-1);
            ans = Math.max(a, b);
        }
        return ans;
    }

    
    int bottom(int []nums1, int [] nums2){
        int n = nums1.length;
        int m = nums2.length;

        int [][] dp = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    dp[i][j] = Math.max(a, b);
                } 
            }
        }
        return dp[n][m];
    }

}
    

