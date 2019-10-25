package String;

/**
 * @ClassName Solution423
 * @Description 423. 从英文中重建数字
 * @Author shishi
 * @Date 2019/10/9 9:45
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: "owoztneoer"
 * 输出: "012" (zeroonetwo)
 *
 * 输入: "fviefuro"
 * 输出: "45" (fourfive)
 */
public class Solution423 {
    public String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> hashMap = new HashMap<>();
        // 先遍历字符串存入一个hashMap
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        while (hashMap.size()!=0){
            // 遍历0-9的英文字母
            // 如果有0：zero
            if (hashMap.containsKey('z')){
                int num_zero = hashMap.get('z');
                for (int i=0;i<num_zero;i++){
                    sb.append(0);
                    hashMap.put('z',hashMap.get('z')-1);
                    hashMap.put('e',hashMap.get('e')-1);
                    hashMap.put('r',hashMap.get('r')-1);
                    hashMap.put('o',hashMap.get('o')-1);
                }
                // 如果zero中某一个字母个数为0，就删除
                if (hashMap.get('z')==0) hashMap.remove('z');
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.get('r')==0) hashMap.remove('r');
                if (hashMap.get('o')==0) hashMap.remove('o');
                if (hashMap.size()==0) break;
            }
            // 如果有1：one
            else if (hashMap.containsKey('o')&&hashMap.containsKey('n')&&hashMap.containsKey('e')){
                // 1的个数为这三个字符的个数中的最小值
                int num_one = Math.min(hashMap.get('o'),hashMap.get('n'));
                num_one = Math.min(num_one,hashMap.get('e'));
                for (int i=0;i<num_one;i++){
                    sb.append(1);
                    hashMap.put('o',hashMap.get('o')-1);
                    hashMap.put('n',hashMap.get('n')-1);
                    hashMap.put('e',hashMap.get('e')-1);
                }
                if (hashMap.get('o')==0) hashMap.remove('o');
                if (hashMap.get('n')==0) hashMap.remove('n');
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.size()==0) break;
            }
            // 如果有2：two
            else if (hashMap.containsKey('t')&&hashMap.containsKey('w')&&hashMap.containsKey('o')){
                int num_two = Math.min(hashMap.get('t'),hashMap.get('w'));
                num_two = Math.min(num_two,hashMap.get('o'));
                for (int i=0;i<num_two;i++){
                    sb.append(2);
                    hashMap.put('t',hashMap.get('t')-1);
                    hashMap.put('w',hashMap.get('w')-1);
                    hashMap.put('o',hashMap.get('o')-1);
                }
                if (hashMap.get('t')==0) hashMap.remove('t');
                if (hashMap.get('w')==0) hashMap.remove('w');
                if (hashMap.get('o')==0) hashMap.remove('o');
                if (hashMap.size()==0) break;
            }
            // 如果有3：three
            else if (hashMap.containsKey('t')&&hashMap.containsKey('h')&&hashMap.containsKey('r')&&hashMap.containsKey('e')){
                int num_three = Math.min(hashMap.get('t'),hashMap.get('h'));
                num_three = Math.min(num_three,hashMap.get('r'));
                num_three = Math.min(num_three,hashMap.get('e')/2);
                for (int i=0;i<num_three;i++){
                    sb.append(3);
                    hashMap.put('t',hashMap.get('t')-1);
                    hashMap.put('h',hashMap.get('h')-1);
                    hashMap.put('r',hashMap.get('r')-1);
                    hashMap.put('e',hashMap.get('e')-2);
                }
                if (hashMap.get('t')==0) hashMap.remove('t');
                if (hashMap.get('h')==0) hashMap.remove('h');
                if (hashMap.get('r')==0) hashMap.remove('r');
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.size()==0) break;
            }
            // 如果有4：four
            else if (hashMap.containsKey('f')&&hashMap.containsKey('o')&&hashMap.containsKey('u')&&hashMap.containsKey('r')){
                int num_four = Math.min(hashMap.get('f'),hashMap.get('o'));
                num_four = Math.min(num_four,hashMap.get('u'));
                num_four = Math.min(num_four,hashMap.get('r'));
                for (int i=0;i<num_four;i++){
                    sb.append(4);
                    hashMap.put('f',hashMap.get('f')-1);
                    hashMap.put('o',hashMap.get('o')-1);
                    hashMap.put('u',hashMap.get('u')-1);
                    hashMap.put('r',hashMap.get('r')-1);
                }
                if (hashMap.get('f')==0) hashMap.remove('f');
                if (hashMap.get('o')==0) hashMap.remove('o');
                if (hashMap.get('u')==0) hashMap.remove('u');
                if (hashMap.get('r')==0) hashMap.remove('r');
                if (hashMap.size()==0) break;
            }
            // 如果有5：five
            else if(hashMap.containsKey('f')&&hashMap.containsKey('i')&&hashMap.containsKey('v')&&hashMap.containsKey('e')){
                int num_five = Math.min(hashMap.get('f'),hashMap.get('i'));
                num_five = Math.min(num_five,hashMap.get('v'));
                num_five = Math.min(num_five,hashMap.get('e'));
                for (int i=0;i<num_five;i++){
                    sb.append(5);
                    hashMap.put('f',hashMap.get('f')-1);
                    hashMap.put('i',hashMap.get('i')-1);
                    hashMap.put('v',hashMap.get('v')-1);
                    hashMap.put('e',hashMap.get('e')-1);
                }
                if (hashMap.get('f')==0) hashMap.remove('f');
                if (hashMap.get('i')==0) hashMap.remove('i');
                if (hashMap.get('v')==0) hashMap.remove('v');
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.size()==0) break;
            }
            // 如果有6：six
            else if (hashMap.containsKey('s')&&hashMap.containsKey('i')&&hashMap.containsKey('x')){
                int num_six = Math.min(hashMap.get('s'),hashMap.get('i'));
                num_six = Math.min(num_six,hashMap.get('x'));
                for (int i=0;i<num_six;i++){
                    sb.append(6);
                    hashMap.put('s',hashMap.get('s')-1);
                    hashMap.put('i',hashMap.get('i')-1);
                    hashMap.put('x',hashMap.get('x')-1);
                }
                if (hashMap.get('s')==0) hashMap.remove('s');
                if (hashMap.get('i')==0) hashMap.remove('i');
                if (hashMap.get('x')==0) hashMap.remove('x');
                if (hashMap.size()==0) break;
            }
            // 如果有7：seven
            else if (hashMap.containsKey('s')&&hashMap.containsKey('e')&&hashMap.containsKey('v')&&hashMap.containsKey('n')){
                int num_seven = Math.min(hashMap.get('s'),hashMap.get('e')/2);
                num_seven = Math.min(num_seven,hashMap.get('v'));
                num_seven = Math.min(num_seven,hashMap.get('n'));
                for (int i=0;i<num_seven;i++){
                    sb.append(7);
                    hashMap.put('s',hashMap.get('s')-1);
                    hashMap.put('e',hashMap.get('e')-2);
                    hashMap.put('v',hashMap.get('v')-1);
                    hashMap.put('n',hashMap.get('n')-1);
                }
                if (hashMap.get('s')==0) hashMap.remove('s');
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.get('v')==0) hashMap.remove('v');
                if (hashMap.get('n')==0) hashMap.remove('n');
                if (hashMap.size()==0) break;
            }
            // 如果有8：eight
            else if (hashMap.containsKey('e')&&hashMap.containsKey('i')&&hashMap.containsKey('g')&&hashMap.containsKey('h')&&hashMap.containsKey('t')){
                int num_eight = Math.min(hashMap.get('e'),hashMap.get('i'));
                num_eight = Math.min(num_eight,hashMap.get('g'));
                num_eight = Math.min(num_eight,hashMap.get('h'));
                num_eight = Math.min(num_eight,hashMap.get('t'));
                for (int i=0;i<num_eight;i++){
                    sb.append(8);
                    hashMap.put('e',hashMap.get('e')-1);
                    hashMap.put('i',hashMap.get('i')-1);
                    hashMap.put('g',hashMap.get('g')-1);
                    hashMap.put('h',hashMap.get('h')-1);
                    hashMap.put('t',hashMap.get('t')-1);
                }
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.get('i')==0) hashMap.remove('i');
                if (hashMap.get('g')==0) hashMap.remove('g');
                if (hashMap.get('h')==0) hashMap.remove('h');
                if (hashMap.get('t')==0) hashMap.remove('t');
                if (hashMap.size()==0) break;
            }
            // 如果有9：nine
            else if (hashMap.containsKey('n')&&hashMap.containsKey('i')&&hashMap.containsKey('e')){
                int num_nine = Math.min(hashMap.get('n')/2,hashMap.get('i'));
                num_nine = Math.min(num_nine,hashMap.get('e'));
                for (int i=0;i<num_nine;i++){
                    sb.append(9);
                    hashMap.put('n',hashMap.get('n')-2);
                    hashMap.put('i',hashMap.get('i')-1);
                    hashMap.put('e',hashMap.get('e')-1);
                }
                if (hashMap.get('n')==0) hashMap.remove('n');
                if (hashMap.get('i')==0) hashMap.remove('i');
                if (hashMap.get('e')==0) hashMap.remove('e');
                if (hashMap.size()==0) break;
            }
        }
        return sb.toString();
    }
}
