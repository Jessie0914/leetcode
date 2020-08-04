package zhaoshang;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Classname Three
 * @Description TODO
 * @Date 2020/8/3 3:35 下午
 * @Created by chiyue
 */
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        PriorityQueue<Integer> list = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        list.add(s);

        if (s < 0 && m > 0) {
            System.out.println("-1");
            return;
        }

        if (m <= 0) {
            System.out.println("0");
            return;
        }

        while (m > 0 || !list.isEmpty()) {
            Integer num = list.poll();
            count++;

            int tmp = 0;
            if (num % 2 == 0) {
                int x = num / 2;
                tmp = x * x;
                list.add(x);
                list.add(x);
            } else {
                int x = num / 2;
                tmp = x * (x + 1);
                list.add(x);
                list.add(x + 1);
            }

            m -= tmp;

            if (m < 0) {
                System.out.println(count-1);
                return;
            }

            if (list.isEmpty() && m > 0) {
                System.out.println("-1");
                return;
            }
        }
    }
}
