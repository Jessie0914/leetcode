package other;

/**
 * @ClassName Solution605
 * @Description 605.种花问题
 * @Author shishi
 * @Date 2019/7/26 16:20
 **/

public class Solution605 {
    // 如果①当前值的为0，②且前一个元素也为0或者其下标为-1，③且后一个元素也为0或者其下标为length，那么就填充为1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
         for (int i=0;i<flowerbed.length;i++){
            if (flowerbed[i]==0
            && ((i-1)==-1 || flowerbed[i-1]==0)
            && ((i+1)==flowerbed.length || flowerbed[i+1]==0)){
                flowerbed[i]=1;
                n--;
            }
        }
        if (n<=0)
            return true;
        else return false;
    }
}