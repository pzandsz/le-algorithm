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
     * 不超时解法，自下而上迭代
     * 思路：定义dp[i]为考虑前i个元素，以第i个数字结尾的最长上升子序列的长度，注意nums[i]必须被选取
     *
     * 我们从小到大计算 dp[]数组的值，在计算 dp[i]之前，我们已经计算出 dp[0...i-1]的值，则状态转移方程为：
     *
     * dp[i] = max(dp[j]) + 1,其中, 0 <= j < i 且 num[j] < num[i]
     *
     * 即考虑往 dp[0…i−1] 中最长的上升子序列后面再加一个 nums[i]。
     * 由于 dp[j] 代表 nums[0…j] 中以nums[j] 结尾的最长上升子序列，
     * 所以如果能从 dp[j] 这个状态转移过来，那么nums[i] 必然要大于nums[j]，
     * 才能将nums[i] 放在nums[j] 后面以形成更长的上升子序列。
     *
     * 最后，整个数组的最长上升子序列即所有 dp[i]中的最大值。
     *
     * LIS_length = max(dp[i]), 其中 0≤i<n

     *
     */
    public int lengthOfLIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            //maxval表示前一个的最大值
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;

            //maxans表示0~i组成的数组的最大长度
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
