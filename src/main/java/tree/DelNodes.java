package tree;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类说明:1110 删点成林
 * 思路:
 * 没删除一个节点后，将已删除的节点从to_delete中去除，
 * 再递归调用delNodes方法
 *
 * 此题待深究
 *
 *
 * 首先把to_delete变成set，此处不多说；
 * 节点进入结果当中，有2个条件：
 *
 * 不被删除
 * 父节点不存在
 * 因此在遍历过程中，将parentExists标志传递给子节点，子递归就可以选择是否加入到结果。
 * 另外，如果子节点被删除，父节点的left、right字段需要更新。
 * 代码
 *
 * @author zengpeng
 */
public class DelNodes {

    Set<Integer> toDelete;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> ans = new ArrayList<>();
        helper(root, ans, false);
        return ans;
    }

    /**
     * 递归求解
     * @param root
     * @param ans
     * @param parentExists 用于标识父节点是否存在
     * @return 返回是否删除该节点
     * 方法参数的递归使用套路
     */
    boolean helper(TreeNode root, List<TreeNode> ans, boolean parentExists) {
        boolean del = false;
        if (root == null) {
            return del;
        }
        del = toDelete.contains(root.val);
        if (helper(root.left, ans, !del)) {
            root.left = null;
        }
        if (helper(root.right, ans, !del)) {
            root.right = null;
        }
        //当前节点不被删除 且 父节点不存在
        if (!del && !parentExists) {
            ans.add(root);
        }
        return del;
    }

}
