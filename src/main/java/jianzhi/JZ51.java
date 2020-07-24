package jianzhi;

/**
 * @Classname JZ51
 * @Description 构建乘积数组
 * @Date 2020/7/24 2:52 下午
 * @Created by chiyue
 */
public class JZ51 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0)
            return null;

        if (A.length == 1)
            return new int[]{0};

        int[] B = new int[A.length];
        int tmp = 1;
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            tmp *= A[i - 1];
            B[i] = tmp;
        }
        tmp = A[A.length-1];
        for (int i = A.length - 2; i >= 0; i--) {
            B[i] *= tmp;
            tmp *= A[i];
        }
        return B;
    }
}
