package math;

/**
 * @ClassName Test
 * @Description TODO
 * @Author shishi
 * @Date 2020/2/10 20:34
 **/

/**
 * 36进制由0-9，a-z，共36个字符表示，最小为'0'
 * '0'~'9'对应十进制的0~9，'a'~'z'对应十进制的10~35
 * 例如：'1b' 换算成10进制等于 1 36^1 + 11 36^0 = 36 + 11 = 47
 * 要求按照加法规则计算出任意两个36进制正整数的和
 * 如：按照加法规则，计算'1b' + '2x' = '48'
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(test("1b","2x"));
    }

    public static String test(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int len1 = A.length;
        int len2 = B.length;
        int i = len1 - 1;
        int j = len2 - 1;
        int carry = 0;
        int res = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int num = 0;
            if (i >= 0) {
                char c = A[i];
                if (Character.isDigit(c))
                    num += c - '0';
                else
                    num += c - 'a' + 10;
            }
            i--;

            if (j >= 0) {
                char c = B[j];
                if (Character.isDigit(c))
                    num += c - '0';
                else
                    num += c - 'a' + 10;
            }
            j--;

            if (carry != 0)
                num += carry;

            if (num >= 36) {
                carry = num / 36;
                num = num % 36;
            }else
                carry = 0;

            if (num<=9)
                sb.append(num);
            else
                sb.append((char)(num-10+'a'));

        }
        StringBuilder reverse = sb.reverse();

        return reverse.toString();
    }
}
