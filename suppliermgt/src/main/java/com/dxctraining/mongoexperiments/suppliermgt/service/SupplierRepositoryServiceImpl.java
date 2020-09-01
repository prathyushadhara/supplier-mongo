package com.dxctraining.mongoexperiments.suppliermgt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.mongoexperiments.suppliermgt.dao.ISupplierDao;
import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;
import com.dxctraining.mongoexperiments.suppliermgt.exceptions.SupplierNotFoundException;

import java.util.List;
import java.util.Optional;

public class SupplierRepositoryServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier save(Supplier supplier) {
		supplier = dao.save(supplier);
		return supplier;
	}

	@Override
	public Supplier findById(String id) {
		Optional<Supplier> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new SupplierNotFoundException("supplier not found for id=" + id);
		}
		Supplier supplier = optional.get();
		return supplier;
	}

	@Override
	public List<Supplier> findAll() {
		List<Supplier> list = dao.findAll();
		return list;
	}

	@Override
	public List<Supplier> findByName(String name) {
		List<Supplier> list = dao.findByName(name);
		return list;
	}

	@Override
	public void removeById(String id) {
		dao.deleteById(id);
	}
}
