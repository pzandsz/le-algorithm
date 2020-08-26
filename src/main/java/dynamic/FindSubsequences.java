package dynamic;

import java.util.*;

/**
 * 类说明: 递增子序列
 *
 * @author zengpeng
 */
public class FindSubsequences {

    List<List<Integer>> res = new ArrayList<>();

    Map<String,Boolean> cache = new HashMap<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int tmpInt = nums[i];
            ArrayList<Integer> numArray = new ArrayList<>();
            numArray.add(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>tmpInt){
                    numArray.add(nums[j]);
                    tmpInt=nums[j];
                    listAll(numArray);
                }
            }
        }
        return res;
    }

    public void listAll(ArrayList<Integer> nums){
        if(nums.size() < 2){
            return ;
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        StringBuilder tmpStr = new StringBuilder("");
        tmp.add(nums.get(0));
        for(int i=1;i<nums.size();i++){
            tmpStr.append(nums.get(i));
            tmp.add(nums.get(i));

            if(cache.get(tmpStr.toString()) == null || !cache.get(tmpStr.toString())){
                cache.put(tmpStr.toString(),true);
                res.add(new ArrayList<>(tmp));
            }

        }
    }
}
