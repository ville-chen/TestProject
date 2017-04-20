import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by admin on 2017/4/17.
 */
public class Test {

    public static void main(String[] args) {
        DecimalFormat df_temp = new DecimalFormat("#.###");
        System.out.println(new BigDecimal(df_temp.format(new BigDecimal("5").divide(new BigDecimal(3), 3, BigDecimal.ROUND_UP))));



    }
}
