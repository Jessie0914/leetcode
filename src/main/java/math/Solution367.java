package math;

/**
 * @ClassName Solution367
 * @Description 367.有效的完全平方数
 * @Author shishi
 * @Date 2019/7/25 16:56
 **/

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False
 * 说明：不要使用任何内置的库函数，如  sqrt
 *
 * 输入：16
 * 输出：True
 *
 * 输入：14
 * 输出：False
 */
public class Solution367 {
    public static void main(String[] args) {
        Solution367 solution367 = new Solution367();
        boolean perfectSquare = solution367.isPerfectSquare(1);
        System.out.println(perfectSquare);
    }

    // 如果sqrt之后的double值和强转成int型之后的数字相等，就说明是完美数
    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        if ((sqrt - (int) sqrt) == 0.0) return true;
        else return false;
    }

    // 递增判断(会超时)
    public boolean isPerfectSquare2(int num) {
        int i = 0;
        while (i <= num) {
            if (i * i == num) return true;
            else if (i * i < num) {
                i++;
            } else {
                return false;
            }
        }
        return false;
    }

    // 二分法
    public boolean isPerfectSquare3(int num) {
        int start = 0;
        int end = num;
        int middle = start+(start+end)/2;
        while (start<=end){
            if (Math.pow(middle,2)>num){
                end=middle-1;
            }
            else if (Math.pow(middle,2)==num){
                return true;
            }
            else {
                start = middle+1;
            }
            middle = start+(end-start)/2;
        }
        return false;
    }

    // 公式法
    // 利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
    public boolean isPerfectSquare4(int num){
       int i=1;
       while (num>0){
           num-=i;
           i+=2;
       }
       return num==0;
    }
}