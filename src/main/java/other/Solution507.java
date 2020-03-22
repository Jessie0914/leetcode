package other; /**
 * @ClassName Solution507
 * @Description 507.完美数
 * @Author shishi
 * @Date 2019/7/20 11:06
 **/

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 */
public class Solution507 {
    // Tips：完美数只有 6, 28, 496, 8128, 33550336 这几个，可以通过判断该数字是否为以下几个来解决
    // 参考网址：https://mp.weixin.qq.com/s?__biz=MzU5MTcyOTQ5OA==&mid=2247484347&idx=1&sn=cb44e2d04105caf834beb5e4aa593458&chksm=fe2bc58ec95c4c985160af6bbb3dc32079c9eddcdafd7e94aec9305e7fa192ef74d1532a8090&mpshare=1&scene=1&srcid=&key=7f1d049d633b1d67966ceef522e7102ea8cb6639461fa3bd4ca787bbc40091ec08fbd4fa305ce25350b2df78d423a75b6fdedb8182af12098a09146477cb31da636b5d58423610dd54724a852e7e79ec&ascene=1&uin=MTE4ODM1MDMzNQ%3D%3D&devicetype=Windows+10&version=62060833&lang=zh_CN&pass_ticket=OBuGM9uOb4bn9h1fSckJhnx0bR4dqeu2MyASAdUjvrI5aVZB2ln7aS2mGbqBuuZT
    public boolean checkPerfectNumber(int num) {
        // 记得之前也做过类似的求因子的例子
        // 注意的点是：循环找因子的时候，只需要找到sqrt(n)为止就可以了，因为因子都是前后对应的，以sqrt(n)为界限
        int sum = 1;
        if (num==1) return false;
        // 遍历到平方根就可以了
        int i=2;
        for (;i<Math.sqrt(num);i++){
            if (num%i==0){
                sum+=i;
                sum+=num/i;
            }
        }
        if (i*i==num){
            sum+=i;
        }
        return num==sum;
    }
}
