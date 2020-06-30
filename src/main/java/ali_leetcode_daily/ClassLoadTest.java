package ali_leetcode_daily;

/**
 * @ClassName Test
 * @Description 初始化顺序
 * @Author shishi
 * @Date 2020/6/28 20:08
 **/
public class ClassLoadTest {
    static {
        System.err.println("静态代码块");
    }

    private Student student = new Student();
//    ClassLoadTest test = new ClassLoadTest();

    public ClassLoadTest() {
        System.err.println("构造函数");
    }

    {
        System.err.println("普通代码块");
    }

    private static User user = new User();

    public static void main(String[] args) {
        System.err.println("main函数");
        new ClassLoadTest();
    }
}

class Student {
    public Student() {
        System.err.println("普通实例变量");
    }
}

class User {
    public User() {
        System.err.println("静态实例变量");
    }
}
