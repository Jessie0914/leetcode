package stack;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {

    // 建立一个hashMap映射，存放括号之间的对应关系
    private HashMap<Character,Character> mappings;

    // 初始化这个hashMap
    public Solution20(){
        this.mappings = new HashMap<Character,Character>();
        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');
    }

    // 判断函数
    public boolean isValid(String s) {
        // 初始化一个stack
        Stack<Character> characterStack = new Stack<>();

        for (int i=0;i<s.length();i++){
            // 拿到当前字符
            char c = s.charAt(i);

            // 如果这个字符在hashmap的key中（即这个是一个闭括号）
            if (this.mappings.containsKey(c)){
                // 取栈顶元素
                char topElement = characterStack.empty() ? '#' : characterStack.pop();

                // 如果闭括号和当前栈顶元素不匹配，就可以直接判断为false了
                if (topElement != this.mappings.get(c)){
                    return false;
                }
            }

            // 不是闭括号，就压入栈
            else {
                characterStack.push(c);
            }
        }

        // 如果最后栈为空，就说明全部匹配，返回true，否则就是为false
        // 也适用于字符串本身为空的情况，因为此时栈也为空
        if (characterStack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
