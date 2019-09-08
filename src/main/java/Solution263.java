/**
 * @ClassName Solution263
 * @Description 263.丑数
 * @Author shishi
 * @Date 2019/7/22 17:52
 **/

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7
 */
public class Solution263 {
    public boolean isUgly(int num) {
        if (num>0) {
            while (num%2==0){
                num/=2;
            }
            while (num%3==0){
                num/=3;
            }
            while (num%5==0){
                num/=5;
            }
            if (num==1) return true;
        }
        return false;
    }
}
