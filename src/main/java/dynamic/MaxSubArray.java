package dynamic;

/**
 * 类说明:offer42 连续子树组的最大和
 *
 * 以[-2,1,-3,4,-1,2,1,-5,4]为例：
 * max表示连续子数组的最大和
 * sum表示从0到i构成的子数组的最大和
 *
 * @author zengpeng
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sum = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            sum = sum + nums[i];
            max = Math.max(Math.max(sum,nums[i]),max);
            if(sum < nums[i]){
                sum = nums[i];
            }
        }


        return max;
    }
}
