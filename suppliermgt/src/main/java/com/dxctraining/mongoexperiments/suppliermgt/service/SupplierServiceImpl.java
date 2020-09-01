package com.dxctraining.mongoexperiments.suppliermgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public Supplier save(Supplier supplier) {
        System.out.println("using mongotemplate save");
        supplier = mongo.save(supplier);
        return supplier;
    }

    @Override
    public Supplier findById(String id) {
    	Supplier supplier = mongo.findById(id, Supplier.class);
        return supplier;
    }

    @Override
    public void removeById(String id) {
    	Supplier supplier=findById(id);
        mongo.remove(supplier);
       
    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier> list = mongo.findAll(Supplier.class);
        return list;
    }

   

    @Override
    public List<Supplier> findByName(String name) {
        Criteria criteria=Criteria.where("name").is(name) ;
        Query query = Query.query(criteria);
        List<Supplier> list = mongo.find(query, Supplier.class);
        return list;
    }

   

   
    
}
