package design_pattern.abstractFactory;

/**
 * @ClassName AbstractFactory
 * @Description TODO
 * @Author shishi
 * @Date 2020/3/14 12:50
 **/
interface BigIceCream{
    public void taste();
}

interface SmallIceCream{
    public void taste();
}

class AppleBigIceCream implements BigIceCream{

    @Override
    public void taste() {
        System.out.println("苹果味--大份");
    }
}

class AppleSmallIceCream implements SmallIceCream{

    @Override
    public void taste() {
        System.out.println("苹果味--小份");
    }
}

class OrangeBigIceCream implements BigIceCream{

    @Override
    public void taste() {
        System.out.println("橘子味--大份");
    }
}

class OrangeSmallIceCream implements SmallIceCream{

    @Override
    public void taste() {
        System.out.println("橘子味--小份");
    }
}

public interface AbstractFactory {
    public SmallIceCream createSmall();
    public BigIceCream createBig();
}

class AppleFactory implements AbstractFactory{

    @Override
    public SmallIceCream createSmall() {
        return new AppleSmallIceCream();
    }

    @Override
    public BigIceCream createBig() {
        return new AppleBigIceCream();
    }
}

class OrangeFactory implements AbstractFactory{

    @Override
    public SmallIceCream createSmall() {
        return new OrangeSmallIceCream();
    }

    @Override
    public BigIceCream createBig() {
        return new OrangeBigIceCream();
    }
}

class Client{
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        BigIceCream bigApple = appleFactory.createBig();
        SmallIceCream smallApple = appleFactory.createSmall();
        bigApple.taste();
        smallApple.taste();
    }
}
