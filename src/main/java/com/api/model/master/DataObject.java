package com.api.model.master;

import java.io.Serializable;
import java.util.List;

public class DataObject implements Serializable {

	private static final long serialVersionUID = 2427839129268442701L;

	
	private List<CountryObject> countryObject;
	
	private List<ProductObject> productObject;

	public List<CountryObject> getCountryObject() {
		return countryObject;
	}

	public void setCountryObject(List<CountryObject> countryObject) {
		this.countryObject = countryObject;
	}

	public List<ProductObject> getProductObject() {
		return productObject;
	}

	public void setProductObject(List<ProductObject> productObject) {
		this.productObject = productObject;
	}

}
