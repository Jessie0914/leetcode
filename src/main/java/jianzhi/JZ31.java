package jianzhi;

/**
 * @Classname JZ31
 * @Description 求出任意非负整数区间中1出现的次数
 * @Date 2020/7/23 3:37 下午
 * @Created by chiyue
 */
// JZ_MARK
public class JZ31 {
    // https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6?f=discussion
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}
