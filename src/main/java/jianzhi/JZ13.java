package jianzhi;

/**
 * @ClassName JZ13
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author shishi
 * @Date 2020/7/12 22:09
 **/
public class JZ13 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1)
            return;

        int i = 0;
        int len = array.length;
        while (i < len) {
            // 遇到偶数，就往后去找第一个奇数
            if (array[i] % 2 == 0) {
                int index = i;
                while (index < len && array[index] % 2 == 0) {
                    index++;
                }

                // 将偶数都后移
                if (index < len) {
                    int evenTmp = array[index];

                    while (index > i) {
                        array[index] = array[index - 1];
                        index--;
                    }
                    // 最后把奇数移到前面来
                    array[i] = evenTmp;
                }
                // 如果遍历到最后已经越界了，说明后面的已经都是偶数了
                else
                    return;
            }
            i++;
        }
    }
}