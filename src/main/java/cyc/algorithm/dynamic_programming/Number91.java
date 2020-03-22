package cyc.algorithm.dynamic_programming;

/**
 * @program: leetcode
 * @description: 91. 解码方法
 * @author: shishi
 * @create: 2019-12-04 15:23
 **/

/**
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Number91 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length==0) return 0;

        int[] dp = new int[length];
        if (chars[0]>'0')
            dp[0] = 1;
        else
            dp[0] = 0;

        for (int i=1;i<length;i++){
            // 先看本身是不是>'0'，如果不符合，不能加上去
            if (chars[i]>'0'&&chars[i]<='9')
                dp[i] = dp[i-1];

            // 再往前退一位，看是不是<=26
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i-1]);
            sb.append(chars[i]);
            int num = Integer.parseInt(sb.toString());
            if (num>=10&&num<=26){
                if (i-2>=0)
                    dp[i] += dp[i-2];
                else
                    dp[i] += 1;
            }
        }

        return dp[length-1];

    }
}
