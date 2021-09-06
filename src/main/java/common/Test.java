package common;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        sendPost();
    }

    public static void sendPost(){
        //创建post请求对象
//        "http://ip.alibaba.net/ip/api/releaseIpAddress.json"
        HttpPost post = new HttpPost("http://ip.alibaba.net/ip/api/releaseIpAddress.json");
        try {
            // 时间戳
            long timeStamp = System.currentTimeMillis();
            Random r = new Random();
            int num = r.nextInt();
            // 根据时间戳添加随机数生成nonce
            String nonce = num + timeStamp + "";

            // 初始化参数列表
//            Map ipMap = new HashMap();
//            ipMap.put("vmsn11123", "10.2.3.4");
//            ipMap.put("vmsn983849", "10.0.3.3");

//            申请
//            Map<String, Object> map = new HashMap();
//            map.put("orderId", "bf6eb9bc-33e1-4c69-98db-d07b74479a81");
//            map.put("sysOwner", "AI");
//            map.put("useType", "VM_SERVER_IP");
//            map.put("companyName", "集团");
//            map.put("netType", "PRIVATE");
//            map.put("vmParams", ipMap);

//            释放
            Map<String, Object> map = new HashMap<>();
            map.put("ip", "10.0.0.1,10.0.0.2");
            map.put("orderId", "aaabbbccc123456");
            map.put("companyName", "集团");
            map.put("Comment", null);


            // 传入url
            //"http://ip.alibaba.net/ip/api/releaseIpAddress.json"
            String urlPath = "/ip/api/releaseIpAddress.json";
            // 密钥
            String secretKey = "8e7dbc90bac1ece8bcc81daa8040d7c2";
            // 根据密钥获得签名
            String singature = SecretKey.signatureWithParamsAndUrlPath(urlPath, map, secretKey, timeStamp, nonce);
            System.out.println("singature is " + singature);


            //创建参数集合
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            //添加参数
//            list.add(new BasicNameValuePair("orderId", "d5566fc6-f2aa-4302-a862-e75258a5e689"));
//            list.add(new BasicNameValuePair("sysOwner", "AI"));
//            list.add(new BasicNameValuePair("companyName", "集团"));
//            list.add(new BasicNameValuePair("netType", "PRIVATE"));
//            list.add(new BasicNameValuePair("vmParams", ipMap.toString()));

//          释放IP参数
            list.add(new BasicNameValuePair("ip", "10.0.0.1,10.0.0.2"));
            list.add(new BasicNameValuePair("orderId", "aaabbbccc123456"));
            list.add(new BasicNameValuePair("companyName", "集团"));
            list.add(new BasicNameValuePair("Comment", null));

            //把参数放入请求对象，，post发送的参数list，指定格式
            post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));

//            String singature = common.ACL.getSign();
            //添加请求头参数
            post.addHeader("X-Hmac-Auth-Secret-Id","test");
            post.addHeader("X-Hmac-Auth-Timestamp",timeStamp + "");
            post.addHeader("X-Hmac-Auth-Nonce", nonce);
            post.addHeader("X-Hmac-Auth-Signature", singature);


            CloseableHttpClient client = HttpClients.createDefault();
            //启动执行请求，并获得返回值
            CloseableHttpResponse response = client.execute(post);
            //得到返回的entity对象
            HttpEntity entity = response.getEntity();
            //把实体对象转换为string
            String result = EntityUtils.toString(entity, "UTF-8");
            //返回内容
            System.out.println(result);
        } catch (Exception e1) {
            e1.printStackTrace();

        }
    }
}