package skip.window;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。
 * 窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * 窗口位置                        中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *
 *  如何降低 '获取数组中的中位数' 消耗的时间
 *  1.分而治之的思想
 *  2.基于题目是滑动窗口，插入排序也是个不错的选择
 */

public class MedianSlidingWindow {


    public static void main(String[] args) {
        MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();

        int[] a = {2147483647,2147483647};
        BigDecimal a1 = new BigDecimal(2147483647);
        BigDecimal a2 = new BigDecimal(2147483647);

        BigDecimal subtract = a1.add(a2).divide(new BigDecimal(2));


//        System.out.println(subtract.doubleValue());
        double[] doubles = medianSlidingWindow.medianSlidingWindow(a, 2);

        for(int i=0 ; i<doubles.length ; i++){
            System.out.println(doubles[i]);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        if(nums.length - k + 1 < 0){
            return new double[0];
        }
        double[] answer = new double[nums.length - k + 1];

        for(int i=0 ; i < answer.length ; i++){
            answer[i] = getMedian(i, i + k, nums);
        }

        return answer;
    }

    public double getMedian(int head , int tail , int[] nums){
//        ArrayList<Integer> tmp = new ArrayList<>();
        int k = (tail - head);
        int[] tmp = new int[k];
        System.arraycopy(nums,head,tmp,0,k);
        Arrays.sort(tmp);
        if(k%2 == 1){
            return tmp[k/2];
        }else {

            BigDecimal a1 = new BigDecimal(tmp[k/2-1]);
            BigDecimal a2 = new BigDecimal(tmp[k/2]);

            BigDecimal divide = a1.add(a2).divide(new BigDecimal(2));

            return divide.doubleValue();
        }

    }



}
