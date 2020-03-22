package top_interview;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution49Test {

    @Test
    public void groupAnagrams() {
        Solution49 solution49 = new Solution49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution49.groupAnagrams(strs);
        System.out.println(lists.size());
        for (List<String> list : lists){
            for (String s : list)
                System.out.print(s+" ");
            System.out.println();
        }
    }
}