package http; /**
 * Created by admin on 2017/6/29.
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class DHLTest {

    public static final String TOKEN_URL = "https://sandbox.dhlecommerce.asia/rest/v1/OAuth/AccessToken?clientId=MTA2NDg0ODE1OA==&password=MjAzMDI5MTU&returnFormat=json";
    public static final String Label_URL = "https://sandbox.dhlecommerce.asia/rest/v2/Label";
    public static final String CLOSE_OUT_URL = "https://sandbox.dhlecommerce.asia/rest/v2/Order/Shipment/CloseOut";

    public static void main(String[] args) {
        //String token = getToken();
        //System.out.println(token);
        String token = "6c1f373009a714599da4ffffff9a30bf";

        for(int i=0; i<10; i++){
            String label = getLabel(token,i);// 封装 Label的json对象
            String label_resp = toPost(Label_URL, label);// 获取Label
            GenerateLabelImage(label_resp);//生成图片
        }

        /*String close_Out = getClose_Out(token,9);// 封装 close_Out的json对象
        String close_resp = toPost(CLOSE_OUT_URL, close_Out);// 获取close_Out
        GenerateClosePDF(close_resp); // 生成pdf*/
    }

    /*
     * 获取token
     */
    public static String getToken() {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(TOKEN_URL);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for (String key : map.keySet()) {
            // System.out.println(key + "--->" + map.get(key));
            // }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        JSONObject fromObject = JSONObject.fromObject(result);
        JSONObject jsonObject = fromObject.getJSONObject("accessTokenResponse");
        String token = jsonObject.get("token").toString();
        return token;
    }

    /*
     * 封装Label的json对象
     */
    public static String getLabel(String token,int i) {
        JSONObject labelr = new JSONObject();
        JSONObject labelRequest = new JSONObject();
        JSONObject hdr = new JSONObject();
        hdr.element("messageType", "LABEL");
        hdr.element("messageDateTime", "2016-11-25T10:40:11+08:00");
        hdr.element("accessToken", token);
        hdr.element("messageVersion", "1.4");
        hdr.element("messageLanguage", "zh_CN");
        JSONObject bd = new JSONObject();
        bd.element("pickupAccountId", "5999999201");
        bd.element("soldToAccountId", "5999999201");
        // bd.element("pickupDateTime", "2016-11-25T10:40:11+08:00");
        JSONObject pickupAddress = new JSONObject(); //揽件地址组
        pickupAddress.element("companyName", "SOLDCRAZY");
        pickupAddress.element("name", "Wolf");
        pickupAddress.element("address1", "A404, No 9, 2nd Nantai Rd");
        pickupAddress.element("address2", "A404, No 9, 2nd Nantai Rd");
        pickupAddress.element("address3", "A404, No 9, 2nd Nantai Rd");
        pickupAddress.element("city", "Humen, Dongguan"); // 城市
        pickupAddress.element("state", "GuangDong"); // 省份
        pickupAddress.element("country", "CN"); // 国家
        pickupAddress.element("postCode", "627008");
        pickupAddress.element("phone", "123456789");  //电话
        pickupAddress.element("email", "PICKUP@abc.com"); //邮箱
        bd.element("pickupAddress", pickupAddress);

        JSONObject shipperAddress = new JSONObject(); //发货人地址
        shipperAddress.element("companyName", "SOLDCRAZY");
        shipperAddress.element("name", "Wolf");
        shipperAddress.element("address1", "A404, No 9, 2nd Nantai Rd");
        shipperAddress.element("address2", "A404, No 9, 2nd Nantai Rd");
        shipperAddress.element("address3", "A404, No 9, 2nd Nantai Rd");
        shipperAddress.element("city", "Humen, Dongguan");
        shipperAddress.element("state", "GuangDong");
        shipperAddress.element("country", "CN");
        shipperAddress.element("postCode", "627008");
        shipperAddress.element("phone", "123456789");
        shipperAddress.element("email", "SHIPPER@abc.com");
        bd.element("shipperAddress", shipperAddress);

        JSONArray shipmentItem = new JSONArray();
        JSONObject shipmentItems = new JSONObject();
        JSONObject consigneeAddress = new JSONObject(); // 收件人地址 重要
        consigneeAddress.element("companyName", "SOLDCRAZY.TW");
        consigneeAddress.element("name", "arno");
        consigneeAddress.element("address1", "A404, No 9, 2nd Nantai Rd");
        consigneeAddress.element("address2", "A404, No 9, 2nd Nantai Rd");
        consigneeAddress.element("address3", "A404, No 9, 2nd Nantai Rd");
        consigneeAddress.element("city", "TaiBei");
        consigneeAddress.element("state", "TaiBei");
        consigneeAddress.element("country", "TW");
        consigneeAddress.element("postCode", "627011"); //邮政编码 澳洲 4位数字,英国 5位数字
        consigneeAddress.element("phone", "123456789");
        consigneeAddress.element("email", "CONSIGNEE@abc.com");
        shipmentItems.element("consigneeAddress", consigneeAddress);

        JSONObject returnAddress = new JSONObject(); // 退件地址
        returnAddress.element("companyName", "SOLDCRAZY");
        returnAddress.element("name", "wolf");
        returnAddress.element("address1", "A404, No 9, 2nd Nantai Rd");
        returnAddress.element("address2", "A404, No 9, 2nd Nantai Rd");
        returnAddress.element("address3", "A404, No 9, 2nd Nantai Rd");
        returnAddress.element("city", "Humen, Dongguan");
        returnAddress.element("state", "Guangdong");
        returnAddress.element("country", "CN");
        returnAddress.element("postCode", "627008");
        returnAddress.element("phone", "123456789");
        returnAddress.element("email", "RETURN@abc.com");
        shipmentItems.element("returnAddress", returnAddress);

        shipmentItems.element("shipmentID", "HKAKK0000000"+i);//订单号  HKAKK开头 卖疯乐专用
        shipmentItems.element("packageDesc", "Test0001");//包裹描述
        shipmentItems.element("totalWeight", 200);//重量 （克）
        shipmentItems.element("totalWeightUOM", "G");//固定为G
        // shipmentItems.element("customerReference1", "CUSTREF1");// 配货描述 50字内
        shipmentItems.element("customerReference2", "Test orderid");// 配货描述
        shipmentItems.element("productCode", "PKD");// 快递服务
        /**
         * PKD 普通平邮    DDU
         * PPS 普通挂号    DDU
         * PKG 经济小包    DDU
         * PKM 快速清关平邮（德国）    DDU
         * PPM 快速清关挂号 （德国）    DDU
         * PLT 商务专线 （中英/中澳）    DDU
         * PLT 商务专线  (中以专线)     DDP
         * PLE 商务专线 （中美特快）    DDP
         **/
        shipmentItems.element("incoterm", "DDU");
        /**
         * incoterm  稅制
         * DDU=收件人清稅
         * DDP=發件人清稅
         **/
        //shipmentItems.element("codValue",0.00);// 到付额  0.00
        //shipmentItems.element("insuranceValue", 0.00);// 保险额
        //shipmentItems.element("freightCharge", 0.00);// 运费
        shipmentItems.element("totalValue", 105.01D);// 小包总价
        shipmentItems.element("currency", "CNY");// 货币单位  3字代码

        JSONArray shipmentContent = new JSONArray();
        JSONObject shipmentContents = new JSONObject(); //包裹产品  可以多个产品
        shipmentContents.element("skuNumber", "SKU0000001"); // 商品编号
        shipmentContents.element("description", "TestSKU"); // 英文名称
        shipmentContents.element("descriptionImport", "SKUIMPORT"); //
        shipmentContents.element("descriptionExport", "测试SKU"); // 中文名称 必填
        shipmentContents.element("itemValue", 100.01D); // 物品单价
        shipmentContents.element("itemQuantity", 1); // 数量
        shipmentContents.element("grossWeight", 100); // 净重
        shipmentContents.element("countryOfOrigin", "CN"); // 来源地
        shipmentContents.element("weightUOM", "G"); // 固定为G
        shipmentContent.add(shipmentContents);

        shipmentItems.element("shipmentContents", shipmentContent);
        shipmentItem.add(shipmentItems);
        bd.element("shipmentItems", shipmentItem);

        JSONObject label = new JSONObject();
        label.element("pageSize", "400x400");
        label.element("format", "PNG");
        label.element("layout", "1x1");

        bd.element("label", label);
        labelRequest.element("hdr", hdr);
        labelRequest.element("bd", bd);
        labelr.element("labelRequest", labelRequest);

        //System.out.println(labelr.toString());

        return labelr.toString();
    }

    /*
     * 封装Close-Out的json对象
     */
    public static String getClose_Out(String token,int i) {
        JSONObject closeOut = new JSONObject();
        JSONObject closeOutRequest = new JSONObject();
        JSONObject hdr = new JSONObject();
        hdr.element("messageType", "CLOSEOUT");
        hdr.element("messageDateTime", "2016-11-25T10:40:11+08:00");
        hdr.element("accessToken", token);
        hdr.element("messageVersion", "1.2");
        hdr.element("messageLanguage", "zh_CN");
        JSONObject bd = new JSONObject();
        bd.element("pickupAccountId", "5999999201");
        bd.element("soldToAccountId", "5999999201");
        bd.element("handoverMethod", 2); //1=送到倉  2=要求提貨   目前选2
        // bd.element("pickupDateTime", "2016-11-25T10:40:11+08:00");

        JSONArray shipmentItems = new JSONArray();
        for(int j=0;j<i;j++){
            JSONObject shipmentItem = new JSONObject();
            shipmentItem.element("shipmentID", "HKAKK0000000"+j);
            shipmentItems.add(shipmentItem);
        }

        bd.element("shipmentItems", shipmentItems);

        closeOutRequest.element("hdr", hdr);
        closeOutRequest.element("bd", bd);
        closeOut.element("closeOutRequest", closeOutRequest);

        //System.out.println(closeOut.toString());

        return closeOut.toString();
    }

    /*
     * Post提交数据
     */
    public static String toPost(String posturl, String json) {
        byte[] bytes = json.getBytes();
        StringBuffer sb = new StringBuffer("");
        try {
            // 创建连接
            URL url = new URL(posturl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            // connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.connect();

            // POST请求
            DataOutputStream out = new DataOutputStream(
                    connection.getOutputStream());
            out.write(bytes);
            out.flush();
            out.close();

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "UTF-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    //base64字符串转化成图片   Label
    public static void GenerateLabelImage(String Str){   //对字节数组字符串进行Base64解码并生成图片
        //解析返回的数据
        JSONObject fromObject = JSONObject.fromObject(Str);
        JSONObject labelResponse = fromObject.getJSONObject("labelResponse");
        JSONObject bdObject = labelResponse.getJSONObject("bd");
        JSONObject respObject = bdObject.getJSONObject("responseStatus");
        String code = respObject.get("code").toString();
        if(code.equals("200")){
            JSONArray labels = bdObject.getJSONArray("labels");
            JSONObject shipment0  = labels.getJSONObject(0);
            String shipmentID = shipment0.get("shipmentID").toString();
            String content0 = shipment0.get("content").toString();

            JSONObject shipment1  = labels.getJSONObject(1);
            String content1 = shipment1.get("content").toString();

            BASE64Decoder decoder = new BASE64Decoder();
            for (int j = 0; j < 2; j++) {
                try{
                    byte[] b = null;
                    String name= "";
                    //Base64解码
                    if(j == 0){
                        b = decoder.decodeBuffer(content0);
                        name=shipmentID+"_0";
                    }else{
                        b = decoder.decodeBuffer(content1);
                        name=shipmentID+"_1";
                    }
                    for(int i=0;i<b.length;++i)
                    {
                        if(b[i]<0)
                        {//调整异常数据
                            b[i]+=256;
                        }
                    }
                    File basePath = new File("d://img");
                    basePath.mkdirs();
                    //生成jpeg图片
                    String imgFilePath = "d://img/"+name+".jpg";//新生成的图片
                    OutputStream out = new FileOutputStream(imgFilePath);
                    out.write(b);
                    out.flush();
                    out.close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    //base64字符串转化成图片   Close
    public static void GenerateClosePDF(String Str){   //对字节数组字符串进行Base64解码并生成图片
        //解析返回的数据
        JSONObject fromObject = JSONObject.fromObject(Str);
        JSONObject closeOutResponse = fromObject.getJSONObject("closeOutResponse");
        JSONObject bdObject = closeOutResponse.getJSONObject("bd");
        JSONObject respObject = bdObject.getJSONObject("responseStatus");
        String code = respObject.get("code").toString();

        if(code.equals("200")){
            String handoverID = bdObject.get("handoverID").toString(); //托運單的號碼
            String handoverNote = bdObject.get("handoverNote").toString();
            try {
                byte[] buffer = new BASE64Decoder().decodeBuffer(handoverNote);
                FileOutputStream out;
                out = new FileOutputStream("d://img/"+handoverID+".pdf");
                out.write(buffer);
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

