package sort.quicksort;

/**
 * @ClassName Solution75
 * @Description 75.颜色分类
 * @Author shishi
 * @Date 2019/7/13 16:12
 **/

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例：
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]==0) num0++;
            else if (nums[i]==1) num1++;
            else num2++;
        }
        int index = 0;
        for (int i=0;i<num0;i++){
            nums[index++] = 0;
        }
        for (int i=0;i<num1;i++){
            nums[index++] = 1;
        }
        for (int i=0;i<num2;i++){
            nums[index++] = 2;
        }
    }
}
