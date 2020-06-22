package ali_leetcode_daily;

/**
 * @ClassName Solution137
 * @Description 只出现一次的数字 II
 * @Author shishi
 * @Date 2020/6/17 21:51
 **/
public class Solution137 {
    public static void main(String[] args) {
        int i = 5;
        System.out.println(i >>> 0);
        System.out.println(i >>> 1);
        System.out.println(i >>> 2);
        System.out.println(i >>> 3);
        System.out.println(i >>> 4);
        System.out.println(i >>> 5);
        System.out.println(i >>> 6);
        System.out.println(i >>> 10);
        System.out.println(i >>> 16);
        System.out.println(i >>> 26);
        System.out.println(i >>> 31);
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                // 如果当前位是1
                if (((nums[j] >>> i) & 1) == 1)
                    count++;
            }
            if (count % 3 != 0) {
            }
        }
        return ans;
    }
}
