package linked.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串的排列:
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 暴力破解思路：
 * 遍历s2：判断是否包含s1的排列
 *
 * 滑动窗口思路：
 * 当窗口中等于s1所有的字符时，停止扩大，左指针开始移动
 * 当左指针指向的字符是s1中的字符是，判断窗口大小是否等于s1的长度
 *      若等于，返回true
 *      若不等于，左指针继续移动一位，并停止缩小，开始移动右指针
 */
public class CheckInclusion {

    public static boolean checkInclusion(String s1,String s2){


        Map<Character,Integer> judge = init(s1);
        int left = 0;
        int right = 0;

        do{
            //判断何时停止右移
        }while (left != right);

        return false;
    }


    public static Map<Character,Integer> init(String s1){
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            if(map.get(s1.charAt(i)) != null){
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }else {
                map.put(s1.charAt(i),1);
            }
        }

        return map;
    }

}
