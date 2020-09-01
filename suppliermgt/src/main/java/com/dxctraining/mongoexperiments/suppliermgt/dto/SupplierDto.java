package com.dxctraining.mongoexperiments.suppliermgt.dto;

public class SupplierDto {
	private String id;

	private String name;

	public SupplierDto() {

	}

	public SupplierDto(String id, String name) {
		this.id = id;
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

}
