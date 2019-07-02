/**
 * @ClassName Solution342
 * @Description 342.4的幂
 * @Author shishi
 * @Date 2019/7/2 20:13
 **/
public class Solution342 {
    public boolean isPowerOfFour(int num) {
        if (num<=0) return false;
        if (num==1) return true;
        while (num>1){
            int yushu = num%4;
            if (yushu!=0){
                return false;
            }
            num/=4;
        }
        return true;
    }
}
