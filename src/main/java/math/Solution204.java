package math; /**
 * @ClassName Solution204
 * @Description 204.计算质数
 * @Author shishi
 * @Date 2019/7/25 15:08
 **/

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution204 {
    // 常规方法会超时
    public int countPrimes(int n) {
        if (n<3) return 0;
        int count = 0;
        for (int i=2;i<n;i++){
            if (isPrime(i)==true){
                count++;
            }
        }
        return count;
    }

    // 判断一个数是不是质数
    private boolean isPrime(int n) {
        if (n==1) return false;
        if (n==2) return true;
        // 如果是大于2的偶数，那么一定不是素数
        if (n%2==0) return false;

        for (int i=3;i<=Math.sqrt(n)+1;i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
