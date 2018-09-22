package algorithm;

import java.util.Arrays;

/**
 * @author Ville
 * @date 2018/9/22
 */
public class StringUtils {

    public static void main(String[] args) {

    }


    /*--- 插入字符串系列，定点插入，特点：插入的位置间隔固定，i -= spaceSize，不是 0 == i % spaceSize ---*/
    //测试案例
    /*public static void main(String[] args) {
        //String binaryString = Integer.toBinaryString(1 << 29);
        String binaryString = Integer.toBinaryString(-1 << 31);
        System.out.println("source");
        System.out.println(binaryString);

        System.out.println("format");
        String separator = ","; int spaceSize = 12;
        System.out.println(splitWithInsert(binaryString, separator, spaceSize));
        System.out.println(splitWithReplace(binaryString, separator, spaceSize));
    }*/

    /**
     * 反向定点插入，特点：先插入末尾的，容量变化对后续位置的插入无影响
     *
     * @param source    源字符串
     * @param separator 分隔符
     * @param spaceSize 间隙大小
     * @return 分隔后的字符串
     */
    private static String splitWithInsert(String source, String separator, int spaceSize) {
        StringBuilder builder = new StringBuilder(source);
        for (int i = source.length() - spaceSize; i > 0; i -= spaceSize) {
            builder.insert(i, separator);
        }
        return builder.toString();
    }

    /**
     * 用替换代替插入，特点：数组大小不变 => 下标不变，替换分隔符逗号左边的内容（1）为 （1，），防止出现首部（，1）
     *
     * @param source    源字符串
     * @param separator 分隔符
     * @param spaceSize 间隙大小
     * @return 分隔后的字符串
     */
    private static String splitWithReplace(String source, String separator, int spaceSize) {
        StringBuilder builder = new StringBuilder(source.length());
        Arrays.stream(source.split("")).forEach(builder::append);
        for (int i = source.length() - 1 - spaceSize; i >= 0; i -= spaceSize) {
            builder.replace(i, i + 1, builder.substring(i, i + 1).concat(separator));
        }
        return builder.toString();
    }
}
