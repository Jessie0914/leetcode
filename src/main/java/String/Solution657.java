package String;

/**
 * @ClassName Solution657
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/30 16:32
 **/

/**
 * 输入: "UD"
 * 输出: true
 *
 * 输入: "LL"
 * 输出: false
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int row=0,col=0;
        for (int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            switch (c){
                case 'U':
                    col++;
                    break;
                case 'D':
                    col--;
                    break;
                case 'L':
                    row--;
                    break;
                case 'R':
                    row++;
                    break;
                default:
                    break;
            }
        }
        return row==0&&col==0;
    }
}
