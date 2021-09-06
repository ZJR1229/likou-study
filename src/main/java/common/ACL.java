package common;

import java.text.SimpleDateFormat;
import java.util.*;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ACL {
    public static String getSign() {
        String urlPath = "http://ip.alibaba.net/ip/api/releaseIpAddress.json";
        String secretKey = "8e7dbc90bac1ece8bcc81daa8040d7c2";
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date();
        /*String timestamp = sdf.format(date);
        int index = timestamp.indexOf(" ");
        timestamp = timestamp.substring(0,index) + "T" + timestamp.substring(index + 1,timestamp.length()) + "+08:00";*/
        long timestamp = new Date().getTime();
        //2021-08-04T11:30:53.567543+08:00
        Random random = new Random();
        //String nonce = '%s%s' % (int(time.time() * 1000), random.randint(1000, 9999))
        String nonce = String.valueOf(timestamp) + String.valueOf(random.nextInt(8999) + 1000);
        Map<String, Object> params = new HashMap<>();
        params.put("ip","10.0.0.1,10.0.0.2");
        params.put("orderId","aaabbbccc123456");
        params.put("companyName","集团");
        params.put("comment",null);
        try {
//            System.out.println(signatureWithParamsAndUrlPath(urlPath,params,secretKey,timestamp,nonce));
            return signatureWithParamsAndUrlPath(urlPath,params,secretKey,timestamp,nonce);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // 这里的secretKey 就是分配给你的秘钥
    public static String signatureWithParamsAndUrlPath(String urlPath, Map<String, Object> params, String secretKey, Long timestamp, String nonce) throws Exception{
        List<String> paramValueList = new ArrayList<String>();
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    paramValueList.add(entry.getKey() +"="+ entry.getValue());
                }
            }
        }

        Collections.sort(paramValueList);

        StringBuilder valueToDigest = new StringBuilder();
        valueToDigest.append(timestamp);
        valueToDigest.append('\n');
        valueToDigest.append(nonce);
        valueToDigest.append('\n');
        valueToDigest.append(urlPath);
        valueToDigest.append('\n');


        for (int i = 0; i < paramValueList.size(); i++) {
            if(i > 0){
                valueToDigest.append("&");
            }
            valueToDigest.append(paramValueList.get(i));
        }
        System.out.println(valueToDigest.toString());
        String charset = "UTF-8";
        Mac sha256_HMAC = null;
        sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(valueToDigest.toString().getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(array);
       /* return new String(common.Hex.encodeHex(
                common.HmacUtils.hmacSha1(secretKey.getBytes(charset), valueToDigest.toString().getBytes(charset)), false));*/
    }
}

