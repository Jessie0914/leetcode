package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName Solution384
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/13 16:44
 **/
public class Solution384 {
    private int[] array;
    private int[] original;
    private Random random = new Random();

    public Solution384(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        // 此时array和original就又是同一个对象了，所以需要将original重新copy一个对象赋给本身
        // clone()是开辟一个新的对象的方法
        original = original.clone();
        return array;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List aux = getArrayCopy(array);

        for (int i=0;i<array.length;i++){
            // 从aux这个list中每次取一个数（通过随机下标来取），取完就删除
            int removed_randomIndex = random.nextInt(aux.size());

            array[i] = (int)aux.get(removed_randomIndex);
            aux.remove(removed_randomIndex);
        }
        return array;

    }

    private List getArrayCopy(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        return list;
    }
}
