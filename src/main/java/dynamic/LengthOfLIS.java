package dynamic;

import java.util.HashMap;

/**
 * 类说明: 最长上升子序列
 *
 *  [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @author zengpeng
 * 所属类型： i的最优解不仅仅取决于i-1,还取决于i-k
 * 缓存cache并没有很好的优化程序的性能
 */
public class LengthOfLIS {
    HashMap<String,Integer> cache =new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS2(nums,Integer.MIN_VALUE,0);
    }

    public int lengthOfLIS2(int[] nums,int max,int index) {
        if(nums.length - index < 1){
            return 0;
        }
        String key1=index + "" + 1;
        if(nums[index] > max){

            String key2=index + "" + 2;
            Integer integer1 = cache.get(key1);
            Integer integer2 = cache.get(key1);

            if(integer1 != null && integer2 != null){
                return Math.max(integer1,integer2);
            }
            if(integer1 != null){
                return integer1;
            }
            if(integer2 != null){
                return integer2;
            }
            //选中nums[index] 不选中nums[index]
            int tmp=nums[index];
            index++;
            int max1 =lengthOfLIS2(nums, tmp, index) + 1;
            int max2 = lengthOfLIS2(nums, max, index);
            cache.put(key1,lengthOfLIS2(nums, tmp, index) + 1);
            cache.put(key2,lengthOfLIS2(nums, max, index));

            return Math.max(max1,max2);
        }

        Integer integer1 = cache.get(key1);
        if(integer1 != null){
            return integer1;
        }

        index++;
        int i = lengthOfLIS2(nums, max, index);
        cache.put(key1,i);
        return i;
    }


    /**
     * 不超时解法
     */
    public int lengthOfLIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
