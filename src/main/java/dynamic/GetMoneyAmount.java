package dynamic;

/**
 * 猜数字II:
 * 思路:这道题不是使用二叉树来解决的
 * (1)解释dp[1][1]:
 * dp[1][1]是指只有一个数字1，我们以1作为分割点(猜的数)，赢得游戏所用钱的最小值，
 * 一看就知道，dp[1][1]=0。因为我们只能猜1，答案也只能是1，不用花钱
 *
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/dong-tai-gui-hua-c-you-tu-jie-by-zhang-xiao-tong-2/
 *
 */
public class GetMoneyAmount {


    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];

        //初始化dp数组
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=Integer.MAX_VALUE;
                if(i == j){
                    dp[i][j]=0;
                }
            }
        }

        for(int j=1;j<=n;j++){
            for(int i=1;i<j;i++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    if(k==i){
                        min = Math.min(dp[k+1][j]+k,min);
                    }else if(k>i&&k<j){
                        min = Math.min(min,Math.max(dp[i][k-1]+k,dp[k+1][j]+k));
                    }else if(k==j){
                        min = Math.min(min,dp[i][k-1]+k);
                    }
                }
                dp[i][j]=min;
            }
        }

        return dp[n+1][n+1];
    }

}