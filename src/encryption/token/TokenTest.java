package encryption.token;

/**
 * @author Ville
 * @date 2019/2/28
 */
public class TokenTest {

    public static void main(String[] args) {
        testToken();
    }

    public static void testToken() {
        //获取加密seed
        char key = 'B' ^ '6';
        /*
         * token解密
         */
        String eToken = "BGF@DLM";
        for (char c : eToken.toCharArray()) {
            System.out.print((char) (c ^ key));
        }
        System.out.println();
        /*
         * token加密
         */
        char[] idChars = "6324089".toCharArray();
        for (char c : idChars) {
            System.out.print((char) (c ^ key));
        }
    }
}
