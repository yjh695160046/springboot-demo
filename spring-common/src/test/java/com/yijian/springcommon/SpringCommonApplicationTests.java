package com.yijian.springcommon;

import com.yijian.springcommon.service.OrderService;
import com.yijian.springcommon.utils.JwtUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class SpringCommonApplicationTests {

    private static final Pattern DECIMAL_PATTERN = Pattern.compile("[0-9]*\\.?[0-9]+");
    @Test
    void contextLoads() {
        String genJwt = JwtUtils.genJwt();
        System.out.println(genJwt);
        System.out.println(JwtUtils.checkJwt(genJwt));
    }
    @Resource(name = "orderServiceImpl")
    private OrderService orderService;

    @Test
    public void injection(){
        System.out.println(orderService);
    }
    public static void main(String[] args) throws Exception{
//        sendGetNoParam();
//        sendGet();
//        sendPost();
        System.out.println(1<2);
        String mobile = "15071415590";
        System.out.println(mobile.substring(mobile.length() -4));
        if (null instanceof String) {
            System.out.println("null");
        }
         String forwardUrl = "https://hzforward.zjip.com";
            forwardUrl = forwardUrl.split("\\.")[0] + ".zjdrive.cn";
        System.out.println(forwardUrl);
        System.out.println(setVersion("1.6"));

           String kxDirectory = "/test/";
        String md5KxDirectory = kxDirectory;
        if (md5KxDirectory.endsWith("/")) {
            md5KxDirectory = md5KxDirectory.substring(0, md5KxDirectory.length() -1);
        }
        System.out.println(md5KxDirectory);
        System.out.println(Runtime.getRuntime().availableProcessors());

        String areaNo = "330100";
        String configArea = areaNo.substring(0, 2) + "0000";
        System.out.println(configArea);

        if (StringUtils.isAllBlank("  ", "  ")){
            System.out.println(1111);
        }
    }

    public static int setVersion(String version) {
        if (StringUtils.isNotBlank(version) && isNumeric(version)) {
            return new Double(version).intValue();
        }
        return 2;
    }


    /**
     * 判断是否小数或整数
     * @param str 字符串
     * @return int
     */
    public static boolean isNumeric(String str){
        Matcher isNum = DECIMAL_PATTERN.matcher(str);
        return isNum.matches();
    }
//    void  test(){
//        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
//        //设置请求超时时间
//        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000)
//                .setConnectionRequestTimeout(60000)
//                .build();
//
//        try {
//            HttpPost post = new HttpPost("http://localhost:8012/testPost");
//            post.setConfig(requestConfig);
//            //发送的参数数据
//            //设置发送的数据
//            StringEntity s = new StringEntity(Gsons.toJson(body));
//            s.setContentEncoding("UTF-8");
//            s.setContentType("application/json");//发送json数据需要设置contentType
//            post.setEntity(s);
//            //获取返回值
//            CloseableHttpResponse res = closeableHttpClient.execute(post);
//            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
//              logger.info("POST请求返回的数据是："+result);
//            }
//        }
//        catch (Exception e){
////            logger.info("发生了异常："+e.getMessage());
//        }
//        finally {
//            try {                //关闭流并释放资源
//                closeableHttpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private static void sendPost() {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080/test/jrebel");
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");



        try (CloseableHttpResponse response = httpClient.execute(httpPost)){
            if (response.getStatusLine().getStatusCode() == 200){
//                System.out.println(EntityUtils.toString(response.getEntity()));
//                System.out.println(EntityUtils.toString(response.getEntity()));
//                System.out.println(EntityUtils.toString(response.getEntity()));
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\baidu-param.html"), content, "UTF-8");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void sendGet() throws URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URI build = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();
        try (CloseableHttpResponse response = httpClient.execute(new HttpGet(build))){
            if (response.getStatusLine().getStatusCode() == 200){
//                System.out.println(EntityUtils.toString(response.getEntity()));
//                System.out.println(EntityUtils.toString(response.getEntity()));
//                System.out.println(EntityUtils.toString(response.getEntity()));
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\baidu-param.html"), content, "UTF-8");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void sendGetNoParam() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://apicapacity.51iwifi.com/rest?method=capacity.nas.cloud.file.list&v=1.0.0&appId=a11b02a0217491c95b2e&accessToken=C46A6C92696D3987156BDF78B1FC5AFC&timestamp=2021-08-11T17:25:20.841&sign=6F7B87A30B0EDEF6FC07DB1D99391A3B");
        try (CloseableHttpResponse response = httpClient.execute(httpGet)){
            if (response.getStatusLine().getStatusCode() == 200){
                System.out.println(EntityUtils.toString(response.getEntity()));
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\devtest\\baidu-param.html"), content, "UTF-8");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
