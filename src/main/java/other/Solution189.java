package other; /**
 * @program: leetcode
 * @description: 189.旋转数组
 * @author: shishi
 * @create: 2019-07-21 16:07
 **/

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Solution189 {
    // 我这里用到了额外的数组
    // 还有一种方法就是使用反转，先把整个数组反转，然后先反转前面k个数据，再反转后面length-k个数据
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        while (k>length){
            k-=length;
        }
        int[] tmp;
        tmp = Arrays.copyOfRange(nums,length-k,length);
        int index = 0;
        for (int i=length-1-k;i>=0;i--){
            nums[length-1-index] = nums[i];
            index++;
        }
        for (int i=0;i<k;i++){
            nums[i] = tmp[i];
        }
    }
}
