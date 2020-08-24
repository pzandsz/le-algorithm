package dynamic;

/**
 * 类说明: 最低票价
 *
 * @author zengpeng
 */
public class MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[366];
        for(int i=1;i<dp.length;i++){
            if(i-1 < 0){
                dp[days[i]]=Math.max(costs[0],dp[days[i]]);
            }else{
                dp[days[i]]=Math.max(dp[days[i]-1]+costs[0],dp[days[i]]);
            }
            if(days[i]-7 < 0){
                dp[days[i]]=Math.max(costs[1],dp[days[i]]);

            }else {
                dp[days[i]]=Math.max(dp[days[i]-7]+costs[1],dp[days[i]]);
            }

            if(days[i]-30 < 0){
                 dp[days[i]]=Math.max(costs[2],dp[days[i]]);
            }else {
                dp[days[i]]=Math.max(dp[days[i]-30]+costs[2],dp[days[i]]);
            }
        }

        return dp[days[days.length-1]];
    }
}
