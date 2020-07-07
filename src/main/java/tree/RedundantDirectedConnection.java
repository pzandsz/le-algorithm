package tree;

/**
 * 类说明:685 冗余连接II
 *
 * @author zengpeng
 */
public class RedundantDirectedConnection {

    private int[] pre=null;

    private int find(int u){
        while(u != pre[u]){
            //压缩路径
            pre[u] = pre[pre[u]];
            u = pre[u];
        }

        return u;
    }

    /**
     *
     * @param edges
     * @return
     * 需要考虑有没有环和重复的父节点
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {

        //存放最后一个后向边(环)
        int [] backedge=new int[2];
        //存放最后一个重复的父节点
        int [] pending=new int[2];

        pre = new int[edges.length + 1];

        //初始化并查集
        for(int[] edge:edges){
            //合并有向边
            if(pre[edge[1]] == 0){
                pre[edge[1]] = edge[0];
            }else{//有重复的父节点
                pending = new int[]{edge[0],edge[1]};
                backedge = new int[]{pre[edge[1]],edge[1]};
                edge[1]=0;
            }
        }
        //重新初始化
        for (int i = 0; i <=edges.length; i++) {
            pre[i] = i;
        }

        for(int[] e : edges){
            if(e[1]==0){
                continue;
            }
            //判断有没有环
            if(find(e[0])==e[1]){
                return backedge[0]!=0?backedge:e;
            }
            pre[e[1]]=e[0];
        }

        return pending;
    }

}
