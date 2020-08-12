package sort;

/**
 * 类说明:寻找两个正序数组的中位数
 *[1,2]
 * [3,4]
 * @author zengpeng
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int head1 = 0,head2=0;
        //0表示head1 1表示head2
        int current = 0;
        int len = nums1.length+nums2.length;
        int tmp=0;
        if(len%2==0){
            while (head1+head2 <= len/2){

                if(nums1[head1]>nums2[head2]){
                    current=1;
                    head2++;
                }else {
                    current=0;
                    head1++;
                }


                if(head1+head2 == len/2-1){
                    tmp=Math.min(nums1[head1],nums2[head2]);
                }
                if(head1+head2 == len/2){
                    return (Math.min(nums1[head1],nums2[head2])+tmp)/2;

                }
            }
        }else{
            while (head1+head2 <= len/2){

                if(nums1[head1]>nums2[head2]){
                    current=1;
                    head2++;
                }else {
                    current=0;
                    head1++;
                }


                if(head1+head2 == len/2){
                    return Math.min(nums1[head1],nums2[head2]);
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {

    }
}
