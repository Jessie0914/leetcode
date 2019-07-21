/**
 * @ClassName Solution415
 * @Description 415.字符串相加
 * @Author shishi
 * @Date 2019/7/18 21:11
 **/

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        String minString = num1.length()<=num2.length()?num1:num2;
        String maxString = num1.length()>num2.length()?num1:num2;
        int length = maxString.length();

        int minus = length-minString.length();
        char[] char1 = minString.toCharArray();
        char[] minChar = new char[length];
        for (int i=0;i<minus;i++){
            minChar[i] = '0';
        }
        for (int i=0;i<char1.length;i++){
            minChar[minus+i] = char1[i];
        }
        int[] minInteger = new int[length];
        for (int i=0;i<minChar.length;i++){
            minInteger[i] = minChar[i]-'0';
        }

        char[] maxChar = maxString.toCharArray();
        int[] maxInteger = new int[length];
        for (int i=0;i<maxChar.length;i++){
            maxInteger[i] = maxChar[i]-'0';
        }

        // 上述步骤就是将两个字符串转换成同等大小的整数数组（小的数组，前面位置补0）
        int[] result = count(minInteger, maxInteger);
        // 将整数数组转换成字符串
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<result.length;i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    // 将两个整数数组相加的函数
    private int[] count(int[] minInteger, int[] maxInteger) {
        int[] result = new int[minInteger.length];
        int jinwei = 0;
        for (int i=minInteger.length-1;i>=0;i--){
            int sum = minInteger[i]+maxInteger[i];
            if (jinwei==0){
                result[i] = sum%10;
            }else {
                sum = sum+jinwei;
                result[i] = sum%10;
            }
            if (sum>=10){
                jinwei = 1;
            }else jinwei=0;
        }

        if (jinwei==1){
            int[] res = new int[result.length + 1];
            res[0] = 1;
            for (int i=0;i<result.length;i++){
                res[i+1]=result[i];
            }
            return res;
        }
        return result;
    }
}
