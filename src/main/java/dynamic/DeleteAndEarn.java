package dynamic;

import java.util.ArrayList;

/**
 * 类说明: 740删除与获得点数 （打家劫舍问题变种）
 *
 * @author zengpeng
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max=0;
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }

        //构建all数组
        int[] all = new int[max+1];
        for(int i=0;i<length;i++){
            all[nums[i]]+=1;

        }

        //动规
        int res=0;
        int dp[] = new int[max+1];
        dp[0]=all[0]*1;
        dp[1]=all[1]*1+dp[0];
        for(int i=2;i<dp.length;i++){
//            System.out.println("("+dp[i-1]+","+(dp[i-2]+all[i]*(i))+")");
            res=Math.max(dp[i-1],dp[i-2]+all[i]*(i));
            dp[i]=res;
        }

        return res;
    }

    public static void main(String[] args) {
        DeleteAndEarn earn = new DeleteAndEarn();
        int[] data={2,2,3,3,3,4};
        System.out.println(earn.deleteAndEarn(data));
    }
}
