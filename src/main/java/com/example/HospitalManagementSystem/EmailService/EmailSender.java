package com.example.HospitalManagementSystem.EmailService;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOtp(String toEmail,String otp){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ishantkarmacharya@gmail.com");
        message.setTo(toEmail);
        message.setSubject("OTP(One Time Password");
        message.setText("Your otp is "+ otp);
        message.setText("do not share with anyone ");

        javaMailSender.send(message);
    }
}
