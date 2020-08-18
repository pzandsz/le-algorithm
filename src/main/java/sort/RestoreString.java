package sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class RestoreString {

    /**
     * 方法一
     * @param s
     * @param indices
     * @return
     */
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


    public String restoreString2(String s, int[] indices) {
        Character[] c= new Character[indices.length];
        for(int i=0;i<indices.length;i++){
            c[indices[i]]=s.charAt(i);
        }

        Arrays.sort(indices);
        String res="";
        for(int i=0;i<indices.length;i++){
            res=res+c[indices[i]];
        }

        return res;
    }
}
