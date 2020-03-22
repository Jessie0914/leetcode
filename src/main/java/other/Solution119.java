package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution119
 * @Description 119.杨辉三角2
 * @Author shishi
 * @Date 2019/7/20 17:39
 **/

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class Solution119 {
    // 跟118很像
    public List<Integer> getRow(int rowIndex) {
        int row = rowIndex+1;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        List<Integer> cur = new ArrayList<>();
        if (rowIndex==0) return pre;
        for (int i=2;i<=row;i++){
            for (int j=0;j<i;j++){
                int num1=0;
                if (j-1<0){
                    num1=0;
                }else {
                    num1 = pre.get(j-1);
                }

                int num2;
                if (j>pre.size()-1){
                    num2=0;
                }else {
                    num2=pre.get(j);
                }

                cur.add(num1+num2);
            }
            pre = cur;
            cur = new ArrayList<>();
        }
        return pre;
    }
}
