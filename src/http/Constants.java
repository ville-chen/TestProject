package http;

/**
 * Created by ville on 2017/7/5.
 */
public class Constants {

    /**
     * cne生成label接口地址
     */
    public static final String LABEL_URL = "http://label.cnexps.com/CnePrint";

    /**
     * 货物标签样式种类
     * 标签10X10,有配货   参数：label10x10_1
     * 标签10X10,无配货   参数：label10x10_0
     * 标签A4_6,有配货   参数：labelA46_1
     * 标签A4_6,无配货   参数：labelA46_0
     * 标签10X15,有配货   参数：label10x15_1
     * 标签10X15,无配货   参数：label10x15_0
     */
    public static final String PTEMP = "label10x10_0";
}
