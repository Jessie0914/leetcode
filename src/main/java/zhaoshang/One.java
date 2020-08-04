package zhaoshang;

import java.util.Scanner;

/**
 * @Classname One
 * @Description TODO
 * @Date 2020/8/3 2:59 下午
 * @Created by chiyue
 */

/**
 * 10
 * 1 2 3 123 5 8 999 777 156 95
 * 123   0001 0010 0011
 */
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            int num = nums[i];
            int[] tmp = new int[3];
            int index = 2;
            while (num != 0) {
                tmp[index--] = num % 10;
                num /= 10;
            }

            for (int j = 0; j < 3; j++) {
                StringBuilder builder = new StringBuilder();
                int x = tmp[j];
                String s = Integer.toBinaryString(x);
                int len = s.length();
                int leftLen = 4 - len;

                while (leftLen > 0) {
                    builder.append('0');
                    leftLen--;
                }
                builder.append(s);
                sb.append(builder.toString());
            }
            strings[i] = sb.toString();
        }

        // 首尾翻转
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                strings[i] = "0";
            } else {
                strings[i] = reverse(strings[i]);
                int j = 0;
                while (j < strings[i].length() && strings[i].charAt(j) == '0') {
                    j++;
                }
                StringBuilder builder = new StringBuilder();
                builder.append(strings[i], j, strings[i].length());
                strings[i] = builder.toString();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(strings[i]);
        }
    }

    private static String reverse(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            char c = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = c;
        }
        return String.valueOf(chars);
    }
}
