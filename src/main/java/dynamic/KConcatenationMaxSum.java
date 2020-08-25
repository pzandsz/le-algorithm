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
            if(k==1){
                return Math.max(getPreMax(arr),Math.max(max,0))%((int)Math.pow(10,9)  + 7 );
            }

            if(k==2){
                //System.out.println(getPreMax(arr)+","+getSufMax(arr));
                return Math.max(getPreMax(arr)+getSufMax(arr),Math.max(max,0))%((int)Math.pow(10,9)  + 7 );
            }
            //return Math.max(max,0)%((int)Math.pow(10,9)  + 7 );
        }
        if(sum >= 0){
            if(k==1){
                return Math.max(getPreMax(arr),0)%((int)Math.pow(10,9)  + 7 );
            }

            if(k==2){
                //  System.out.println(getPreMax(arr)+","+getSufMax(arr));
                return Math.max(getPreMax(arr)+getSufMax(arr),0)%((int)Math.pow(10,9)  + 7 );
            }
            // System.out.println(getPreMax(arr)+","+getSufMax(arr));
            return Math.max(getPreMax(arr)+getSufMax(arr)+(k-2)*sum,0)%((int)Math.pow(10,9)  + 7 );
        }
        return 0;
    }


    /**
     * 获取最大前缀和
     * @return
     */
    public int getPreMax(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
            max=Math.max(sum,max);
        }
        return max;
    }

    /**
     * 获取最大后缀和
     */
    public int getSufMax(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1 ; i>=0 ; i--){
            sum = sum+arr[i];
            max=Math.max(sum,max);
        }
        return max;
    }
}
