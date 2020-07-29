package tree;

import common.TreeNode;

import java.util.*;

/**
 * 类说明:1457 二叉树中的伪回文路径
 *
 * 1.如何判断一个字符串是伪回文子符串
 * 2.遍历树，获取所有的路径
 * @author zengpeng
 */
public class PseudoPalindromicPaths {
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {

        if(root == null){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        digui(root,map);

        return result;
    }

    public void digui(TreeNode node,HashMap<Integer,Integer> map){
        HashMap<Integer,Integer> mapTemp = new HashMap<>(map);
        if(node == null){
            return;
        }
        Integer integer = map.get(node.val);
        if(integer == null){
            integer = 1;
        }else {
            integer = integer.intValue() + 1;

        }
        mapTemp.put(node.val,integer);

        if(node.left == null && node.right == null){
            if(judgeHuiWen(mapTemp)){
                result++;
            }
            return;
        }
        digui(node.left,mapTemp);
        digui(node.right,mapTemp);
    }
    public boolean judgeHuiWen(HashMap<Integer,Integer> map){
        Set<Integer> integers = map.keySet();

        int status = 0;
        int sum = 0;
        for (Integer i : integers) {
            Integer integer = map.get(i);
            System.out.println(integer);
            if(integer % 2 == 1){
                if(status >= 1){
                    return false;
                }
                status++;
            }
            sum = sum + integer;
        }

        System.out.println("sum: " + sum );
        if(sum % 2 == 1 && status == 1){
            return true;
        }else {
            if(sum%2==0&&status==0){
                return true;
            }
            return false;
        }
    }
}
