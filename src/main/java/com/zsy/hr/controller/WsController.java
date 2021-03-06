package com.zsy.hr.controller;

import com.zsy.hr.domian.dto.ChatMsg;
import com.zsy.hr.domian.po.Hr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.Date;

/**
 * @program: hr
 * @description:
 * @author: 张思远
 * @create: 2020-03-26 20:16
 */
@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Hr hr, ChatMsg chatMsg) {
        chatMsg.setFrom(hr.getUsername());
        chatMsg.setFromNickname(hr.getName());
        chatMsg.setDate(new Date());
        messagingTemplate.convertAndSendToUser( chatMsg.getTo(), "/queue/chat", chatMsg);
    }
}
