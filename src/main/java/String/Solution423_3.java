package String;

/**
 * @ClassName Solution423_3
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/9 11:07
 **/
public class Solution423_3 {
    public String originalDigits(String s) {
        int[] count = new int[26+(int)'a'];
        for (int i=0;i<s.length();i++){
            count[s.charAt(i)] ++;
        }

        // 0 2 4 6 8被唯一标识
        // 0-z 2-w 4-u 6-x 8-g
        int[] out = new int[10];
        out[0] = count['z'];
        out[2] = count['w'];
        out[4] = count['u'];
        out[6] = count['x'];
        out[8] = count['g'];

        // h只会在3、8中出现，所以知道了8的个数，3的个数也可以确定
        // f只会在4、5中出现
        // s只会在6、7中出现
        // o只会在0、1、2、4中出现
        // i只会在5、6、8、9中出现
        out[3] = count['h']-out[8];
        out[5] = count['f']-out[4];
        out[7] = count['s']-out[6];
        out[1] = count['o']-out[0]-out[4]-out[2];
        out[9] = count['i']-out[5]-out[6]-out[8];

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<10;i++){
            if (out[i]>0){
                for (int j=0;j<out[i];j++){
                    sb.append(i);
                }
            }
        }
        return sb.toString();
    }
}
