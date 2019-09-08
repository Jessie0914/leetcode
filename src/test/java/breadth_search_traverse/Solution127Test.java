package breadth_search_traverse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution127Test {

    @Test
    public void ladderLength() {
        Solution127 solution127 = new Solution127();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        solution127.ladderLength("hit","cog",list);
    }
}