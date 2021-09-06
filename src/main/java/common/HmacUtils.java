package common;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Describe: Hmac加密工具类
 * @Author: Bridge
 * @Date: 2018/5/15
 * @Version: 1.00
 */
public class HmacUtils {
    private static final String KEY_MAC = "HmacMD5";

    private static final String KEY_MAC_SHA1 = "HmacSHA1";

    private static final String CHARSET_UTF8 = "UTF-8";


    /*
        使用 HmacSha1 加密
     */
    public static byte[] hmacSha1(byte[] encryptText, String encryptKey) throws Exception {

        byte[] text = encryptText;
        byte[] keyData = encryptKey.getBytes(CHARSET_UTF8);

        SecretKeySpec secretKey = new SecretKeySpec(keyData, KEY_MAC_SHA1);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return byte2hex(mac.doFinal(text)).getBytes(StandardCharsets.UTF_8);
    }

    //二行制转字符串
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }



    /**
     * 加密生成签名
     * @param data 签名的格式
     * @param key  秘钥
     * @return
     */
    public static byte[] hmacSHA512(byte[] data, String key) {
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes("UTF-8"),
                    "HmacSHA512");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            return mac.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * base64编码的变体，由于base64中的=、／和+不适合Url传递，
     * 因此需要将这三个符号替换掉，规则是去掉=，+替换为-，／替换为_
     * @param stringBytes  hmac(hmacSHA512)
     * @return
     */
    public static String base64Url(byte[] stringBytes) {
        try {

            String base64Str = Base64.encodeBase64String(stringBytes);
            base64Str = base64Str.replace("=", "");
            base64Str = base64Str.replace("+", "-");
            base64Str = base64Str.replace("/", "_");

            return base64Str;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * SHA512 加密
     * @param strText (用户密码明文 + salt)
     * @return
     */
    public static byte[] sha512(final String strText) {
        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并指定加密类型
                MessageDigest messageDigest = MessageDigest
                        .getInstance("SHA-512");
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes("UTF-8"));
                // 得到 byte 数组
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Base64加密
     * @param stringbytes
     * @return
     */
    public static String base64(byte[] stringbytes) {
        try {
            String base64Str = Base64.encodeBase64String(stringbytes);
            return base64Str;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}