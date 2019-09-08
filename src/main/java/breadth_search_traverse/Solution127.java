package breadth_search_traverse;

/**
 * @ClassName Solution127
 * @Description 127.单词接龙
 * @Author shishi
 * @Date 2019/7/25 12:24
 **/

import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 1.每次转换只能改变一个字母。
 * 2.转换过程中的中间单词必须是字典中的单词。
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 所有的单词的长度都是相同的，所以L一直是不变的
        int L = beginWord.length();

        // 这个map存放是所有的<中间状态，符合这个中间状态的所有单词的list>
        HashMap<String, List<String>> allComboDict = new HashMap<>();

        // 字典的预处理，填充allComboDict这个map
        // 遍历每一个word，用他们的中间状态做key，值为满足这个中间状态的word
        wordList.forEach(
                word->{
                    for (int i=0;i<L;i++){
                        // 键是单词的通用状态
                        // 值是所有满足这个通用状态的单词
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        // 返回该键的值，如果为空，那就新创建一个list
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord,transformations);
                    }
                }
        );

        // 为BFS建立一个queue，存放的是<单词,level>的元组
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        // 一开始存放的是<beginword,1>
        Q.add(new Pair<>(beginWord,1));

        // 为了避免循环查找，用一个数组来记录有没有访问过，以保证我们没有遍历同样的元素
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);

        // 开始BFS
        while (!Q.isEmpty()){
            Pair<String, Integer> node = Q.poll();
            String word = node.getKey();
            int level = node.getValue();

            // 中间状态一共会有L个，因为单词的长度都是不变的，全是L
            for (int i=0;i<L;i++){
                // 当前word的中间状态
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // 然后根据这个中间去找，所有满足这个中间状态的word，level+1
                for (String adjacentWord : allComboDict.getOrDefault(newWord,new ArrayList<>())){
                    // 如果此时已经找到endWord，那么直接返回最终结果即可
                    if (adjacentWord.equals(endWord)) return level+1;

                    // 否则，就把它加入到BFS的queue中（如果visited数组不包含它的话），并且visited数组记为true
                    if (!visited.containsKey(adjacentWord)){
                        Q.add(new Pair<>(adjacentWord,level+1));
                        visited.put(adjacentWord,true);
                    }
                }
            }
        }
        return 0;
    }
}
