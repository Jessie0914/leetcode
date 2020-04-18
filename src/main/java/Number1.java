import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Number1
 * @Description TODO
 * @Author shishi
 * @Date 2020/3/27 19:30
 **/
public class Number1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }

            Arrays.sort(nums);

            int k = 0;
            for (; k < n; k++) {
                if (nums[k] != 0)
                    break;
            }

            if (k >= n)
                System.out.println(-1);
            else
                System.out.println(n - k + 1);
        }
    }
}
