package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by admin on 2017/4/1.
 * 数组随机化
 */
public class RadomArray {
    //公式：求[Min,Max]之间的随机数:
    //Math.floor(Math.random()*(Max-Min+1))+Min

    //公式2：求[Min,Max]中间的随机数：
    //Min + Math.round(Math.random()* (Max-Min))
    public static int[] random(Integer[] arr) {
        //数据源
        ArrayList list = new ArrayList();
        Collections.addAll(list, arr);
        //返回结果
        int[] result = new int[arr.length];

        int index;
        int rightBorder = arr.length - 1;
        //随机获取20个数，放入结果数组中，每次拿出一个数，数据源长度-1；
        for (int i = 0; i < result.length; i++) {
            index = getRandomNumber(0, rightBorder);
            result[i] = (int) list.get(index);
            list.remove(index);
            rightBorder--;
        }
        return result;
    }

    public static int getRandomNumber(int min, int max) {
        if (max < min) {
            max = max ^ min;
            min = max ^ min;
            max = max ^ min;
        }
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public static void main(String args[]) {
        Integer[] arr = new Integer[20];
        //假设有一长度为20的数组；
        for (int i = 0; i < 20; i++) {
            arr[i] = i;
        }
        //乱序
        System.out.println(Arrays.toString(random(arr)));
    }
}
