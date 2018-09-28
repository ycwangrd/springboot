package ths.project.thsboot.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ths.project.thsboot.web.mail.MailInfo;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;

/**
 * @author: wangrd
 * @since: 2018年09月21日 11:59:15
 */
@RestController
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    /* 发送邮件的自定义配置信息 */
    @Autowired
    private MailInfo mailInfo;

    /**
     * 邮件发送相关
     *
     * @return
     */
    @GetMapping("/mail/send")
    public String mailSend() {
        String msg = HttpStatus.OK.getReasonPhrase();
        try {
            //建立邮件消息
            SimpleMailMessage message = new SimpleMailMessage();
            //发送者
            message.setFrom(mailInfo.getMailFrom());
            //接收者
            message.setTo(mailInfo.getMailTo());
            //发送的标题
            message.setSubject(mailInfo.getSubject());
            //发送的内容
            message.setText(mailInfo.getSubject());
            message.setSentDate(mailInfo.getSendDate());
            javaMailSender.send(message);
        } catch (Exception e) {
            msg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            e.printStackTrace();
            logger.error(e.toString());
        }
        return msg;
    }

    /**
     * 多媒体邮件发送
     *
     * @return
     */
    @GetMapping(value = "/mail/mixedSend")
    public String mixedMailSend() {
        String msg = HttpStatus.OK.getReasonPhrase();
        try {
            MimeMessage mailMsg = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMsg, true, "UTF-8");
            messageHelper.setFrom(mailInfo.getMailFrom());// 发送邮箱  
            messageHelper.setTo(mailInfo.getMailTo());// 接收邮箱  
            messageHelper.setSentDate(mailInfo.getSendDate());// 发送时间  
            messageHelper.setSubject(mailInfo.getSubject());// 邮件标题  
            // true 表示启动HTML格式的邮件  
            messageHelper.setText(mailInfo.getText(), true);// 邮件内容 
            // 添加邮件附件
            File file = new File(getClass().getClassLoader().getResource("/application.properties").getFile());
            FileSystemResource rarfile = new FileSystemResource(file);
            // addAttachment addInline 两种附件添加方式  
            // 以附件的形式添加到邮件  
            // 使用MimeUtility.encodeWord 解决附件名中文乱码的问题  
            messageHelper.addAttachment(MimeUtility.encodeWord("给我自己发邮件也被当做垃圾,网易真傻逼"), rarfile);
            messageHelper.addInline("file", rarfile);
            javaMailSender.send(mailMsg);
        } catch (Exception e) {
            msg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            e.printStackTrace();
            logger.error(e.toString());
        }
        return msg;
    }
}
