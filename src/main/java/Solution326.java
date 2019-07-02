/**
 * @ClassName Solution326
 * @Description 326.3的幂
 * @Author shishi
 * @Date 2019/7/2 20:09
 **/
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        if (n==1) return true;
        while (n>1){
            int yushu = n%3;
            if (yushu!=0){
                return false;
            }
            n/=3;
        }
        return true;
    }
}
