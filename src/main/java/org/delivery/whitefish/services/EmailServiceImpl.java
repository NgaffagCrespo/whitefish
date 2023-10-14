package org.delivery.whitefish.services;

import org.delivery.whitefish.entities.EmailDelivery;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl implements EmailService {


    private JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailDelivery emailfun) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("theroypercy@gmail.com");
        message.setTo(emailfun.getToemail());

        emailfun.setBody("Nom \n" +emailfun.getClient().getName()+
                "Commande \n"+emailfun.getClient().getBills()+
                "Telephone \n"+emailfun.getClient().getTel()+
                "Nom du client \n"+emailfun.getClient().getName());

        emailfun.setSubject("Commande de poisson");

        message.setSubject(emailfun.getSubject());
        message.setText(emailfun.getBody());

        mailSender.send(message);
    }
}
