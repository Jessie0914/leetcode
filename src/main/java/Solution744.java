/**
 * @ClassName Solution744
 * @Description 744. 寻找比目标字母大的最小字母
 * @Author shishi
 * @Date 2019/10/25 19:29
 **/

/**
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 输入：
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target>=letters[letters.length-1])
            return letters[0];
        int i=0;
        for (;i<letters.length;i++){
            if (letters[i]>target)
                return letters[i];
        }
        return letters[i];
    }
}
