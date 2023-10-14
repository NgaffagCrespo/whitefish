package org.delivery.whitefish.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.delivery.whitefish.entities.Bills;
import org.delivery.whitefish.entities.EmailDelivery;
import org.delivery.whitefish.services.BillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(path = "/deliveryWhiteFish")
public class BillsRestService {

    private BillService billService;

    @PostMapping(path = "/bills")
    public Bills storeBill(Bills bills){
        return billService.save(bills);
    }

    @GetMapping(path = "/bills")
    public List<Bills> AllBills(){
        return billService.AllBills();
    }

}
