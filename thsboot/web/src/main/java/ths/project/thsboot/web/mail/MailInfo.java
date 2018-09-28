package ths.project.thsboot.web.mail;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: wangrd
 * @since: 2018年09月21日 13:20:59
 */
@Component
@ConfigurationProperties(prefix = "define.mail")
@PropertySource("classpath:mail.properties")
public class MailInfo {

    private String mailTo;

    private String mailFrom;

    private String subject;

    private Date sendDate;

    private String text;

    /**
     * @return the mailTo
     */
    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    /**
     * @return the mailFrom
     */
    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the sendDate
     */
    public Date getSendDate() {
        return new Date();
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
