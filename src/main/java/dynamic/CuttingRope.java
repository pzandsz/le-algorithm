package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明: 剑指offer14 剪绳子
 * n=57是两个值相乘无法的带最大值了？
 * 因为到了57之后，就到了要%10000007的时候了，否则数字在59的时候就越界了
 * 但是%10000007之后，结果就不对了
 *
 * 所以递归+备忘录的解法在57的时候陷入了死镜，只能换方法了
 * @author zengpeng
 */
public class CuttingRope {
    boolean single = true;
    Map<Integer,Integer> map = new HashMap<>();
    public int cuttingRope(int n) {
        if(n<2){
            return n;
        }
        if(n == 2 ){
            if(!single){
                return 2;
            }
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n/2;i++){
            single=false;
            int tmp = 0;
            if(map.get(n) == null){
                tmp = Math.max(cuttingRope(n - i),n-i);
                max = Math.max( tmp*i,max);
            }else {
                max = Math.max( map.get(n),max);
            }

        }
//        max = max%1000000007;
        map.put(n,max);
//        if(n == 999779387){
//            System.out.println(n);
//        }
//        System.out.println(n+",max:"+ max);
        return max;

    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
//        System.out.println(cuttingRope.cuttingRope(92));

        boolean flag=true;
        int i=1;
        while (flag){
            if(cuttingRope.cuttingRope(i) != cuttingRope.cuttingRope1(i)){
                System.out.println(i);


                flag=false;
            }
            System.out.println(cuttingRope.cuttingRope(i));
            System.out.println(cuttingRope.cuttingRope1(i));
            i++;

        }
    }











    public int cuttingRope1(int n) {
        if(n <= 3){
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1){
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if(b == 0){
            return (int)(rem * 3 % p);
        }
        if(b == 1){
            return (int)(rem * 4 % p);
        }
        return (int)(rem * 6 % p);
    }


}
