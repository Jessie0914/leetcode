package violence;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution17_2
 * @Description 17.电话号码的字母组合
 * @Author shishi
 * @Date 2019/7/18 20:38
 **/
public class Solution17_2 {
    // 迭代方法(不看了，看不懂)
    String[] keyboard = new String[]{" ", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0) return result;
        result.add("");
        for (char d : digits.toCharArray()){
            int n = result.size();
            int m = keyboard[d-'0'].length();

            for (int i=1;i<m;i++){
                for (int j=0;i<n;j++){
                    result.add(result.get(j));
                }
            }

            for (int i=0; i<result.size();i++){
                result.set(i,result.get(i)+keyboard[d-'0'].charAt(i/n));
            }
        }
        return result;
    }
}
