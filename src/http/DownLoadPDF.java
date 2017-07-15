package http;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by admin on 2017/7/14.
 * 下载在线pdf
 */
public class DownLoadPDF {

    public static void main(String[] args) throws IOException {

        uploadLabelAsPDF("71", "LX404862404CN", "2581418260de313945eea0037a163291");
    }

    private static void uploadLabelAsPDF(String icID, String cNums, String signature) throws IOException {
        String requestURL = Constants.LABEL_URL + "?icID=" + icID + "&cNums=" + cNums + "&ptemp=" + Constants.PTEMP
                + "&signature=" + signature;
        URL url = new URL(requestURL);
        URLConnection conn = url.openConnection();
        // 设置通用的请求属性
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.connect();
        OutputStream out = conn.getOutputStream();
        out.flush();
        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

        File target = new File("D:/test.pdf");
        FileOutputStream writer = new FileOutputStream(target);

        byte[] temp = new byte[1024];
        while (in.read(temp) != -1) {
            writer.write(temp);
        }
    }
}
