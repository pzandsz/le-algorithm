package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类说明: 找到最终的安全状态，去除有向图中所有的环
 * 问题拆分
 * 构建有向图结构( 邻接矩阵 or 邻接表 )
 *
 * 有向图的存储方式
 * 邻接矩阵（数组）
 *
 * @author zengpeng
 */
public class EventualSafeNodes {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n=graph.length;
        //flag数组用于标识某个点是否被访问过
        boolean[] flag =new boolean[n];
        for(int i=0; i < n ;i++){
            if(!DFS(graph,i,flag)){
                res.add(i);
            }

            Arrays.fill(flag,false);
        }
        return null;
    }

    /**
     * DFS深度优先遍历，判断是否存在环
     * @param graph
     * @param start
     * @param flag
     * @return
     */
    public boolean DFS( int[][] graph, int start, boolean[] flag ) {
        //重复访问
        if ( flag[start] ){
            return true;
        }
        flag[start] = true;
        //发生循环则返回
        for ( int next : graph[start] ) {
            if ( DFS(graph, next, flag) ){
                return true;
            }
        }
        //回退
        flag[start] = false;
        return false;
    }
}
