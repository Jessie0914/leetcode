import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName Number
 * @Description TODO
 * @Author shishi
 * @Date 2020/3/27 19:12
 **/

/**
 * 2
 * 5
 * 4 9 5 2 2
 * 1 3 5 1 4
 * 3
 * 2 1 2
 * 2 1 2
 */
class Sticks {
    int l = 0;
    int w = 0;
    int k = 1;

    public Sticks() {

    }
}

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int index = 0;
        Sticks a = new Sticks();
        while (index < count) {
            int n = scanner.nextInt();
            int h = n;
            Sticks[] sticks = new Sticks[n];
            for (int i = 0; i < n; i++) {
                sticks[i] = new Sticks();
            }
            for (int i = 0; i < n; i++)
                sticks[i].l = scanner.nextInt();
            for (int i = 0; i < n; i++)
                sticks[i].w = scanner.nextInt();
            for (int i = 0; i < n; i++)
                sticks[i].k = 1;

            Arrays.sort(sticks, new Comparator<Sticks>() {
                @Override
                public int compare(Sticks a, Sticks b) {
                    if (a.l == b.l)
                        return a.w - b.w;
                    return a.l - b.l;
                }
            });

            for (int i = 0; i < n - 1; i++) {
                if (sticks[i].k == 0)
                    continue;
                sticks[i].k = 0;
                a.l = sticks[i].l;
                a.w = sticks[i].w;
                a.k = sticks[i].k;
                for (int j = i + 1; j < n; j++) {
                    if (sticks[j].k == 1 && sticks[j].l >= a.l && sticks[j].w >= a.w) {
                        sticks[j].k = 0;
                        a.l = sticks[j].l;
                        a.w = sticks[j].w;
                        a.k = sticks[j].k;
                        h--;
                    }
                }

            }
            System.out.println(h);

            index++;
        }
    }

}
