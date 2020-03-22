package other; /**
 * @ClassName Solution13
 * @Description 13.罗马数字转整数
 * @Author shishi
 * @Date 2019/6/28 15:50
 **/

import java.util.Hashtable;

/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 我看了一下別的人的代码，都比较简介，主要是他们直接在map中放入所有可能性的组合，然后在遍历的时候，先考虑两位一起，不存在的话再考虑一位
 */
public class Solution13 {
    public int romanToInt(String s) {
        Hashtable<Character, Integer> romanValue = new Hashtable<>();
        romanValue.put('I',1);
        romanValue.put('V',5);
        romanValue.put('X',10);
        romanValue.put('L',50);
        romanValue.put('C',100);
        romanValue.put('D',500);
        romanValue.put('M',1000);

        char[] romans = new char[30];
        int index = 0;
        // 把罗马数字一个个放入数组
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            romans[index++] = c;
        }

        int result = 0;
        int length = index;
        int i = 0;
        while(i<length){
            char c = romans[i];
            if (c=='I'&&romans[i+1]=='V'){
                result+=4;
                i+=2;
            }else if (c=='I'&&romans[i+1]=='X'){
                result += 9;
                i+=2;
            }else if (c=='X'&&romans[i+1]=='L') {
                result += 40;
                i += 2;
            }else if (c=='X'&&romans[i+1]=='C') {
                result += 90;
                i += 2;
            }else if (c=='C'&&romans[i+1]=='D'){
                result += 400;
                i+=2;
            }else if (c=='C'&&romans[i+1]=='M') {
                result += 900;
                i += 2;
            }else {
                result += romanValue.get(c);
                i++;
            }
        }
        return result;
    }
}
