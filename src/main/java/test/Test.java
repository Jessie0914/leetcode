package test;

/**
 * @program: leetcode
 * @description:
 * @author: shishi
 * @create: 2020-01-09 20:12
 **/

public class Test {
    static {
        System.out.println("加载外部类");
    }

    class InnerClass{
        public InnerClass() {
            System.out.println("内部类");
        }
//        static {
//            System.out.println("加载内部类");
//        }
//        static void innerMethod() {
//            System.out.println("内部类的静态方法");
//        }
//        static int a;
    }

    public static void main(String[] args) {
        Test out=new Test();
//        InnerClass innerClass = out.new InnerClass();
//        System.out.println("=============");
//		Test.InnerClass.a=1;
    }
}
