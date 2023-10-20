package org.delivery.whitefish.services;

import org.delivery.whitefish.entities.Bills;
import org.delivery.whitefish.entities.EmailDelivery;
import org.delivery.whitefish.entities.Fish;
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
        emailfun.setToemail("gerante@whitefishesdelivery.com");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("manager@whitefishesdelivery.com");
        message.setTo(emailfun.getToemail());
        message.setSubject(emailfun.getSubject());


            for(Bills bills : emailfun.getClient().getBills()) {
                for (Fish fish : bills.getFishList()) {

                    emailfun.setBody("Montant total de la facture \n" + bills.getAmount() +" FCF"+
                            "\nNom du poisson \n" + fish.getName() +
                            "\nQuantite \n" + fish.getQuantity() +
                            "\nPrix unitaire de poisson \n" + fish.getUnit_price() +
                            "\nNumero de téléphone du client \n" + emailfun.getClient().getTel() +
                            "\nQuartier du client \n" + emailfun.getClient().getLocalisation() +
                            "\nNom du client \n" + emailfun.getClient().getName());
                }

                message.setText(emailfun.getBody());

                mailSender.send(message);

            }
    }
}
