package common;

import java.util.List;

/**
 * 类说明: N叉树节点
 *
 * @author zengpeng
 */
public class NTreeNode {
    public int val;
    public List<NTreeNode> children;
    public NTreeNode() {}

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
