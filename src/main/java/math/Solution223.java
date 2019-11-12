package math;

/**
 * @program: leetcode
 * @description: 矩形面积
 * @author: shishi
 * @create: 2019-09-10 10:32
 **/

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * 每个矩形由其左下顶点和右上顶点坐标表示
 *
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 */
public class Solution223 {
    // 唉，又是被虐的一天，考虑的情况太复杂，导致无法AC
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int fir_length = C-A;
        int fir_width = D-B;
        int sec_length = G-E;
        int sec_width = H-F;

        int first_area = fir_length * fir_width;
        int second_area = sec_length * sec_width;

        int sumArea = first_area + second_area;
        int cross_length = 0;
        int cross_width = 0;

        // 不相交的情况（这样更简单）
        if (F>=D || E>=C || H<=B || G<=A)
            return sumArea;

//        // 要判断好多情况
//        // 先是不相交的情况
//        // 第一个矩形在左侧，第二个矩形分别在上方、右方和下方的情况
//        if ((A<=E)&&(F>=D||E>=C||H<=B)){
//            return sumArea;
//        }
//        // 第二个矩形在左侧，第一个矩形分别在上方、右方和下方的情况
//        if ((E<=A)&&(B>=H||A>=G||D<=F)){
//            return sumArea;
//        }

        // 剩下相交的情况（下面这种方法简便了很多……不然考虑了太多情况，仍然不行）
        // 找到上下左右边界即可
        int up = Math.min(D,H);
        int down = Math.max(B,F);
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        cross_length = Math.abs(right-left);
        cross_width = Math.abs(up-down);
        sumArea = sumArea - cross_length * cross_width;
        return sumArea;

    }
}