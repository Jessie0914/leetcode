package math;

import java.util.Arrays;

/**
 * @ClassName Solution204_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/25 15:42
 **/
public class Solution204_2 {
    // 希腊数学家厄拉多塞筛选法
    // 具体操作：先将 2~n 的各个数放入表中，然后在2的上面画一个圆圈，然后划去2的其他倍数；
    // 第一个既未画圈又没有被划去的数是3，将它画圈，再划去3的其他倍数；
    // 现在既未画圈又没有被划去的第一个数 是5，将它画圈，并划去5的其他倍数……
    // 依次类推，一直到所有小于或等于 n 的各数都画了圈或划去为止。
    // 这时，表中画了圈的以及未划去的那些数正好就是小于 n 的素数。
    public int countPrimes(int n) {
        // 用空间换时间，用一个数组来标记一个数是否是质数
        boolean[] isPrime = new boolean[n];
        // 先全部填充为true
        Arrays.fill(isPrime,true);

        // 遍历数组，采用上面介绍的厄拉多塞筛选法，标记有些数字
        for (int i=2;i*i<isPrime.length;i++){
            // 找到一个素数，将它的倍数都记为false
            if (isPrime[i]==true){
                for (int j=i*i;j<isPrime.length;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        int count = 0;
        // 最后遍历数组，找出那些为true的值，即为素数的个数
        for (int i=2;i<isPrime.length;i++){
            if (isPrime[i]==true) count++;
        }
        return count;
    }
}
