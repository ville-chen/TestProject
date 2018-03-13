package generic_type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 * ? super Number用法：向下限定，可以添加下限类型或下限的父类型
 */
public class Test2 {
    //不能对向下限定的对象list进行迭代，因为没有公共的迭代逻辑
    public static void fillNumberList(List<? super Number> list) {
        list.add(0);
        list.add(1.0f);
    }

    public static void main(String[] args) {
        //向下限定：限定为Number或Number的父类型（Object）
        List<? super Number> list = new ArrayList<Number>();
        //假设泛型限定参数类型为Number，那Integer和Float都可以向上转型为Number
        list.add(new Integer(1));
        list.add(new Float(1.1));
    }


}
