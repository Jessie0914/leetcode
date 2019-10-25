package String;

import java.util.*;

/**
 * @ClassName Solution423_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/9 10:37
 **/
public class Solution423_2 {
    public String originalDigits(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        // 先遍历字符串存入一个hashMap
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        List<Integer> list = new ArrayList<>();

        while (hashMap.size()!=0){
            // 说明有8
            if (hashMap.containsKey('g')){
                int num_eight = hashMap.get('g');
                for (int i=0;i<num_eight;i++){
                    list.add(8);
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
            // 说明有4
            else if (hashMap.containsKey('u')){
                int num_four = hashMap.get('u');
                for (int i=0;i<num_four;i++){
                    list.add(4);
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
            // 说明有2
            else if (hashMap.containsKey('w')){
                int num_two = hashMap.get('w');
                for (int i=0;i<num_two;i++){
                    list.add(2);
                    hashMap.put('t',hashMap.get('t')-1);
                    hashMap.put('w',hashMap.get('w')-1);
                    hashMap.put('o',hashMap.get('o')-1);
                }
                if (hashMap.get('t')==0) hashMap.remove('t');
                if (hashMap.get('w')==0) hashMap.remove('w');
                if (hashMap.get('o')==0) hashMap.remove('o');
                if (hashMap.size()==0) break;
            }
            // 说明有6
            else if (hashMap.containsKey('x')){
                int num_six = hashMap.get('x');
                for (int i=0;i<num_six;i++){
                    list.add(6);
                    hashMap.put('s',hashMap.get('s')-1);
                    hashMap.put('i',hashMap.get('i')-1);
                    hashMap.put('x',hashMap.get('x')-1);
                }
                if (hashMap.get('s')==0) hashMap.remove('s');
                if (hashMap.get('i')==0) hashMap.remove('i');
                if (hashMap.get('x')==0) hashMap.remove('x');
                if (hashMap.size()==0) break;
            }
            // 说明有0
            else if (hashMap.containsKey('z')){
                int num_zero = hashMap.get('z');
                for (int i=0;i<num_zero;i++){
                    list.add(0);
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
            else {
                // 经过上面的处理，剩下的又可以唯一确定一些数字
                while (hashMap.size()!=0){
                    // 说明有5
                    if (hashMap.containsKey('f')){
                        int num_five = hashMap.get('f');
                        for (int i=0;i<num_five;i++){
                            list.add(5);
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
                    // 说明有3
                    else if (hashMap.containsKey('h')){
                        int num_three = hashMap.get('h');
                        for (int i=0;i<num_three;i++){
                            list.add(3);
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
                    // 说明有7
                    else if (hashMap.containsKey('s')){
                        int num_seven = hashMap.get('s');
                        for (int i=0;i<num_seven;i++){
                            list.add(7);
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
                    else {
                        // 又可以确定一些数字
                        while (hashMap.size()!=0){
                            // 说明有9
                            if (hashMap.containsKey('i')){
                                int num_nine = hashMap.get('i');
                                for (int i=0;i<num_nine;i++){
                                    list.add(9);
                                    hashMap.put('n',hashMap.get('n')-2);
                                    hashMap.put('i',hashMap.get('i')-1);
                                    hashMap.put('e',hashMap.get('e')-1);
                                }
                                if (hashMap.get('n')==0) hashMap.remove('n');
                                if (hashMap.get('i')==0) hashMap.remove('i');
                                if (hashMap.get('e')==0) hashMap.remove('e');
                                if (hashMap.size()==0) break;
                            }
                            else {
                                while (hashMap.size()!=0){
                                    // 说明有1
                                    if (hashMap.containsKey('n')){
                                        int num_one = hashMap.get('n');
                                        for (int i=0;i<num_one;i++){
                                            list.add(1);
                                            hashMap.put('o',hashMap.get('o')-1);
                                            hashMap.put('n',hashMap.get('n')-1);
                                            hashMap.put('e',hashMap.get('e')-1);
                                        }
                                        if (hashMap.get('o')==0) hashMap.remove('o');
                                        if (hashMap.get('n')==0) hashMap.remove('n');
                                        if (hashMap.get('e')==0) hashMap.remove('e');
                                        if (hashMap.size()==0) break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
