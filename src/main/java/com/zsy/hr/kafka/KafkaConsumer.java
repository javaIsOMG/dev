package com.zsy.hr.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Classname KafkaConsumer
 * @Description TODO
 * @Date 2020/3/25 16:24
 * @Created by Yinghao.He
 */
@Slf4j
@Component
public class KafkaConsumer {
    @KafkaListener(id = "PlaceTheOrder",topics = "test",groupId = "skill")
    public void kafkaListener(ConsumerRecord<?,?> record)  {

        String s = record.value().toString();
        String[] split = s.split("hello");
        if (StringUtils.isEmpty(split)){
            return;
        }
        try{
            String courseNo=split[0];
            String  userString=split[1];
            log.info("消费成功");
        }catch (Exception e){
            log.info("消费失败"+s);
        }

    }
}
