package jianzhi;

/**
 * @ClassName JZ12
 * @Description 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @Author shishi
 * @Date 2020/7/12 20:07
 **/
public class JZ12 {
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1.0D;

        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);

        if (exponent % 2 == 0) {
            double temp = Power(base, exponent / 2);
            if (flag)
                return temp * temp;
            else
                return 1.0 / (temp * temp);
        } else {
            double temp = Power(base, exponent / 2);

            if (flag)
                return base * temp * temp;
            else
                return 1.0 / (base * temp * temp);
        }
    }
}
