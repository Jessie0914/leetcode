package DayPractice.March;

/**
 * @ClassName Solution62
 * @Description 面试题62. 圆圈中最后剩下的数字
 * @Author shishi
 * @Date 2020/3/30 15:05
 **/
public class Solution62 {
    // 纯暴力解法，超时
    public int lastRemaining(int n, int m) {
        int count = 0;
        int i = 0;
        boolean[] flag = new boolean[n];
        while (count < n - 1) {
            int value = 0;
            while (value < m) {
                if (i != n - 1) {
                    if (!flag[i]) {
                        i++;
                        value++;
                    } else
                        i++;
                } else {
                    if (!flag[i]) {
                        i = 0;
                        value++;
                    } else
                        i = 0;
                }
            }
            if (i != 0)
                flag[i - 1] = true;
            else
                flag[n - 1] = true;
            count++;
        }

        // 遍历flag数组来找剩下的仍然为false的值
        for (int j = 0; j < n; j++) {
            if (!flag[j])
                return j;
        }
        return -1;
    }

    // 数学解法——约瑟夫环问题
    // 反推法
    // 参考网址：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
    public int lastRemaining2(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
