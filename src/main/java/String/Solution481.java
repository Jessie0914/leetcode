package String;

/**
 * @ClassName Solution481
 * @Description 481. 神奇字符串
 * @Author shishi
 * @Date 2019/10/4 15:02
 **/
public class Solution481 {
    public int magicalString(int n) {
        int[] A = new int[100010];
        int[] B = new int[100010];

        // 先初始化A的前几个数字
        A[0] = 1;
        A[1] = 2;
        A[2] = 2;

        // 接下来就是根据A来填充B，再根据B填充A
        int i=0,j=0;
        while (i!=n&&j!=n){
            // 根据A填充B
            while (A[i]!=0&&i!=n&&j!=n){
                int k=0;
                if (j==0 || B[j-1]==2){
                    while (k<A[i]&&j<n){
                        B[j++] = 1;
                        k++;
                    }
                }
                else if (B[j-1]==1){
                    while (k<A[i]&&j<n){
                        B[j++] = 2;
                        k++;
                    }
                }
                i++;
                if (i==n) break;
            }

            if (j>=n) break;
            else {
                // 然后根据B去填充A
                int p=i;
                while (p<j){
                    A[p] = B[p];
                    p++;
                }
            }
        }

        int count=0;
        // B数组最终就是一个n的数组
        for (int q=0;q<n;q++){
            if (B[q]==1)
                count++;
        }
        return count;
    }
}
