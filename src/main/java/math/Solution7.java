package math;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    /**
     * 官方的简洁的代码
     * 没有用额外的数组空间，也没有将正数和负数分开，处理溢出也很简洁
     * 这里涉及到两个常量：Integer.MAX_VALUE和Integer.MIN_VALUE
     * 前者是-2147483648，后者是2147483647
     * 32为符号整数的范围就是-2147483648~2147483647
     * @param x
     * @return
     */
    public static int reverse(int x){
        int reverseNum = 0;
        while (x!=0){
            int temp = x%10;

            // 处理溢出的部分
            // 在将新的数加入到原本的后面的时候，先判断是否溢出
            // 判断的方式也比较简洁
            if (reverseNum>Integer.MAX_VALUE/10 || (reverseNum==Integer.MAX_VALUE&&temp>=7)){
                return 0;
            }
            // 负数的判断方法是一样的
            if (reverseNum < Integer.MIN_VALUE/10 || (reverseNum == Integer.MIN_VALUE / 10 && temp < -8)){
                return 0;
            }
            // 没有溢出就正常加到后面
            reverseNum = reverseNum*10+temp;
            x/=10;
        }
        return reverseNum;
    }

    /**
     * 我自己写的代码，非常的不简洁。。
     * 其实这个问题主要考的怎么处理溢出，我处理的办法非常的笨拙
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        // 处理溢出
        if (x==-2147483648){
            return 0;
        }
        int reverseNum = 0;
        int[] res = new int[20];
        boolean isNegative = false;
        if (x<0){
            isNegative = true;
            x = -x;
        }
        int index = 0;
        int size = 0;
        while (x!=0){
            int temp = x%10;
            res[index++] = temp;
            size++;
            x/=10;
        }

        // 处理溢出
        if (size==10){
            Long outOfBoundNum = 0L;
            for (int i=0; i<size; i++){
                outOfBoundNum = outOfBoundNum*10+res[i];
            }
            if (outOfBoundNum>=2147483648L){
                return 0;
            }
        }

        // 不会有溢出的情况
        for (int i=0; i<size; i++){
            reverseNum = reverseNum*10+res[i];
        }
        if (isNegative==true){
            reverseNum = -reverseNum;
        }
        return reverseNum;
    }
}
