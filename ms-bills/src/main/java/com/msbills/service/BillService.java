package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.models.BillAndUser;
import com.msbills.models.User;
import com.msbills.repositories.BillRepository;
import com.msbills.repositories.FeignUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

  private final BillRepository billRepository;
  private final FeignUserRepository feignUserRepository;

  public List<Bill> getAllBill() {
    return billRepository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return billRepository.save(bill);
  }

  public List<BillAndUser> findAllByUsername(String username) {
    User user = feignUserRepository.findByUsername(username);
    List<Bill> billsAndUser = billRepository.findByCustomerBill(username);
    List<BillAndUser> allBills = new ArrayList<>();


    for (Bill b : billsAndUser){
      BillAndUser billAndUser = new BillAndUser(b.getIdBill(), b.getBillingDate(), b.getTotalPrice(), user);
      allBills.add(billAndUser);
    }
    return allBills;
  }

}
