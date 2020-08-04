package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution43
 * @Description 字符串相乘
 * @Author shishi
 * @Date 2020/8/5 1:06
 **/
public class Solution43 {
    public String multiply(String num1, String num2) {
        //如果不对输入有"0"做处理则返回"000...0"而不是"0"
        if("0".equals(num1)||"0".equals(num2)) return "0";
        int l1=num1.length(),l2=num2.length();
        int[] result = new int[l1+l2-1];

        //计算乘积并存储到数组中
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                result[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }

        //整理数组中结果到最终的字符串中
        StringBuilder sb = new StringBuilder();
        int carry=0;
        for (int i = l1 + l2 - 2; i >= 0; i--) {
            sb.append((result[i]+carry)%10);
            carry=(result[i]+carry)/10;
        }
        while (carry != 0) {
            sb.append(carry%10);
            carry/=10;
        }
        return sb.reverse().toString();
    }
}
