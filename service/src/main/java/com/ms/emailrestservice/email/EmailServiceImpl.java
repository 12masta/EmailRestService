package com.ms.emailrestservice.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        if (to.equals("") || subject.equals("") || text.equals("")) {
            throw new MailParseException("Some of mail elements are empty");
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        sendMessage(message);
    }

    private void sendMessage(SimpleMailMessage mailMessage) {
        emailSender.send(mailMessage);
    }
}