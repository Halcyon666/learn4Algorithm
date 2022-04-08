import java.math.BigDecimal;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/30 23:31
 */
public class Test {
    public static void main(String[] args) {
        int scale = 1;
        double value = 0.555555555555;
        BigDecimal temBig = new BigDecimal(Double.toString(value));
        temBig = temBig.setScale(scale,BigDecimal.ROUND_HALF_EVEN);
        BigDecimal bigDecimal = temBig.stripTrailingZeros();

        System.out.println("strVaule = " + bigDecimal.toPlainString());
    }
}
