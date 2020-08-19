package dynamic;

/**
 * 类说明: 回文子串
 * 暴力解法的资源计算重复在于对字符串是否为回文子串的判断上
 * 如何优化这部分的消耗是递归的核心思路
 * @author zengpeng
 */
public class CountSubstrings {

    int num = 0;
    public int countSubstrings(String s) {
        for (int i=0; i < s.length(); i++){
            //回文串长度为奇数
            count(s, i, i);
            //回文串长度为偶数
            count(s, i, i+1);
        }
        return num;
    }

    public void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }
}
