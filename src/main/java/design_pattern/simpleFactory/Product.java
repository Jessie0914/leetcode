package design_pattern.simpleFactory;

/**
 * @ClassName SimpleFactory
 * @Description TODO
 * @Author shishi
 * @Date 2020/3/14 11:15
 **/
public interface Product {
    public void hi();
}

class Product1 implements Product {
    public void hi() {
        System.out.println("产品1号");
    }
}

class Product2 implements Product {
    public void hi() {
        System.out.println("产品2号");
    }
}

class Product3 implements Product {
    public void hi() {
        System.out.println("产品3号");
    }
}


class SimpleFactory {
    public Product getProduct(String type) {
        Product p = null;

        switch (type) {
            case "one":
                p = new Product1();
                break;
            case "two":
                p = new Product2();
                break;
            case "three":
                p = new Product3();
                break;
            default:
                break;
        }
        return p;
    }
}

class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.getProduct("2");
        product.hi();
    }
}
