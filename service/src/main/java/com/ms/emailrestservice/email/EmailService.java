package com.ms.emailrestservice.email;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
