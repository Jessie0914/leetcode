/**
 * @ClassName Solution231
 * @Description 231.2的幂
 * @Author shishi
 * @Date 2019/7/2 19:57
 **/

/**
 * 题目要求：
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class Solution231 {
    public static void main(String[] args) {
        isPowerOfTwo(16);
    }
    public static boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        if (n==1) return true;
        while (n>1){
            int yushu = n%2;
            if (yushu!=0){
                return false;
            }
            n/=2;
        }
        return true;
    }
}
