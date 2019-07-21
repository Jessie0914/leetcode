import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution118
 * @Description 118.杨辉三角
 * @Author shishi
 * @Date 2019/7/20 16:34
 **/

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        // numRows为0的情况
        List<List<Integer>> result = new ArrayList<>();
        if (numRows==0) return result;

        // numRows为1的情况
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        if (numRows==1) return result;

        for (int i=2;i<=numRows;i++){
            List<Integer> cur = new ArrayList<>();
            // 本来以为可以进一步优化，只遍历到中位数即可，因为杨辉三角是对称的，可以只遍历一半
            // 但是list只能一个一个的增加元素，不能现有容量是3，然后直接填充第6个位置的元素了，下一步只能填充第4个元素
            // 当前是第i行，当前行的处理，要增加i个数
            for (int j=0;j<i;j++){
                int num1;
                if (j-1<0){
                    num1 = 0;
                }else {
                    num1 = result.get(i-2).get(j-1);
                }

                int num2;
                if (j>result.get(i-2).size()-1){
                    num2 = 0;
                }else {
                    num2 = result.get(i-2).get(j);
                }
                // 将两个数相加，加入cur
                cur.add(num1+num2);
            }
            result.add(cur);
        }
        return result;
    }
}
