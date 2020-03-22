package top_interview;

/**
 * @ClassName Solution4
 * @Description 寻找两个有序数组的中位数
 * @Author shishi
 * @Date 2020/2/27 23:47
 **/
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0 && len2 != 0) {
            if (len2 % 2 == 0)
                return (double) ((nums2[len2 / 2 - 1]) + nums2[len2 / 2]) / 2;
            else
                return (double) nums2[len2 / 2];
        }

        if (len2 == 0 && len1 != 0) {
            if (len1 % 2 == 0)
                return (double) ((nums1[len1 / 2 - 1]) + nums1[len1 / 2]) / 2;
            else
                return (double) nums1[len1 / 2];
        }

        int sumLen = len1 + len2;

        int k = sumLen / 2;
        boolean flag = sumLen % 2 == 0;

        int i = 0;
        int j = 0;
        int count = 0;
        if (flag) {
            double res1 = 0.0, res2 = 0.0;
            while ((i < len1 || j < len2) && count <= k) {
                if (i < len1 && j < len2 && (nums1[i] <= nums2[j])) {
                    res1 = res2;
                    res2 = nums1[i];
                    i++;
                } else if (j < len2) {
                    res1 = res2;
                    res2 = nums2[j];
                    j++;
                }
                count++;
            }
            return (res1 + res2) / 2;
        } else {
            double res1 = 0.0;
            while ((i < len1 || j < len2) && count <= k) {
                if (i < len1 && (nums1[i] <= nums2[j])) {
                    res1 = nums1[i];
                    i++;
                } else if (j < len2) {
                    res1 = nums2[j];
                    j++;
                }
                count++;
            }
            return res1;
        }
    }
}
