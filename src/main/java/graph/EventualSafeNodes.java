package graph;

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
        for(int i=0;i<graph.length;i++){
            int[] endList = graph[i];
            for(int j=0;j<endList.length;j++){
                System.out.println(endList[j]);
            }
        }
        return null;
    }
}
