package programming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/4/5.
 */
public class ArrayAndCollection {
    public static void main(String[] args) {
        Integer[] arr = {97, 98, 99};
        List<Integer> list = Arrays.asList(arr);

        Integer[] newArr = new Integer[arr.length];
        newArr = list.toArray(newArr);

        for (int s : newArr) {
            System.out.print(s + " ");
        }
    }


}
