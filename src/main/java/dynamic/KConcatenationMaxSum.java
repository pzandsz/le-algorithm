package dynamic;

/**
 * 类说明: 1191 K次串联后最大子数组之和
 *
 * @author zengpeng
 */
public class KConcatenationMaxSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int tmp=0;
        int m=0;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
            tmp = tmp+arr[i];
            if(min>arr[i]){
                min = arr[i];
                m=i;
            }
            max=Math.max(Math.max(arr[i],tmp),max);
            if(tmp<0){
                tmp=0;
            }
        }

        if(sum<0){
            return max;
        }
        if(sum >= 0){

        }
        return 0;
    }


    /**
     * 获取最大前缀和
     * @return
     */
    public int getPreMax(){
        return 0;
    }

    /**
     * 获取最大后缀和
     */
    public int getSufMax(){
        return 0;
    }
}
