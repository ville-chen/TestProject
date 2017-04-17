package generic_type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
public class Test2 {
    //不能对向下限定的对象list进行迭代，因为没有公共的迭代逻辑
    public static void fillNumberList(List<? super Number> list) {
        list.add(new Integer(0));
        list.add(new Float(1.0));
    }

    public static void main(String[] args) {
        //向下限定：限定为Number或Number的父类型（Object）
        List<? super Number> list = new ArrayList();
        //假设泛型限定参数类型为数，那么正数，小数都是数的子类，符合条件；
        //所以在这里，Integer和Float都是可以的
        list.add(new Integer(1));
        list.add(new Float(1.1));
    }


}
