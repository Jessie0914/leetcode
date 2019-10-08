package test;

import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author shishi
 * @Date 2019/9/26 14:16
 **/
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] split = s.split(",");
        String a = split[0];
        String b = split[1];
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        int countA = 0;
        int lengthA = charA.length;
        int i=charA.length-1;
        while (i>=0&&charA[i]=='/'){
            countA++;
            i--;
        }

        int countB = 0;
        int lengthB = charB.length;
        int j=0;
        while (j<charB.length&&charB[j]=='/'){
            countB++;
            j++;
        }

        String newA = String.valueOf(charA,0,lengthA-countA);
        String newB = String.valueOf(charB,countB,lengthB-countB);
        String result = newA + "/" + newB;
        System.out.println(result);
    }
}
