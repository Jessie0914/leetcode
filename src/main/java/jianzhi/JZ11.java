package jianzhi;

/**
 * @ClassName JZ11
 * @Description 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @Author shishi
 * @Date 2020/7/12 19:29
 **/
public class JZ11 {
    // 作弊算法1：Integer.toBinaryString(n);
    public int NumberOf1(int n) {
        String s = Integer.toBinaryString(n);

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }

        return count;
    }

    // 作弊算法2:Integer.bitCount(n);
    public int NumberOf1_1(int n) {
        return Integer.bitCount(n);
    }

    // "正确的"算法：
    public int NumberOf1_2(int n) {
        int count = 0;

        int flag = 1;
        while (flag != 0) {
            if ((n & flag) == 1)
                count++;

            flag = flag << 1;
        }

        return count;
    }
}
