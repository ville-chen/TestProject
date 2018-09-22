package jdk.general;

/**
 * Created by admin on 2017/6/14.
 * 在-128至127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，
 * 这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象
 */
public class IntegerTtest {

    public static void main(String[] args) {
        /*Integer var1 = 127;
        Integer var2 = 127;

        System.out.println(var1 == var2);
        System.out.println(var1.equals(var2));*/

        /*System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        Integer num = Integer.valueOf("2147483648");*/


        /*String str = "01234567890123456789012345678901234567890123456789";
        System.out.println(str.substring(0, str.length()));*/

    }
}
