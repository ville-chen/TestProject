import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by admin on 2017/4/18.
 * 自定义timestamp格式
 */
public class TimeStampDIY {

    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        //要转换字符串 str_test
        String str_test = null;
        try {
            Timestamp ts = new Timestamp(format.parse(str_test).getTime());
            System.out.println(ts.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
