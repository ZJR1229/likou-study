package common;

import java.util.*;

public class SecretKey {

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
        return new String(Hex.encodeHex(
                HmacUtils.hmacSha1(secretKey.getBytes(charset), valueToDigest.toString())));
    }


    public static void main(String[] args) throws Exception {
        // 毫秒数
        long timeStamp = System.currentTimeMillis();
        Random r = new Random();
        int num = r.nextInt();
        String nonce = num + timeStamp + "";

        // 初始化参数列表
        Map ipMap = new HashMap();
        ipMap.put("vmsn11123", "10.2.3.4");
        ipMap.put("vmsn983849", "10.0.3.3");

        Map<String, Object> map = new HashMap();
        map.put("orderId", "bf6eb9bc-33e1-4c69-98db-d07b74479a81");
        map.put("sysOwner", "AI");
        map.put("useType", "VM_SERVER_IP");
        map.put("companyName", "集团");
        map.put("netType", "PRIVATE");
        map.put("vmParams", ipMap);

        String urlPath = "http://ip.alibaba.net/ip/api/allocateVmipByNcip.json";

        String secretKey = "8e7dbc90bac1ece8bcc81daa8040d7c2";

        String singature = SecretKey.signatureWithParamsAndUrlPath(urlPath, map, secretKey, timeStamp, nonce);

            System.out.println("The signature is    " + singature);


    }
}
