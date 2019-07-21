package sort.countsort;

/**
 * @ClassName Solution274
 * @Description 274.H指数
 * @Author shishi
 * @Date 2019/7/13 18:27
 **/

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），
 * 一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 *
 * 示例：
 * 输入: citations = [3,0,6,1,5]
 * 输出: 3
 */
public class Solution274 {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length];
        int i=0;
        for (;i<count.length;i++){
            for (int j=0;j<citations.length;j++){
                if (citations[j]>=i+1){
                    count[i]++;
                }
            }
            if (count[i]<i+1) break;
        }
        return i;
    }
}
