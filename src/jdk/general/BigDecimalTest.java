package jdk.general;

import java.math.BigDecimal;

/**
 * @author Ville
 * @date 2018/7/25
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal coin = BigDecimal.valueOf(32154.56).setScale(2);
        BigDecimal rate = BigDecimal.valueOf(0.007).setScale(3);
        System.out.println(coin.multiply(rate).setScale(3, BigDecimal.ROUND_CEILING));

        //错误示范
        /*BigDecimal coin = new BigDecimal(32154.56).setScale(2);
        BigDecimal rate = new BigDecimal(0.007).setScale(3);
        System.out.println(coin.multiply(rate).setScale(3, BigDecimal.ROUND_CEILING));*/

    }
}
