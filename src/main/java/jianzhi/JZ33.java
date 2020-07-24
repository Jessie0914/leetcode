package jianzhi;

/**
 * @Classname JZ33
 * @Description 把只包含质因子2、3和5的数称作丑数（Ugly Number）。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @Date 2020/7/23 3:37 下午
 * @Created by chiyue
 */
public class JZ33 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1)
            return 0;

        int[] nums = new int[index + 1];
        nums[0] = 0;
        nums[1] = 1;
        int i = 2;
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;

        while (i <= index) {
            int tmp = Math.min(nums[p1] * 2, Math.min(nums[p2] * 3, nums[p3] * 5));
            nums[i++] = tmp;

            if (tmp == nums[p1] * 2) {
                p1++;
            }
            if (tmp == nums[p2] * 3) {
                p2++;
            }
            if (tmp == nums[p3] * 5)
                p3++;
        }

        return nums[index];
    }
}
