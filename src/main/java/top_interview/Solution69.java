package top_interview;

/**
 * @ClassName Solution69
 * @Description x 的平方根
 * @Author shishi
 * @Date 2020/3/9 13:21
 **/

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 输入: 4
 * 输出: 2
 * 输入: 8
 * 输出: 2
 */
public class Solution69 {
    // 二分法
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;

        int left = 2;
        int right = x / 2;
        return search(left, right, x);
    }

    private int search(int left, int right, int x) {
        int mid = (left + right) / 2;

        // 注意！！！这里的mid*mid如果超出了int的范围，需要强转成long，否则哪怕声明成long型，还是不对的
        long temp = (long) mid*mid;
        if (temp > x)
            return search(left, mid-1, x);
        else if (temp == x)
            return mid;
        else {
            long temp2 = (long) (mid+1)*(mid+1);
            if (temp2 > x)
                return mid;
            else if (temp2 == x)
                return mid + 1;
            else
                return search(mid + 1, right, x);
        }
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }

        return right;
    }


}
