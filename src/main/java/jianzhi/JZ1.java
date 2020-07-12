package jianzhi;

/**
 * @ClassName JZ1
 * @Description
 * @Author shishi
 * @Date 2020/7/12 14:21
 **/
public class JZ1 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        int len = array.length;
        int i = len - 1;
        int j = 0;

        // 从从左下角开始遍历
        // 往上是递减，往右是递增
        while (i >= 0 && j < array[0].length) {
            if (array[i][j] == target)
                return true;
            else if (array[i][j] > target)
                i--;
            else
                j++;
        }

        return false;
    }
}
