/**
 * @ClassName Solution345
 * @Description 345.反转字符串中的元音字母
 * @Author shishi
 * @Date 2019/7/23 15:35
 **/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 元音字母是a e i o
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class Solution345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        // 存放元音字母的下标
        List<Integer> list_index = new ArrayList<>();

        // 存放元音字母（因为不确定有几个字母，所以用list）
        List<Character> reverseList = new ArrayList<>();

        // 遍历数组，把元音字母和它对应的下标都存下来
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='a'||chars[i]=='A'||chars[i]=='e'||chars[i]=='E'||chars[i]=='i'||
                    chars[i]=='I'||chars[i]=='o'||chars[i]=='O'||chars[i]=='u'||chars[i]=='U'){
                list_index.add(i);
                reverseList.add(chars[i]);
            }
        }

        // 确定了有几个元音字母之后，把list转换成array，为了以后的翻转
        char[] reverseArray = new char[reverseList.size()];
        int index = 0;
        // 把list转换成array
        for (int i=0;i<reverseList.size();i++){
            reverseArray[index++] = reverseList.get(i);
        }

        // 翻转
        char[] reversedArray = reverse(reverseArray);

        // 遍历存放元音字母下标的list，然后一一填充存放翻转之后的元音字母下标
        int newIndex = 0;
        Iterator<Integer> iterator = list_index.iterator();
        while (iterator.hasNext()){
            int insertIndex = iterator.next();
            chars[insertIndex] = reversedArray[newIndex++];
        }

        // 最后把正确的char数组，拼接成字符串
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    // 翻转char[]数组
    private char[] reverse(char[] reverseArray) {
        int len = reverseArray.length;
        int middle = reverseArray.length/2;
        for (int i=0;i<middle;i++){
            char tmp = reverseArray[i];
            reverseArray[i] = reverseArray[len-1-i];
            reverseArray[len-1-i] = tmp;
        }
        return reverseArray;
    }

    // 尝试用另外一种比较有效率的方式
    // 用两个指针，一个从前往后找元音字母，一个从后往前找元音字母，找到了就交换
    public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<j){
            // 从前往后找，找到元音字母才停下（不要忘记加上i<j这个条件）
            while ((!(chars[i]=='a'||chars[i]=='A'||chars[i]=='e'||chars[i]=='E'||chars[i]=='i'||
                    chars[i]=='I'||chars[i]=='o'||chars[i]=='O'||chars[i]=='u'||chars[i]=='U')) &&i<j){
                i++;
            }

            // 从后往前找，找到元音字母才停下（不要忘记加上i<j这个条件）
            while ((!(chars[j]=='a'||chars[j]=='A'||chars[j]=='e'||chars[j]=='E'||chars[j]=='i'||
                    chars[j]=='I'||chars[j]=='o'||chars[j]=='O'||chars[j]=='u'||chars[j]=='U')) && i<j){
                j--;
            }

            // 交换
            if (i<j){
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;

                i++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index <chars.length; index++){
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
