package com.dxctraining.mongoexperiments.suppliermgt.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dxctraining.mongoexperiments.suppliermgt.dto.CreateSupplierRequest;
import com.dxctraining.mongoexperiments.suppliermgt.dto.SupplierDto;
import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliermgt.service.ISupplierService;
import com.dxctraining.mongoexperiments.suppliermgt.util.SupplierUtil;

@RequestMapping("/suppliers")
@RestController
public class SupplierRestController {

    @Autowired
    private ISupplierService service;

    @Autowired
    private SupplierUtil util;

   
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierDto create(@RequestBody CreateSupplierRequest requestData) {
       
    	Supplier supplier=new Supplier(requestData.getName());
    	supplier=service.save(supplier);
    	SupplierDto response=util.supplierDto(supplier);
        return response;
    }


    @GetMapping("/get/{id}")
    public SupplierDto findSupplier(@PathVariable("id") String id) {
    	Supplier supplier = service.findById(id);
    	SupplierDto response = util.supplierDto(supplier);
        return response;
    }


}
