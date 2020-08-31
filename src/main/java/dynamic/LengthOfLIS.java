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
        if(nums[index] > max){
            String key=index + "" + max;
            Integer integer = cache.get(key);
            if(integer != null){
                return integer;
            }
            //选中nums[index] 不选中nums[index]
            int tmp=nums[index];
            index++;
            int max1 = Math.max(lengthOfLIS2(nums, tmp, index) + 1, lengthOfLIS2(nums, max, index));
            cache.put(key,max1);
            return max1;
        }
        index++;
        return lengthOfLIS2(nums,max,index);
    }
}
