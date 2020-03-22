package design_pattern.factory;

/**
 * @ClassName IceCream
 * @Description TODO
 * @Author shishi
 * @Date 2020/3/14 12:43
 **/
interface IceCream {
    public void taste();
}

class AppleIceCream implements IceCream{

    @Override
    public void taste() {
        System.out.println("苹果味");
    }
}

class OrangeCream implements IceCream{

    @Override
    public void taste() {
        System.out.println("橘子味");
    }
}

interface Factory{
    public IceCream createIceCream();
}

class AppleFactory implements Factory{

    @Override
    public IceCream createIceCream() {
        return new AppleIceCream();
    }
}

class OrangeFactory implements Factory{

    @Override
    public IceCream createIceCream() {
        return new OrangeCream();
    }
}

class Client{
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        IceCream iceCream = appleFactory.createIceCream();
        iceCream.taste();
    }
}


