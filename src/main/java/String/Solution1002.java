package String;

import java.util.*;

/**
 * @ClassName Solution1002
 * @Description 1002. 查找常用字符
 * @Author shishi
 * @Date 2019/10/25 13:10
 **/

/**
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class Solution1002 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();

        List<Map<Character, Integer>> hashMaps = new ArrayList<>();
        // 遍历，把每一个字符串对应的map填充好
        for (int i=0;i<A.length;i++){
            String s = A[i];
            Map<Character, Integer> map = new HashMap<>();
            for (int j=0;j<s.length();j++){
                char c = s.charAt(j);
                int count = map.getOrDefault(c, 0);
                map.put(c,count+1);
            }
            hashMaps.add(map);
        }

        Map<Character, Integer> firstMap = hashMaps.get(0);
        Set<Character> keySet = firstMap.keySet();
        Iterator<Character> iterator = keySet.iterator();
        while (iterator.hasNext()){
            char cur_c = iterator.next();
            int count = firstMap.get(cur_c);
            int finalCount = count;
            boolean flag = true;
            int j=1;
            while (j<hashMaps.size()){
                Map<Character, Integer> cur_map = hashMaps.get(j);
                int cur_count = cur_map.getOrDefault(cur_c, 0);
                if (cur_count==0) {
                    flag = false;
                    break;
                }
                else {
                    if (cur_count<finalCount)
                        finalCount = cur_count;
                }
                j++;
            }
            if (flag){
                for (int k=0;k<finalCount;k++){
                    res.add(String.valueOf(cur_c));
                }
            }
        }
        return res;
    }

    // 方法2
    // 效率会高很多
    public List<String> commonChars2(String[] A) {
        List<String> res = new ArrayList<>();

        List<int[]> list = new ArrayList<>();
        for (int i=0;i<A.length;i++){
            String s = A[i];
            int[] nums = new int[26];
            for (int j=0;j<s.length();j++){
                nums[s.charAt(j)-'a']++;
            }
            list.add(nums);
        }

        int[] first_nums = list.get(0);
        for (int i=0;i<26;i++){
            if (first_nums[i]==0)
                continue;
            else {
                int finalCount = first_nums[i];
                int j=1;
                boolean flag = true;
                while (j<list.size()){
                    int[] cur_nums = list.get(j);
                    if (cur_nums[i]==0){
                        flag = false;
                        break;
                    }else {
                        if (cur_nums[i]<finalCount)
                            finalCount = cur_nums[i];
                    }
                    j++;
                }
                if (flag) {
                    for (int k=0;k<finalCount;k++)
                        res.add(String.valueOf((char) (i+'a')));
                }
            }
        }

        return res;

    }

}
