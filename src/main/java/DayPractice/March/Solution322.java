package DayPractice.March;

/**
 * @ClassName Solution322
 * @Description 322. 零钱兑换
 * @Author shishi
 * @Date 2020/4/2 15:54
 **/

import java.util.Arrays;
import java.util.HashSet;

/**
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class Solution322 {
    // 参考：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=1&sn=f1db6dee2c8e70c42240aead9fd224e6&chksm=9bd7fb33aca07225bee0b23a911c30295e0b90f393af75eca377caa4598ffb203549e1768336&mpshare=1&scene=1&srcid=0402Zse0sy4RzlNW2zkMsAvO&sharer_sharetime=1585816496247&sharer_shareid=d3725ac9aa47b58173415938917345a8&key=c054e4caaf58da473ba52c6beb99e67cc62eb60df22130c51ff40915120ec2ade622312a141a14600d300348c16b2e5b76c1acbbae83bd2b82971e1f7a098dc36e1db78b650a4da37f51a4174f97ec93&ascene=1&uin=MTE4ODM1MDMzNQ%3D%3D&devicetype=Windows+10&version=62080079&lang=zh_CN&exportkey=A8lxgpGg3HbwypMNqp2i6zU%3D&pass_ticket=SdLKAEi0895vEtY0EYGwB40Bp5XHYiuIAtlcx601xoILhyLxipcZGIl92DW7FnCL
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 初始化一个比较大的数字
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
