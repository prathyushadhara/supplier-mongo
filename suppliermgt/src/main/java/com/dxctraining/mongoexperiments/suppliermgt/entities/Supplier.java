package com.dxctraining.mongoexperiments.suppliermgt.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("suppliers")
public class Supplier {

	@Id
	private String id;

	private String name;

	public Supplier() {

	}

	public Supplier(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Supplier supplier = (Supplier) o;
		return Objects.equals(id, supplier.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
