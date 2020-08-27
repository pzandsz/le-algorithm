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
        for(int i=0;i<strs[index].length();i++){
            if(strs[index].charAt(i) == '0'){
                zero++;
            }else {
                one++;
            }
        }
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

        String[] strs = {"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"};
        System.out.println(findMaxForm.findMaxForm(strs, 90, 66));

    }
}
