package com.yijian.kafka.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.yijian.demospringbootstarter.ServiceBean;
import com.yijian.kafka.config.KafkaMessageDto;
import com.yijian.kafka.config.Now;
import com.yijian.kafka.entity.Login;
import com.yijian.kafka.entity.NasUserBackup1Entity;
import com.yijian.kafka.kakfa.KafkaProducer;
import com.yijian.kafka.mapper.NasUserBackup1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/1 19:55
 * @Description:
 */
@RestController
@RequestMapping("/kafka")
public class HelloController {

    @Autowired
    private ServiceBean serviceBean;

    @Autowired
    private KafkaProducer<String, Object> kafkaProducer;

    @Resource
    private NasUserBackup1Mapper nasUserBackup1Mapper;

    @RequestMapping(value = "test02", method = RequestMethod.GET)
    public Object test02() {
        List<NasUserBackup1Entity> list = nasUserBackup1Mapper.selectList(new QueryWrapper<>());
        ////list.forEach(user-> test03(user));
        //test03(list.get(0));
        Login login = new Login();
        login.setMobile("15071415590");
        login.setActivateTime(Now.millis());
        //Map<String, Object> map = new HashMap<>();
        //map.put("messageId", UUID.randomUUID());
        //map.put("data", login);
        KafkaMessageDto dto = new KafkaMessageDto();
        dto.setMessageId(UUID.randomUUID().toString());
        dto.setData(login);
        kafkaProducer.send("activate", new Gson().toJson(dto));
        return list;
    }

    private void test03(NasUserBackup1Entity nasUserBackup1Entity) {
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", UUID.randomUUID());
        map.put("data", nasUserBackup1Entity);
        kafkaProducer.send("bizopen", new Gson().toJson(map));
    }

    @RequestMapping(value = "test01", method = RequestMethod.GET)
    public Object test01() {
        //nasUserBackupEntity.setStatus(UserStatus.OPEN_NOT_REGISTER);
        //nasUserBackupEntity.setMobile(registerUserData.get("mobile"));
        //nasUserBackupEntity.setBizId(registerUserData.get("bizId"));
        //nasUserBackupEntity.setAccount(registerUserData.get("account"));
        //nasUserBackupEntity.setCapacity(Long.parseLong(registerUserData.get("capacity")));
        //nasUserBackupEntity.setProvince(Integer.parseInt(registerUserData.get("province")));
        //// 市编码做特殊处理 截取前四位
        //nasUserBackupEntity.setCity(registerUserData.get("city").substring(0, 4));
        //nasUserBackupEntity.setBizopen("true".equals(registerUserData.get("bizOpen")) ? 1 : 0);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", UUID.randomUUID());
        Map<String, Object> s = new HashMap<>();
        s.put("mobile", "15071415590");
        s.put("mbizIdobile", "15071415590");
        s.put("account", "15071415590");
        s.put("capacity", "1");
        s.put("province", "330000");
        s.put("city", "330100");
        s.put("bizOpen", true);
        map.put("data", s);
        kafkaProducer.send("bizopen", new Gson().toJson(map));
        return "success";
    }

}
