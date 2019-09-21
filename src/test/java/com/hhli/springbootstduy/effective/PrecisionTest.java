package com.hhli.springbootstduy.effective;

import java.math.BigDecimal;

/**
 * @author 李辉辉
 * @date 2019/9/6 8:45
 * @description 精度测试
 */
public class PrecisionTest {
    static  BigDecimal TEN_CENTS = new BigDecimal("0.1");

    public static void main(String[] args) {
        System.out.println("1.00-0.9=" + (1.00 -0.9));
        System.out.println("1.03-0.62=" + (1.03 -0.62));

        BigDecimal funds = new BigDecimal("1.0");
        int itemBought = 0;
        for ( BigDecimal price = new BigDecimal(".1");  funds.compareTo(price)>=0; price=price.add(TEN_CENTS)) {
            funds  = funds.subtract(price);
            itemBought++;
        }

        System.out.println(itemBought + " items bought");
        System.out.println("Changes: $" + funds);
    }
}
