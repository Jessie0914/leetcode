package array;

/**
 * @ClassName Solution645
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/13 14:31
 **/

/**
 * 集合 S 包含从1到 n 的整数。给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 */
public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        int repeat = 0;
        int disappear = 0;
        for (int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }

        for (int i=1;i<count.length;i++){
            if (count[i]==0)
                disappear = i;
            else if (count[i]==2)
                repeat = i;

            if (repeat!=0&&disappear!=0)
                break;
        }

        return new int[]{repeat,disappear};
    }
}
