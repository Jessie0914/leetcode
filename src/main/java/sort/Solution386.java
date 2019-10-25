package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution386
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/16 9:59
 **/
public class Solution386 {
    // 最直接最原始的方法，暴力转换成string数组，排序，再转成List<Integer>
    public List<Integer> lexicalOrder(int n) {
        String[] strings = new String[n];
        for (int i=1;i<=n;i++){
            strings[i-1] = String.valueOf(i);
        }
        Arrays.sort(strings);
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<strings.length;i++){
            list.add(Integer.valueOf(strings[i]));
        }
        return list;
    }

    // 尝试用一个新的方法，用递归的方式
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<Integer>();
        recursion(0,n,res);
        return res;

    }

    // k代表当前值
    private void recursion(int k, int n, List<Integer> res) {
        if (k>n)
            return;

        if (k!=0)
            res.add(k);

        for (int i=0;i<=9;i++){
            if (k==0&&i==0)
                continue;

            recursion(k*10+i,n,res);
        }
    }
}
