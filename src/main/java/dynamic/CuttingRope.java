package dynamic;

/**
 * 类说明: 剑指offer14 剪绳子
 *
 * @author zengpeng
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if(n<2){
            return n;
        }
        if(n == 2){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            int tmp = cuttingRope(n - i);
            System.out.println(tmp+","+i);
            max = Math.max( tmp*i%1000000007,max);
        }
//        System.out.println(max);
        return max;

    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.cuttingRope(10));
    }


}
