/**
 * @ClassName Solution191
 * @Description 191.位1的个数
 * @Author shishi
 * @Date 2019/7/19 10:52
 **/

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class Solution191 {
    // you need to treat n as an unsigned value
    // 位运算
    // 任何数字n与1做与运算，都可以得到它的最低位
    // 然后把1的32位数左移一位和n做与运算，就可以得到它的倒数第二位
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i=0;i<32;i++){
            if ((mask & n)!=0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
