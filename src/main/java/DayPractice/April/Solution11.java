package DayPractice.April;

import java.util.Map;

/**
 * @ClassName Solution11
 * @Description 11. 盛最多水的容器
 * @Author shishi
 * @Date 2020/4/18 12:49
 **/
public class Solution11 {
    // 双指针法
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int maxArea = -1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * (Math.min(height[left], height[right])));

            // 如果小的是左指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }
}
