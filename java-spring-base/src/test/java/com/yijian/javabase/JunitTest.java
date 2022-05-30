package com.yijian.javabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yaojinhua
 * @date: 2021/5/6 14:27
 * @description:
 */
@SpringBootTest
public class JunitTest {

    @Resource
    private ApplicationContext applicationContext;
    //@Resource
    //private RedisTemplate<Object, Object> redisTemplate;

    //@Resource
    //private RestTemplate restTemplate;

    @Test
    public void tests() throws ParseException {

        //ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        //A a = classPathXmlApplicationContext.getBean(A.class);
        //System.out.println(a);
        //System.out.println(applicationContext);
        //A bean = applicationContext.getBean(A.class);
        //System.out.println(bean);
        //System.out.println(redisTemplate);
        //redisTemplate.opsForValue().set("tet", 111);


        // 1.根据小程序临时登录凭证 获取openId和h5appSession
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // headers.add("X-H5App-ID", "f144c1b9");
        // String time = String.valueOf(System.currentTimeMillis());
        // headers.add("X-H5App-Timestamp", time);
        // TreeMap<String, String> map = new TreeMap<>();
        // map.put("X-H5App-ID", "f144c1b9");
        // map.put("X-H5App-Timestamp", time);
        // map.put("h5appCode", "123");
        // headers.add("X-H5App-Signature", NasSignUtil.createSignature(map));
        // HttpEntity<String> requestEntity = new HttpEntity<>("123", headers);
        // RestTemplate restTemplate = new RestTemplate();
        // JSONObject jsonObject = restTemplate.postForObject("https://miniapp.cloud.189.cn/platform/auth/api/open/code2Session", requestEntity, JSONObject.class);
        // System.out.println(jsonObject);


        System.out.println(dateToStamp("2022-04-05 23:59:59"));

    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
}
