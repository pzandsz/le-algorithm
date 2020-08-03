package dynamic;

/**
 * 类说明:1139. 最大的以 1 为边界的正方形
 * 给你一个由若干 0 和 1 组成的二维网格 grid，
 * 请你找出边界全部由 1 组成的最大 正方形子网格，
 * 并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 * 令dp[i][j][0]表示点i,j左边连续1的最大个数
 * 令dp[i][j][1]表示点i,j上边连续1的最大个数
 *     即以点(i,j)为右下点的正方形
 *
 * 获得这部分数据后，再查询最大的正方形时，就不需要每个节点都判断min(i,j)次了
 * 只需要判断min(dp[i][j][0],dp[i][j][1])次了
 *
 * 这也就是基于区间的dp问题
 *
 * @author zengpeng
 */
public class Largest1BorderedSquare  {

    public int largest1BorderedSquare(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int[][][] dp = new int[grid.length][grid[0].length][2];
        int max = 0;
        //数组预处理
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=0;
                }else {
                    max=1;
                    if(j-1 < 0){
                        dp[i][j][0]=1;
                    }else{
                        dp[i][j][0]=dp[i][j-1][0]+1;
                    }
                    if(i-1 < 0){
                        dp[i][j][1]=1;
                    }else{
                        dp[i][j][1]=dp[i-1][j][1]+1;
                    }
                }
//                System.out.print(Math.min(dp[i][j][0], dp[i][j][1])+",");
                System.out.print(dp[i][j][0]+","+dp[i][j][1]+" ");

            }
            System.out.println();
        }




        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int min = Math.min(dp[i][j][0], dp[i][j][1]);
                if(min <= max){
                    continue;
                }
                //若存在比max更大的值，取较大值，否者依旧取max
                max = getMax(grid,max,min,i,j);
            }
        }
        return max*max;
    }

    public int getMax(int[][] grid,int max,int tail,int i,int j){
        for(int k=tail;k>max;k--){
            if(judge(grid,k,i,j)){
                max = k;
            }
        }
        return max;
    }


    public boolean judge(int[][] grid,int k,int i,int j){

        for(int m=1;m<k;m++ ){
            try {
                if(grid[i-k+1][j-m] == 0){
                    return false;
                }
            } catch (Exception e) {
                System.out.println("i:"+i+"j:"+j+"k:"+k+"m:"+m);
                e.printStackTrace();
            }

            if(grid[i-m][j-k+1] == 0){
                return false;
            }
        }
        return  true;
    }


    public static void main(String[] args) {
        Largest1BorderedSquare square = new Largest1BorderedSquare();
        int[][] data = {{1,1,0},{1,0,1},{0,1,1}};
        System.out.println(square.largest1BorderedSquare(data));
    }
}
