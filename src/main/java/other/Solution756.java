package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution756
 * @Description 756. 金字塔转换矩阵
 * @Author shishi
 * @Date 2019/11/20 10:53
 **/

/**
 * 输入: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * 输出: true
 */
public class Solution756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> hashMap = new HashMap<>();
        // 填充hashMap
        fillMap(hashMap,allowed);
        // dfs+回溯
        return dfs(hashMap,bottom,"",0);
    }

    private boolean dfs(Map<String, List<Character>> hashMap, String preStr, String curStr, int curIndex) {
        // 金字塔建造成功
        if (preStr.length()==1)
            return true;

        // 如果curIndex已经到底了，那么就可以处理上一层了
        if (curIndex==preStr.length()-1){
            return dfs(hashMap,curStr,"",0);
        }

        // 其余情况
        String key = preStr.substring(curIndex,curIndex+2);
        if (!hashMap.containsKey(key))
            return false;
        else {
            List<Character> list = hashMap.get(key);
            // 遍历list的所有可以添加上的字符，一次一个的加上，尝试往下dfs
            for (int i=0;i<list.size();i++){
                curStr += list.get(i);
                if (dfs(hashMap,preStr,curStr,curIndex+1))
                    return true;
                // 如果加上的上一个字符不行，就回退一步，即减掉刚才加上的字符
                curStr = curStr.substring(0,curStr.length()-1);
            }
        }

        return false;
    }

    // 填充hashMap
    private void fillMap(Map<String, List<Character>> hashMap, List<String> allowed) {
        for (String s : allowed){
            // 比如s="XYD"，<"XY"--"D">
            String key = s.substring(0,2);
            if (hashMap.containsKey(key)){
                List<Character> list = hashMap.get(key);
                list.add(s.charAt(2));
            }else {
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(2));
                hashMap.put(key,list);
            }
        }
    }
}
