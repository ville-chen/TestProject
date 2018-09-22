package jdk.generic_type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 * 限定通配符<? extends T>：向上限定，用来保证 泛型类型 必须是T或T的子类型
 */
public class Test1 {
    //同理 ？类型未知，所以不能加入一种确定的类型
    public static void fillNumberList(List<? extends Number> list) {
        //list.add(new Integer(0));//编译错误
        //list.add(new Float(1.0));//编译错误
    }

    public static void printIntValue(List<? extends Number> list) {
        //父类中的接口，子类中肯定存在，所以向上限定可以被迭代
        for (Number number : list) {
            System.out.print(number.intValue() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //向上限定
        //1.错误使用
        List<? extends Integer> list1 = new ArrayList<Integer>();
        list1.add(null);
        //？类型未知，所以不能加入一种确定的类型
        //list1.add(new Integer(1));//编译错误
        //list1.add(new Float(1.0));//编译错误

        //1.错误使用常规使用
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        fillNumberList(integerList);
        List<Float> floatList = new ArrayList<>();
        floatList.add((float) 3.3);
        floatList.add((float) 0.3);
        fillNumberList(floatList);
    }
}