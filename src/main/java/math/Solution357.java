package math;

/**
 * @ClassName Solution357
 * @Description 357. 计算各个位数不同的数字个数
 * @Author shishi
 * @Date 2019/11/3 18:42
 **/

/**
 * n==1: sum = 10;
 * n==2: sum = 9 * 9 + fun(1);
 * n==3: sum = 9 * 9 * 8 + fun(2);
 * n==4: sum = 9 * 9 * 8 * 7 + fun(3);
 * ……
 * 总结规律就是：
 * 第一位先选除了0以外的数字（9种可能），第二位再选除了第一位的数字（9种可能），以此类推……
 * 最后再加上n-1的所有种可能
 */
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        int sum;
        if (n==0) return 1;
        else if (n==1) return 10;
        else {

            sum = 9;
            for (int i=0;i<n-1;i++){
                sum = sum * (9-i);
            }
            sum += countNumbersWithUniqueDigits(n-1);
        }
        return sum;
    }
}
