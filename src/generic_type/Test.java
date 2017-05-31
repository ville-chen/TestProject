package generic_type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public class Test {

    public static void main(String[] args) {
        //List<?> 是一个未知类型的List，而List<Object>其实是任意类型的List。你可以把List<String>, List<Integer>赋值给List<?>,
        //却不能把List<String>赋值给List<Object>

        //错误用法：引用泛型限定和实例泛型限定
        //1.泛型之间, 明确的泛型Integer不能赋值给明确的泛型Object
        //List<Object> list = new ArrayList<Integer>(); false

        //2.通配符类型<？ extends Integer>是不确定的，可以用作声明，但不能用于实例化
        //List<Integer> list = new ArrayList<? extends Integer>(); false

        //3.引用类型泛型限定范围必须要大于等实例泛型限定
        //List<? extends Integer> l1 = new ArrayList<Integer>(); true
        //List<? extends Object> l2 = new ArrayList<Integer>(); true
        //List<? extends Double> l3 = new ArrayList<Integer>(); false

        //但是即使引用泛型范围大于等于实例范围，依旧不能通过引用对象，向其添加元素，因为它仍旧是未知的
        List<? extends Integer> list1 = new ArrayList<Integer>();
        //？类型未知，所以不能加入一种确定的类型
        //list1.add(new Integer(1));//编译错误

        //4.类型参数T在类和方法声明的时候使用，代表元素类型,在上下文中可以使用
        //List<T> l3 = new ArrayList<Integer>(); false
        //List<T extends Integer> l3 = new ArrayList<Integer>(); false
    }
}
