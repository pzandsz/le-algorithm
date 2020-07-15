package tree;

import common.TreeNode;

/**
 * 类说明:1315 祖父节点值为偶数的节点和
 *
 * @author zengpeng
 */
public class SumEvenGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        if(root == null){
            return sum;
        }
        if(root.val%2 == 0){
            sum = sum + sumGrandson(root);
            System.out.println(sum);
        }
        sum = sum + sumEvenGrandparent(root.left);
        sum = sum + sumEvenGrandparent(root.right);

        return sum;
    }

    public int sumGrandson(TreeNode node){
        int sum = 0;
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return sum ;
        }
//        sum = sum+ node.val;
        TreeNode grandLeftLeft = null;
        TreeNode grandLeftRight = null;
        TreeNode grandRightLeft = null;
        TreeNode grandRightRight = null;


        if(node.right == null){
            grandLeftLeft = node.left.left;
            grandLeftRight = node.left.right;
            if(grandLeftLeft != null){
                sum = sum + grandLeftLeft.val;
            }

            if(grandLeftRight != null){
                sum = sum + grandLeftRight.val;
            }
            return sum;

        }

        if(node.left == null){
            grandRightLeft = node.right.left;
            grandRightRight = node.right.right;
            if(grandRightLeft != null){
                sum = sum + grandRightLeft.val;
            }

            if(grandRightRight != null){
                sum = sum + grandRightRight.val;
            }
            return sum;
        }

        grandLeftLeft = node.left.left;
        grandLeftRight = node.left.right;
        grandRightLeft = node.right.left;
        grandRightRight = node.right.right;

        if(grandLeftLeft != null){
            sum = sum + grandLeftLeft.val;
        }

        if(grandLeftRight != null){
            sum = sum + grandLeftRight.val;
        }

        if(grandRightLeft != null){
            sum = sum + grandRightLeft.val;
        }

        if(grandRightRight != null){
            sum = sum + grandRightRight.val;
        }

        return sum;
    }
}
