package com.api.model.dashboard;

import java.io.Serializable;
import java.util.List;

public class CustomerListObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private List<CustomerObject> customerObject;


		public List<CustomerObject> getCustomerObject() {
			return customerObject;
		}


		public void setCustomerObject(List<CustomerObject> customerObject) {
			this.customerObject = customerObject;
		}

}
