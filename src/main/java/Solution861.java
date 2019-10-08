/**
 * @ClassName Solution861
 * @Description 861. 翻转矩阵后的得分
 * @Author shishi
 * @Date 2019/9/15 16:07
 **/

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 */
public class Solution861 {
    // 本来我一开始以为只有一行或者一列的时候
    public int matrixScore(int[][] A) {
        // 先从上往下，保证所有的行的开始都是以1开始，其实不用，比如说
        for (int i=0;i<A.length;i++){
            int[] line = A[i];
            // 如果以0开始那就把所有的数字都颠倒
            if (line[0]==0){
                for (int j=0;j<line.length;j++){
                    if (line[j]==0) line[j] = 1;
                    else line[j] = 0;
                }
            }
        }

        // 再竖着看，从第一列开始，一列的数字如果0比较多，那么就全部颠倒
        for (int j=1;j<A[0].length;j++){
            int numOfZero = 0;
            int numOfOne = 0;
            for (int i=0;i<A.length;i++){
                if (A[i][j]==0) numOfZero++;
                else numOfOne++;
            }
            // 如果0比较多，那么全部颠倒
            if (numOfZero>numOfOne){
                for (int i=0;i<A.length;i++){
                    if (A[i][j]==0) A[i][j]=1;
                    else A[i][j]=0;
                }
            }
        }

        // 开始计算颠倒后的矩阵值
        int sum = 0;
        for (int i=0;i<A.length;i++){
            for (int j=0;j<A[i].length;j++){
                int num = A[i][j];
                sum += num * Math.pow(2,A[i].length-1-j);
            }
        }
        return sum;
    }
}
