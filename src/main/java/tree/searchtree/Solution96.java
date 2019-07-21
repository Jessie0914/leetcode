package tree.searchtree;

/**
 * @ClassName Solution96
 * @Description 96.不同的二叉搜索树
 * @Author shishi
 * @Date 2019/7/9 22:44
 **/

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class Solution96 {
    // 解题思路就是从中找规律得到公式，之后计算
    // 一开始生硬的用递归来解决，很快就会超时，不合适，需要用动态规划来解决
    // 公式是：f[n] = ∑f[k-1]*f[n-k]，k的取值是1到n
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;

        for (int i=2;i<=n;i++){
            for (int k=1;k<=i;k++){
                f[i] += f[k-1]*f[i-k];
            }
        }
        return f[n];
    }

    // 上面推到的公式，其实用数学演绎法可以得到总的公式
    // f[n+1] = 2(2n+1)/(n+2)*f[n]
    // 提交之后，发现也并没有提高多少排名
    public int numTrees2(int n) {
        long c = 1;
        for (int i=0; i<n; i++){
            c = 2*(2*i+1)*c/(i+2);
        }
        return (int)c;
    }
}
