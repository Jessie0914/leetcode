/**
 * @ClassName Solution172
 * @Description 172.阶乘后的零
 * @Author shishi
 * @Date 2019/7/20 18:51
 **/

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class Solution172 {
    // 其实就是看有多少对2*5的组合，又因为2的个数一定会比5多，所以就直接算小于等于n的数字中包含5的数字有多少即可
    public int trailingZeroes(int n) {
        int result = 0;
        while (n>=5){
            result+=n/5;
            n/=5;
        }
        return result;
    }
}
