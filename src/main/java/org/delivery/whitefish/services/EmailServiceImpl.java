package org.delivery.whitefish.services;

import org.delivery.whitefish.entities.EmailDelivery;
import org.delivery.whitefish.repositories.EmailDeliveryRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailDelivery emailfun) {


        emailfun.setSubject("Commande de poisson");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("manager@whitefishesdelivery.com");
        message.setTo(emailfun.getToemail());


        emailfun.setBody("Nom \n" +emailfun.getClient().getName()+
                "\n Commande \n"+emailfun.getClient().getBills()+
                "Telephone \n"+emailfun.getClient().getTel()+
                "Nom du client \n"+emailfun.getClient().getName());

        message.setText(emailfun.getBody());
        message.setSubject(emailfun.getSubject());
        System.out.println("Mail in sending...");

        mailSender.send(message);
    }
}
