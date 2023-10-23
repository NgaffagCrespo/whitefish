package org.delivery.whitefish.services;

import org.delivery.whitefish.entities.Bills;
import org.delivery.whitefish.repositories.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bills save(Bills bills) {

        bills.setId(UUID.randomUUID().toString());
        bills.setDate_bill(new Date());

        Bills savedBill = billRepository.save(bills);

        return savedBill;
    }

    @Override
    public List<Bills> AllBills() {

        List<Bills> billsList = billRepository.findAll();

        return billsList;
    }
}
