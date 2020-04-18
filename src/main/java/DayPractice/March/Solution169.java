package DayPractice.March;

/**
 * @ClassName Solution169
 * @Description 169. 多数元素
 * @Author shishi
 * @Date 2020/4/2 14:37
 **/

/**
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int candinate = nums[0];
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i]==candinate)
                count++;
            else {
                count--;
                if (count<0){
                    candinate = nums[i];
                    count = 1;
                }
            }
            i++;
        }
        return candinate;
    }
}
