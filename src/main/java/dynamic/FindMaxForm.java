package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class FindMaxForm {

    Map<String,Integer> cache = new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxForm2(strs,0,m,n);
    }

    public int findMaxForm2(String[] strs,int index, int m, int n) {
        String key = m+""+n+""+index;
        if(cache.get(key) != null){
            return cache.get(key);
        }
        if(index >= strs.length){
            return 0;
        }
        if(m < 0 || n < 0){
            return 0;
        }


        int zero=0;
        int one=0;
//        for(int i=0;i<strs[index].length();i++){
//            if(strs[index].charAt(i) == '0'){
//                zero++;
//            }else {
//                one++;
//            }
//        }
        long l = Long.parseLong(strs[index]);
        while(l>0)
        {
            if(l % 2 != 0) {   //用取模获得去除的一位
                ++one;
            }
            l /= 2;
        }
        zero=strs[index].length()-one;

        index++;
        if(m-zero < 0 || n-one < 0){
            int maxForm2 = findMaxForm2(strs, index, m, n);
            cache.put(key,maxForm2);
            return maxForm2;
        }
        int max = Math.max(findMaxForm2(strs, index, m, n), findMaxForm2(strs, index, m - zero, n - one) + 1);
        cache.put(key,max);
        return max;

    }


    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();

        String[] strs = {"00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01","00","01"};
        System.out.println(findMaxForm.findMaxFormDiedai(strs, 50, 50));

    }



    /**
     * 迭代解法
     */
    public int findMaxFormDiedai(String[] strs, int m, int n) {
        int[][] dp = new int[strs.length+1][2];
        String[][] state=new String[strs.length+1][2];
        state[0][0]=m+"-"+n;
        state[0][1]=m+"-"+n;
        for(int i=1;i<=strs.length;i++){
            dp[i][0] = dp[i-1][0];
            state[i][0]=state[i - 1][0];
//            String s1 = canGet(strs[i-1], state[i - 1][0]);
//            if(s1.equals(state[i - 1][0])){
//                dp[i][1]=dp[i-1][1];
//                state[i][0]=s1;
//            }else {
//                dp[i][1]=dp[i-1][1]+1;
//                state[i][0]=s1;
//            }
            String s = canGet(strs[i-1], state[i - 1][1]);

            if(s.equals(state[i - 1][1])){
                dp[i][1]=dp[i-1][1];
                state[i][1]=s;
            }else {
                dp[i][1]=dp[i-1][1]+1;
                state[i][1]=s;
            }

            System.out.println(Math.max(dp[i][1],dp[i][0])+","+state[i][1]);
        }
        return Math.max(dp[strs.length][0],dp[strs.length][1]);
    }

    public String canGet(String str,String mn){
        String[] split = mn.split("-");
        int m=Integer.parseInt(split[0]);
        int n=Integer.parseInt(split[1]);

        int zero=0;
        int one=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '0'){
                zero++;
            }else {
                one++;
            }
        }

        if(m-zero<0||n-one<0){
            return mn;
        }
        return (m-zero)+"-"+(n-one);
    }
}
