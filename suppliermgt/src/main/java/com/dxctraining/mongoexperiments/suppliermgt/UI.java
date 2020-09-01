package com.dxctraining.mongoexperiments.suppliermgt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliermgt.service.ISupplierService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UI {
	@Autowired
	private ISupplierService service;

	@PostConstruct
	public void start() {

		Supplier supplier1 = new Supplier("prathyusha");
		supplier1 = createSupplier(supplier1);
		String id1 = supplier1.getId();

		Supplier supplier2 = new Supplier("chinni");
		supplier2 = createSupplier(supplier1);
	

		Supplier supplier3 = new Supplier("sailaja");
		supplier3 = createSupplier(supplier3);
	
		 
		String id2 = supplier2.getId();
		displaySupplierById(id1);
		displaySupplierById(id2);

		displayAll();

	}

	void displayAll() {
		System.out.println("********displayAll");
		List<Supplier> list = service.findAll();
		for (Supplier supplier : list) {
			displaySupplier(supplier);
		}
	}

	void displaySupplier(Supplier supplier) {
		System.out.println("supplier=" + supplier.getId() + " name=" + supplier.getName());

	}

	public void displaySupplierById(String id) {
		System.out.println("*****displaySupplierById");
		Supplier supplier = service.findById(id);
		displaySupplier(supplier);
	}

	public Supplier createSupplier(Supplier supplier) {
		System.out.println("*********creatsupplier");
		supplier = service.save(supplier);
		displaySupplier(supplier);
		return supplier;
	}

}
