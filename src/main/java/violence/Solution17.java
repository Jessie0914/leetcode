package violence;

/**
 * @ClassName Solution17
 * @Description 17.电话号码的字母组合
 * @Author shishi
 * @Date 2019/7/18 19:51
 **/


import java.util.ArrayList;
import java.util.List;

/**
 * 题目要求：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例：
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17 {
    // 递归方法
    String[] keyboard = new String[]{" ", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0) return result;
        dfs(result,digits,0,"");
        return result;
    }

    private void dfs(List<String> result, String digits, int cur, String path) {
        if (cur==digits.length()){
            result.add(path);
            return;
        }
        String str = keyboard[digits.charAt(cur) - '0'];

        for (char c : str.toCharArray()){
            dfs(result,digits,cur+1,path+c);
        }
    }

}
