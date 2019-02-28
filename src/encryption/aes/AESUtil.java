package encryption.aes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * AES加密算法工具类
 */
public class AESUtil {

    /**
     * AES加密方法
     */
    public static byte[] encrypt(String original, String seedStr) {
        if (null == original || "".equals(original)) {
            return null;
        }
        if (null == seedStr || "".equals(seedStr)) {
            return null;
        }
        Cipher cipher = getCipher(seedStr, Cipher.ENCRYPT_MODE);
        if (null == cipher) {
            return null;
        }
        byte[] originalByteArray = original.getBytes(StandardCharsets.UTF_8);
        try {
            return cipher.doFinal(originalByteArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 字节（密文） => 16进制字符串（密文）
     */
    public static String byte2HexStr(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            hex = hex.length() == 1 ? String.format("0%s", hex) : hex;
            builder.append(hex.toUpperCase());
        }
        return builder.toString();
    }

    /**
     * 16进制字符串（密文） => 字节（密文）
     */
    public static byte[] hexStr2Byte(String hexStr) {
        if (hexStr.length() != 32)
            return null;
        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            bytes[i] = (byte) (high * 16 + low);
        }
        return bytes;
    }

    /**
     * AES解密方法
     */
    public static byte[] decrypt(byte[] encryptedByteArray, String seedStr) {
        if (null == encryptedByteArray || 16 != encryptedByteArray.length) {
            return null;
        }
        if (null == seedStr || "".equals(seedStr)) {
            return null;
        }
        Cipher cipher = getCipher(seedStr, Cipher.DECRYPT_MODE);
        if (null == cipher) {
            return null;
        }
        try {
            return cipher.doFinal(encryptedByteArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 获取暗号生成器
     */
    private static Cipher getCipher(String seedStr, int encryptMode) {
        Cipher cipher = null;
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seedStr.getBytes());
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] encodedByteArray = secretKey.getEncoded();
            SecretKeySpec sks = new SecretKeySpec(encodedByteArray, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(encryptMode, sks);
            return cipher;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cipher;
        }
    }

    public static void main(String[] args) {
        String[] name = {"金刚", "王磊", "吴肖", "屠彧", "陈玉梅", "沈芳", "朱信州", "静静", "漏丽娜", "黄衍", "王斌", "陈达", "王云", "方志剑", "静静", "侯慧敏", "赵晗", "陈伟利", "陈丹锋", "文冬", "郑珲", "郑依纯", "杨锡源", "杨益华", "赵宇", "田旭敏", "谭习尧", "黄鑫鑫", "王莉", "王涛", "张晓珂", "刘果", "胡杏", "卢晓璐", "陈汪亮", "李启帆", "吴咸洋", "黄河高峰", "金维然", "方康", "徐鸿辉", "黄利强", "詹桂芳", "邵烂烂", "客服", "叶星星", "周淑萍", "郭庚", "芦红军", "户雷", "金暘程", "王镇富", "章红芳", "王雪锋", "肖智慧", "卜腊梅", "周云龙", "邵虹霞", "柳翔", "麦清", "明振林", "段铮铮", "邵宇甲", "付春辉", "卓立宇", "王蓉", "易谦", "胡海军", "杨永杰", "曹安邦", "潘玉婷", "袁鑫", "黄淑萍", "mohun", "林斌", "陈贤跃", "周华颖", "杨乐燕", "齐超", "夏慧芳", "佘翠兰", "陈文飞", "谭夏宁", "张逸飞", "钟程捷", "李远", "滕安益", "徐翠", "代春阳", "潘一明", "赵云飞", "李鑫兴", "王斌2", "王建彬", "侨兴基金1", "侨欣基金2", "刘远航", "李伟巍"};
        String[] loginName = {"jingang", "stonerock", "outfit", "out-tuyu", "chenyumei", "shenfang", "zhuxinzhou", "curie0909", "loulina18", "huangyan", "wangbin18", "chenda17", "wangyun", "fangzj", "outfit-jj", "houhuimin", "zhaohan", "ville_", "chendanfeng", "wendong", "outfit-zhenghui", "outfit-zhengyichun", "outfit-yangxiyuan", "yangyihua", "outfit-zhaoyu", "outfit-tianxumin", "outfit-tanxiyao", "outfit-HXX", "wangli", "wangtao", "zxkfeel", "outfit-liuguo", "outfit-huxing", "outfit-luxiaolu", "outfit-Cwl", "outfit-Lqf", "wxyang", "outfit-huanghe", "outfit-jinw", "outfit-fangkang", "outift-Xuhh", "outfit-huanglq", "outfit-zhangf", "outfit-shaoll", "outfit-kfb", "outfit-Yxx", "outfit-zhousp", "outfit-guog", "outfit-luhj", "outfit-hulei", "outfit-Jin", "outfit-wangzf", "outfit-ZhangHF", "outfit-wangxf", "outfit-xiaozz", "outfit-pulm", "outfit-Zhouyl", "outfit-shaohx", "liuxiang", "outfit-maiqing", "outfit-mingzj", "outfit-duanzz", "outfit-shaoyj", "outfit-fuchunhui", "outiflt-zhuoliyu", "outfit-huang", "outfit-yiqian", "huhaijun", "outfit-yyj", "outfit-caoab", "outfit-panyuting", "outfit-yuanxin", "outfit-hsp", "liumouliang", "outfit-linbin", "outfit-chenxianyue", "outfit-zhouhuay", "outfit-yangLyan", "outfit-qichao", "outfit-xhf", "outfit-yucl", "outfit-chenwenfei", "outfit-tanxianing", "outfit-zhangyifei", "outfit-zhongcj", "outfit-liyuan", "outfit-tengay", "outfit-xucui", "outfit-daicy", "outfit-panym", "outfit-zhaoyf", "outfit-lixx", "outfit-wangbin2", "outfit-wangjb", "qiaoxing1", "qiaoxing2", "outfit-lyh", "outfit-liww"};
        String[] encryptedStr = {"4AE3B9A2D97F708B30EB374CE0B098D6", "D630FD2A4FD95C82CCBBE7B81C7FBAE5", "CD654917A82E8093EEA97900DC1E2727", "F70E9E28C0D40411178F3F50C465929E", "A804A27E8CC0DAC23DB2EFEF1FC75655", "C509D2F854CAF65E2156D6B966CDA085", "EF778036ED273920465D04AB29DCEDB6", "B1BD273F2BA644AB63BE1834BD133969", "25B5109E5E769BE1947DD89CFB75B54A", "7237CA5B986AAEB40BE53515A2820ECA", "7D2CBED6A37C14EB97F9A02807943994", "C7366372921B491007EF3390F10B3297", "318E24F4FDC1424ADF92EB46B4312880", "5491CE02E0F1298CF83E109F2B5CDD85", "B1BD273F2BA644AB63BE1834BD133969", "3B67CF9CA3EA514860B647F9BF0BEAE5", "A17A6DD53EDB28AD45F013F4BA1179D3", "BE3BDDE0F832DC8A56A7E9831499A591", "4DF5390716F8FED8879965B4264D2AE7", "A761099D74CE185224080DF38993409E", "79CE40CFAF50CB8599A27391DB24ED36", "DB40E293ADCC24A7E9AF564179BB4E1C", "975E63D729FFCB91A450B149254DC163", "93F7086BE091D5EDAADA24E6DAFF7B77", "D959E6295A7759CFFC63C957152E436E", "9B2CDED5E8123188BA38486F9ED6B398", "38AEB6475DAB78F16A9D7F44E443A413", "8650D4AB42E2BEE07874756189D70567", "BF4C31D62749EDBF8F8F33AD8250DEC9", "6330861472B48AF6C212AD65EB50CD3D", "31CB83B4A81858153AF272CD084E93F1", "0B684F5AB682B2334D74FBC8D23F35F5", "5A0472EDDE3C419EEC65DCEDFEFCCCCC", "755A2FD74FBB2D40BF95F6A6115D6E23", "D5C6A0A714527CCD525E08E670AE8EE3", "3E4F6AB892A0FD0C82F60355E4E06C7A", "8E47643D100CEAE35B25E91CDE5C3BEE", "8D6DF5CDC180BE43AA0D8D2D8CC9160B", "95FBA9F88E4977E2617C6BA775DC682E", "A1909F577482B0F3F84F2C792E712CFC", "DBBA96ABC407400965A35F55B4119E95", "4B4F47B8107CF76FE36A73662667C24A", "FE98AD0A96691D758D36A41F58D632D6", "572235026FCCBC3778C35489E5FF41E9", "1B06335306E0CB4E481AFC67FA9FBC8D", "4C69F4C828A83AC69D41E71BB16F764B", "0C5B86AFF0A701FAA47FDC32653294ED", "24E1A5DD37B707B3750191EC8C8FAD94", "B24493BD05F4131EFEBE63994BAF6C04", "BCACB25A7A0E22B0ADF355A0D69E7865", "A9F5BF3554CD3C992BBDD5FDBB3A2532", "752E5D4934568760E9AF0DC66F29B8F4", "0337107BCCF5DA82943880FFD223037C", "29DF193D6B97B219687BB92C641A517A", "C0059B0BED2898486DBB275D80BE94B9", "8A44120F5545082F2B62C9C79E08637A", "1BF6775991773CE4C5E40E820C0D27A7", "7E64F9A4C952FD869C4201A82A8C65C7", "99497A07314977B63AC5D1E9DF73AD1C", "43CAA7E5D6AA642C19C08B43A4877C58", "84109EF1D548864901936B08468F326C", "8D6BD34D988E24FF76E7A581C08E5C5F", "A91352590D08EF6545D53904665584CE", "AF0AC137205DCA1A46B8562DE18AF25E", "7D3BF1F9E5C8E70D7BA491E4B5D93AF7", "C40659835F266694A19A9B92B99C6E4E", "013D02FE5F63599D77881C2876E3889C", "D07D98DA78A2BB0C7DE2E4C39832A61E", "5D6633DA7D402C0D565788EC181D9EF0", "0544FE2A5FE5DFA9E138EFBC0155EB97", "67200DF829C87DFA3CAEC1085F21D99B", "7D1E05C6D8384B42EE120918A1EA8835", "7C30555E8537C5E84940AEEC3C4FD1DA", "1BED325FCF0D76B1182021AC170E17F3", "F925F453356F082B796F8237D7286715", "2CBA3FFD22979D3D56F2894A32889D52", "D2A4907FB4770EDE15D70E0A67B82D7F", "95C0F5A2E2055CBF83D461608A7F9F19", "D445C77CF83D3D15B3FF04938E895917", "1BF18E976DCBBDB09A4603273E288AF4", "A8D0D0C7357C5791942710C23761116A", "E43E3FDE216BAA39B9C1E24FE0D2D412", "1DBCEA3243A428020599726A453E36E8", "B9207749C2B278E0EFA3B1290991084D", "C5E9573C34E81EFA35A44EA6CEA06C37", "AA25ACEBD71B8E8754166BD886AD4343", "8320CC3F0683921D538D92F343B05E95", "A8996C1A33E3693F6ED5551841C899CA", "A7B515242BED4C822E1A5EBE2BC8B2B4", "2D243E900DCCFAAC26AF2DD9EF0C0E20", "9527A8D4F1E99417219B431EEE565C35", "A26956C811D39C75C2BBCB48C095C89B", "010887EB7E3DDB9E8E7F95D8741926C9", "B44367B92099B32DCAE1895D70F1B828", "13F1AFED939BEABAC2D6AEA78AD74FD4", "553E4FEF3C26D4BF388815F2638F3651", "5FB846C9082645076B11B4DBF0ADC92C", "48566B7C4B78244192975484D2A84296"};
        for (int i = 0; i < encryptedStr.length; i++) {
            System.out.print(name[i] + "：");
            System.out.print(loginName[i]);
            crack(encryptedStr[i]);
        }
    }

    private static void crack(String encryptedStr) {
        String seedStr = "journey-admin-password";
        byte[] encryptedBytes = hexStr2Byte(encryptedStr);
        byte[] decryptedBytes = decrypt(encryptedBytes, seedStr);
        if (null != decryptedBytes) {
            String original = new String(decryptedBytes, StandardCharsets.UTF_8);
            System.out.println(", " + original);
        }
    }
}
