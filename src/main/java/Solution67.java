/**
 * @ClassName Solution67
 * @Description 67.二进制求和
 * @Author shishi
 * @Date 2019/7/20 15:40
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution67 {
    // 这个思路比较简单，和两个十进制相加的思路一样
    //
    public String addBinary(String a, String b) {
        char[] minChar,maxChar;
        if (a.length()<b.length()){
            minChar = a.toCharArray();
            maxChar = b.toCharArray();
        }else {
            minChar = b.toCharArray();
            maxChar = a.toCharArray();
        }

        int jinwei = 0;
        // 用list比较好，可以动态扩容
        List<Integer> result= new ArrayList<>();
        int i=minChar.length-1,j=maxChar.length-1;
        while (i>=0){
            int num1 = (minChar[i] - '0');
            int num2 = (maxChar[j] - '0');
            if (num1+num2+jinwei>=2){
                result.add((num1+num2+jinwei)%2);
                jinwei = 1;
            }else {
                result.add((num1+num2+jinwei)%2);
                jinwei=0;
            }
            i--;
            j--;
        }

        while (j>=0){
            int num = (maxChar[j] - '0');
            if (num+jinwei==2){
                jinwei=1;
                result.add(0);
            }else {
                result.add(num+jinwei);
                jinwei=0;
            }
            j--;
        }

        if (jinwei==1){
            result.add(1);
        }

        // 把list转换成string
        StringBuilder sb = new StringBuilder();
        for (int k =result.size()-1;k>=0;k--){
            sb.append(result.get(k));
        }
        return sb.toString();
    }
}
