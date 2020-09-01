package com.dxctraining.mongoexperiments.suppliermgt.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;

import java.util.List;

public interface ISupplierDao extends MongoRepository<Supplier,String> {

   

    List<Supplier> findByName(String name);

   

   
}
