package org.delivery.whitefish.services;

import org.delivery.whitefish.entities.Bills;

import java.util.List;

public interface BillService {

    Bills save(Bills bills);

    List<Bills> AllBills();

}
