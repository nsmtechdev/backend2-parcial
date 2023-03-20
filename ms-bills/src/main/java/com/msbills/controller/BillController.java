package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.models.BillAndUser;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

  private final BillService service;

  @GetMapping("/all")
  @PreAuthorize("hasAuthority('GROUP_provider')")
  public ResponseEntity<List<Bill>> getAll() {
    return ResponseEntity.ok().body(service.getAllBill());
  }


  @PostMapping()
  @PreAuthorize("hasAuthority('GROUP_PROVIDER') AND hasRole('ROLE_PROVIDER')")
  public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
    return ResponseEntity.ok().body(service.saveBill(bill));
  }

  @GetMapping("/detail/{username}")
  @PreAuthorize("hasAuthority('GROUP_CLIENT') AND hasRole('ROLE_CLIENT')")
  public List<BillAndUser> findAllByUsername(@PathVariable("username") String username){
    return service.findAllByUsername(username);
    }

  }



