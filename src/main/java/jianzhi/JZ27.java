package jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Classname JZ27
 * @Description 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @Date 2020/7/23 3:36 下午
 * @Created by chiyue
 */
public class JZ27 {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        boolean[] visited = new boolean[str.length()];
        helper(str, visited, set, "");

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    private void helper(String str, boolean[] visited, HashSet<String> set, String cur) {
        if (cur.length() == str.length())
            set.add(cur);

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                cur += str.charAt(i);
                helper(str, visited, set, cur);

                cur = cur.substring(0, cur.length() - 1);
                visited[i] = false;
            }
        }
    }
}
