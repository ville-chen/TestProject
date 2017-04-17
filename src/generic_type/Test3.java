package generic_type;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 * 无界通配符
 * ？”可以代表任意类型，“任意”也就是未知类型。
 * List<Object>与List<?>并不等同，List<Object>是List<?>的子类。还有不能往List<?> list里添加任意对象
 *
 * 如果想从一个数据类型里获取数据，使用 ? extends 通配符
 * 如果想把对象写入一个数据结构里，使用 ? super 通配符
 * 如果既想存，又想取，那就别用通配符。
 */
public class Test3 {

    //public static void printList(List<Object> list) {
    public static void printList(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + "");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);

    }
}
