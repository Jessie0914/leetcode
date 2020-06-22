package day_practice.april;

/**
 * @ClassName Solution1111
 * @Description 1111. 有效括号的嵌套深度
 * @Author shishi
 * @Date 2020/4/1 22:22
 **/

/**
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 */
public class Solution1111 {
    // https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/you-xiao-gua-hao-de-qian-tao-shen-du-by-leetcode-s/
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int aLen = 0;
        int bLen = 0;
        for (int i = 0; i < seq.length(); i++) {
            // 涨深度，谁浅就给谁
            //这个深度是指：目前还没有匹配好的(有几个
            if (seq.charAt(i) == '(') {
                if (aLen <= bLen) {
                    aLen++;
                    ans[i] = 1;
                } else {
                    bLen++;
                }
            } else {
                if (aLen > bLen) {
                    aLen--;
                    ans[i] = 1;
                } else
                    bLen--;
            }
        }
        System.out.println(aLen);
        System.out.println(bLen);

        return ans;
    }
}
