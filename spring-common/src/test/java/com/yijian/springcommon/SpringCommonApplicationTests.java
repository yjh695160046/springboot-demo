package com.yijian.springcommon;

import com.yijian.springcommon.utils.JwtUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class SpringCommonApplicationTests {

    @Test
    void contextLoads() {
        String genJwt = JwtUtils.genJwt();
        System.out.println(genJwt);
        System.out.println(JwtUtils.checkJwt(genJwt));
    }

    public static void main(String[] args) throws Exception{
        sendGetNoParam();
//        sendGet();
//        sendPost();

    }

    private static void sendPost() {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080/test/jrebel");
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
