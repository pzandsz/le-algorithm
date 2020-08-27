package dynamic;

/**
 * 类说明:
 *
 * @author zengpeng
 */
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxForm2(strs,0,m,n);
    }

    public int findMaxForm2(String[] strs,int index, int m, int n) {
        if(index >= strs.length){
            return 0;
        }
        if(m < 0 || n < 0){
            return 0;
        }


        int zero=0;
        int one=0;
        for(int i=0;i<strs[index].length();i++){
            if(strs[index].charAt(i) == '0'){
                zero++;
            }else {
                one++;
            }
        }
        return Math.max(findMaxForm2(strs,++index,m,n),findMaxForm2(strs,++index,m-zero,n-one)+1);

    }
}
