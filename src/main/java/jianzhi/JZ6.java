package jianzhi;

/**
 * @ClassName JZ6
 * @Description
 * @Author shishi
 * @Date 2020/7/12 18:48
 **/
public class JZ6 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int i = 1;
        for (; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return array[i];
        }

        return array[i-1];
    }
}
