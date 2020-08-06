package dynamic;

/**
 * 类说明: 08.11. 硬币:给定数量不限的硬币，币值为25分、10分、5分和1分，
 * 编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *  dp[i][j]表示
 *  dp[i][j] =
 *  dp[i-1][j] + dp[i-1][j-coins[i]] + dp[i-1][j-2*coins[i]] + ... dp[i-1][j-k*coins[i]]
 * @author zengpeng
 */
public class WaysToChange {

    int mod = 1000000007;
    int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] f =new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % mod;
            }
        }
        return f[n];

    }

    public static void main(String[] args) {
        WaysToChange change = new WaysToChange();
        System.out.println(change.waysToChange(50));
    }
}
