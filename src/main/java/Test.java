import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/29 20:44
 **/
public class Test {
    public static void main(String[] args) {
        String s = "abcwaquigew";
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int count = hashMap.getOrDefault(c, 0);
            count+=1;
            hashMap.put(c,count);
        }
    }
}
