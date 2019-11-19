package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: shishi
 * @create: 2019-11-12 19:34
 **/

public class Solution638_2 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> hashMap = new HashMap<>();
        return recursion(price,special,needs,hashMap);
    }

    private int recursion(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> hashMap) {
        // 如果map中有这个needs，就直接返回
        if (hashMap.containsKey(needs)){
            return hashMap.get(needs);
        }

        // 如果不使用大礼包的原价
        int res = calculate(price,needs);

        // 遍历大礼包
        for (List<Integer> s : special){
            // 需要先复制一个needs为clone，做后续的改动
            ArrayList<Integer> clone = new ArrayList<>(needs);
            int i=0;
            for (;i<clone.size();i++){
                int dif = clone.get(i) - s.get(i);
                if (dif<0)
                    break;
                clone.set(i,dif);
            }

            // 大礼包的值没有超过needs的值，说明可以购买这个大礼包，递归求解比较
            if (i==needs.size()){
                res = Math.min(res,s.get(i)+recursion(price,special,clone, hashMap));
            }
        }
        // 把这个needs对应的res存入map
        hashMap.put(needs,res);
        return res;
    }

    private int calculate(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i=0;i<price.size();i++){
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
