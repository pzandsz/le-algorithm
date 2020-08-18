package sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class RestoreString {

    public String restoreString(String s, int[] indices) {
        HashMap<Integer,Character> map=new HashMap<>();
        for(int i=0;i<indices.length;i++){
            map.put(indices[i],s.charAt(i));
        }

        Arrays.sort(indices);
        String res="";
        for(int i=0;i<indices.length;i++){
            res=res+map.get(indices[i]);
        }

        return res;
    }
}
