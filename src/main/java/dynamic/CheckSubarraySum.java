package dynamic;

/**
 * 类说明:523 连续的子数组之和
 *
 * 令dp[i][j]表示从i开始到j的子数组之和
 *
 * dp[i][j]=dp[i][j-1]+nums[j-1]
 *
 * @author zengpeng
 */
public class CheckSubarraySum {


    /**
     * 超出内存限制
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len < 2){
            return false;
        }

        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=nums[i];
            for (int j=i+1;j<len;j++){
                dp[i][j] = dp[i][j-1]+nums[j];
                if(k == 0){
                    //System.out.println("i"+i+",j"+j+":"+dp[i][j]);
                    if(dp[i][j] == 0){
                        return true;
                    }
                }else if(dp[i][j] % k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
