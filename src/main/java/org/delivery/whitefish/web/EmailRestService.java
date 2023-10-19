package org.delivery.whitefish.web;


import lombok.AllArgsConstructor;
import org.delivery.whitefish.entities.Bills;
import org.delivery.whitefish.entities.Client;
import org.delivery.whitefish.entities.EmailDelivery;
import org.delivery.whitefish.entities.Fish;
import org.delivery.whitefish.repositories.EmailDeliveryRepository;
import org.delivery.whitefish.services.BillService;
import org.delivery.whitefish.services.ClientService;
import org.delivery.whitefish.services.EmailService;
import org.delivery.whitefish.services.FishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/deliveryWhiteFish")
public class EmailRestService {

    private EmailService emailService;
    private ClientService clientService;
    private BillService billService;
    private EmailDeliveryRepository emailDeliveryRepository;
    private FishService fishService;

    @PostMapping(path="/email")
    public void triggerMail(@RequestBody EmailDelivery emailFun){

        emailFun.setId(UUID.randomUUID().toString());
        clientService.save(emailFun.getClient());
        emailDeliveryRepository.save(emailFun);

        // Parcour pour sauvegarder les poissons et les factures
        for(Bills bills: emailFun.getClient().getBills()){
            for(Fish fish: bills.getFishList()){
                fishService.save(fish);
            }
            billService.save(bills);
            
        }

        emailService.sendEmail(emailFun);
    }

}
