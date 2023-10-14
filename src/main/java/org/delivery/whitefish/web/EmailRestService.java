package org.delivery.whitefish.web;


import lombok.AllArgsConstructor;
import org.delivery.whitefish.entities.Bills;
import org.delivery.whitefish.entities.EmailDelivery;
import org.delivery.whitefish.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/deliveryWhiteFish")
public class EmailRestService {

    private EmailService emailService;

    @PostMapping(path="/email")
    public void triggerMail(@RequestBody EmailDelivery emailFun){
        BillsRestService billsRestService = new BillsRestService();

        for(Bills bills: emailFun.getClient().getBills()){
            billsRestService.storeBill(bills);
        }
        emailService.sendEmail(emailFun);

    }

}
