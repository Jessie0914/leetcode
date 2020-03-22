package top_interview;

/**
 * @ClassName Solution11
 * @Description 盛最多水的容器
 * @Author shishi
 * @Date 2020/2/28 16:56
 **/

/**
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
// 好的方法是双指针法
public class Solution11 {
    // 暴力方法，可行
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        int len = height.length;
        int max = Integer.MIN_VALUE;
        if (len == 2)
            return Math.min(height[0], height[1]);
        else {
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int low = Math.min(height[i], height[j]);
                    if ((j - i) * low > max)
                        max = (j - i) * low;
                }
            }
        }
        return max;
    }

    // 双指针法
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        int len = height.length;

        int i = 0;
        int j = len - 1;
        int maxArea = 0;
        while (i <= j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea)
                maxArea = area;

            // 看i和j哪个数字小就移动哪个指针
            // 这样才有希望获得更大的面积
            if (height[i] <= height[j]) {
                i++;
            } else
                j--;
        }
        return maxArea;
    }
}
