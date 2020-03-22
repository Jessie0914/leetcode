package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution17
 * @Description 电话号码的字母组合
 * @Author shishi
 * @Date 2020/2/28 21:54
 **/
public class Solution17 {
    HashMap<Integer, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return list;

        // 回溯思想
        // 当前字符串为""，以及剩下的还没遍历的字符串digits，每次只选1个
        helper(list, "", digits);
        return list;
    }

    private void helper(List<String> list, String curS, String nextDigits) {
        if (nextDigits.length() == 0) {
            list.add(curS);
            return;
        }

        // 当前需要遍历的数字
        int curNum = Integer.parseInt(nextDigits.substring(0, 1));
        String s = map.get(curNum);
        for (int i = 0; i < s.length(); i++) {
            // curS加上一个字符，nextDigit去掉已经遍历过的字符
            // 因为字符串是不可变的，每次都会生成新的
            helper(list, curS + s.charAt(i), nextDigits.substring(1));
        }

    }


}
